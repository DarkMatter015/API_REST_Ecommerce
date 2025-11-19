package br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.dto.request;

import java.math.BigDecimal;

public record ShipmentProductRequest(
        String id,
        BigDecimal width,
        BigDecimal height,
        BigDecimal length,
        BigDecimal insurance_value,
        Integer quantity
) {}