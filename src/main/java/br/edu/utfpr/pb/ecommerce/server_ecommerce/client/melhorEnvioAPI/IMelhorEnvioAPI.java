package br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.config.MelhorEnvioFeignConfig;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.dto.request.ShipmentRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.dto.response.ShipmentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "melhorEnvioApi",
        url = "${MELHOR_ENVIO_API_URL}",
        configuration = MelhorEnvioFeignConfig.class
)
public interface IMelhorEnvioAPI {
    @PostMapping("/shipment/calculate")
    List<ShipmentResponseDTO> calculateFreightByProducts(@RequestBody @Valid ShipmentRequestDTO request);
}
