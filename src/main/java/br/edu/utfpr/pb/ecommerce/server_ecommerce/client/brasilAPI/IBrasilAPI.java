package br.edu.utfpr.pb.ecommerce.server_ecommerce.client.brasilAPI;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.brasilAPI.dto.AddressCEP;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "brasilApi",
        url = "${BRASIL_API_URL}"
)
public interface IBrasilAPI {
    @GetMapping("cep/v2/{cep}")
    AddressCEP getAddressByCEP(@PathVariable String cep);
}
