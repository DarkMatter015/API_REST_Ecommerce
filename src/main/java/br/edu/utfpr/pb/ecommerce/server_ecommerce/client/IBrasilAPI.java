package br.edu.utfpr.pb.ecommerce.server_ecommerce.client;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.AddressCEP;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brasil-api", url = "https://brasilapi.com.br/api/")
public interface IBrasilAPI {
    @GetMapping("cep/v2/{cep}")
    AddressCEP getAddressByCEP(@PathVariable String cep);
}
