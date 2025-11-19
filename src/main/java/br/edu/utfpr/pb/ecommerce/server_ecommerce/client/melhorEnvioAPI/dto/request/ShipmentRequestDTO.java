package br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentRequestDTO {

    @NotNull
    private PostalCodeRequest from;
    @NotNull
    private PostalCodeRequest to;
    @NotEmpty
    private List<ShipmentProductRequest> products;
}