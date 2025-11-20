package br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.controller;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.dto.request.ShipmentRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.dto.response.ShipmentResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.service.MelhorEnvioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment")
@RequiredArgsConstructor
public class ShipmentController {
    private final MelhorEnvioService melhorEnvioService;

    @PostMapping("/products")
    public ResponseEntity<List<ShipmentResponseDTO>> calculateShipmentByProducts(@RequestBody ShipmentRequestDTO shipmentRequestDto) {
        List<ShipmentResponseDTO> responses = melhorEnvioService.calculateShipmentByProducts(shipmentRequestDto);
        return ResponseEntity.ok(responses);
    }
}
