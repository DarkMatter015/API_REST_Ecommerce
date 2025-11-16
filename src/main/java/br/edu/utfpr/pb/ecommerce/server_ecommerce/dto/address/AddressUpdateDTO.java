package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressUpdateDTO {

    private String number;

    private String complement;
}
