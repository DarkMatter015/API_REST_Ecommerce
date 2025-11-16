package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {

    @NotBlank
    @Positive
    private String number;

    private String complement;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "{field.cep.pattern}")
    private String cep;
}
