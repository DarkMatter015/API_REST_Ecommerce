package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address;

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

    @NotNull
    @Size(min = 3, max = 255)
    private String street;

    @NotNull
    private String number;

    private String complement;

    private String neighborhood;

    @NotNull
    @Size(min = 3, max = 255)
    private String city;

    @NotNull
    @Size(min = 3, max = 255)
    private String state;

    private String cep;
}
