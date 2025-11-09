package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {

    @NotBlank
    @Size(min = 3, max = 255)
    private String street;

    @NotBlank
    private String number;

    private String complement;

    @NotBlank
    private String neighborhood;

    @NotBlank
    @Size(min = 3, max = 255)
    private String city;

    @NotBlank
    @Size(min = 2, max = 255)
    private String state;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "{field.cep.pattern}")
    private String cep;
}
