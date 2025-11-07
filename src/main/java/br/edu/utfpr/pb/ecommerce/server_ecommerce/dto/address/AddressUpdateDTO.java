package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressUpdateDTO {

    @Size(min = 3, max = 255)
    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    @Size(min = 3, max = 255)
    private String city;

    @Size(min = 2, max = 255)
    private String state;

    @Pattern(regexp = "\\d{8}", message = "{field.cep.pattern}")
    private String cep;
}
