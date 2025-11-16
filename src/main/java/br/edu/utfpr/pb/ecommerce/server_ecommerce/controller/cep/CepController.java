package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.cep;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.CepNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.AddressCEP;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
@RequiredArgsConstructor
public class CepController {

    private final CepService cepService;

    @GetMapping("/validate/{cep}")
    public ResponseEntity<AddressCEP> getAddressByCEP(@PathVariable String cep) {

        try {
            AddressCEP address = cepService.getAddressByCEP(cep);
            return ResponseEntity.ok(address);
        } catch (Exception ex) {
            throw new CepNotFoundException("CEP not found or invalid.");
        }
    }
}
