package br.edu.utfpr.pb.ecommerce.server_ecommerce.client.brasilAPI.service;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.brasilAPI.IBrasilAPI;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.brasilAPI.dto.AddressCEP;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CepService {

    private final IBrasilAPI brasilApi;

    public AddressCEP getAddressByCEP(String cep) {
            return brasilApi.getAddressByCEP(cep);
    }
}
