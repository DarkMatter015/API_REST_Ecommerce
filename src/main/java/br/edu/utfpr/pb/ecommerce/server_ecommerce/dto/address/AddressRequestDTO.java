package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {
    private Long id;

//    private User user;

    @NotNull
    @Size(min = 3, max = 255)
    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

    private String cep;
}
