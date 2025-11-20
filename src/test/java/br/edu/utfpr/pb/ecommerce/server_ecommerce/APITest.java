package br.edu.utfpr.pb.ecommerce.server_ecommerce;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class APITest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepository userRepository;

    private User authenticatedUser;

    @BeforeEach
    public void setup() {
        this.authenticatedUser = userRepository.findByEmail("admin@teste.com");
    }

    private String obtainAccessToken(String email, String password) {
        var loginRequest = Map.of(
                "email", email,
                "password", password
        );

        ResponseEntity<Map> response = testRestTemplate
                .postForEntity("/auth/login", loginRequest, Map.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody());

        return (String) response.getBody().get("token");
    }

    private HttpHeaders createHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    // --- Categoria ---
    @Test
    public void getCategories_whenCalled_receiveList() {
        ResponseEntity<Object[]> response =
                testRestTemplate.getForEntity("/categories", Object[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();
    }

    // --- Produtos ---
    @Test
    public void getProducts_whenCalled_receiveList() {
        ResponseEntity<Object[]> response =
                testRestTemplate.getForEntity("/products", Object[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    public void getProductById_whenIdExists_receiveProduct() {
        ResponseEntity<Object> response =
                testRestTemplate.getForEntity("/products/1", Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    // --- Usuário ---
    @Test
    public void postUser_whenUserIsValid_receiveCREATED() {
        User user = new User();
        user.setDisplayName("new-user");
        user.setEmail("new@teste.com");
        user.setPassword("P4ssword1A");

        ResponseEntity<Object> response =
                testRestTemplate.postForEntity("/users", user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertNotNull(response.getBody());
        assertThat(response.getBody().equals(UserResponseDTO.class));
    }

    // --- Endereço ---
    @Test
    public void postAddress_whenUserAuthenticated_addressSaved() {
        String token = obtainAccessToken("admin@teste.com", "123456");

        AddressRequestDTO address = new AddressRequestDTO();
        address.setCep("85501000");
        address.setNumber("123");

        ResponseEntity<Object> response =
                testRestTemplate.postForEntity(
                        "/addresses",
                        new HttpEntity<>(address, createHeaders(token)),
                        Object.class
                );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    // --- Pedido ---
    @Test
    public void postOrder_whenUserAuthenticated_orderSaved() {
        String token = obtainAccessToken("admin@teste.com", "123456");
        String orderJson = """
                {
                    "orderItems": [
                        {
                        "productId": 1,
                        "quantity": 1
                        }
                    ],
                    "address": {
                        "number": "573",
                        "cep":  "85503359"
                    },
                    "paymentId": 1
                }
                """;

        ResponseEntity<OrderResponseDTO> response =
                testRestTemplate
                        .postForEntity(
                                "/orders",
                                new HttpEntity<>(orderJson, createHeaders(token)),
                                OrderResponseDTO.class
                        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void getOrders_whenUserAuthenticated_receiveOnlyUserOrders() {
        String token = obtainAccessToken("admin@teste.com", "123456");
        HttpHeaders headers = createHeaders(token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Object[]> response = testRestTemplate.exchange(
                "/orders",
                HttpMethod.GET,
                entity,
                Object[].class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
