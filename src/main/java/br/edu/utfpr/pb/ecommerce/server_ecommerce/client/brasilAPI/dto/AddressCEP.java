package br.edu.utfpr.pb.ecommerce.server_ecommerce.client.brasilAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressCEP {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
}
