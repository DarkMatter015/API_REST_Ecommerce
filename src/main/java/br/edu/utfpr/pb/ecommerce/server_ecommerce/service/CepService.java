package br.edu.utfpr.pb.ecommerce.server_ecommerce.service;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.IBrasilAPI;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.AddressCEP;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CepService {

    private final IBrasilAPI brasilApi;

    @Cacheable(value = "cep", key = "#cep")
    public AddressCEP getAddressByCEP(String cep) {
            return brasilApi.getAddressByCEP(cep);

    }
}
