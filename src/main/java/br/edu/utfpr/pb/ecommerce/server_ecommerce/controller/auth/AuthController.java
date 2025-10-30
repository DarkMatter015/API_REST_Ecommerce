package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.auth;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.security.dto.AuthenticationResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.security.dto.SecurityUserResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/validate")
    public ResponseEntity<AuthenticationResponseDTO> validateToken() {
        try {
            User user = authService.getAuthenticatedUser();

            AuthenticationResponseDTO response = new AuthenticationResponseDTO();
            response.setUser(new SecurityUserResponseDTO(user));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }

}
