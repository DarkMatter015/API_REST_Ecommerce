package br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.dto.response;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.util.BigDecimalDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.List;

public record PackageResponse(

        @JsonDeserialize(using = BigDecimalDeserializer.class)
        BigDecimal price,

        @JsonDeserialize(using = BigDecimalDeserializer.class)
        BigDecimal discount,

        String format,

        @JsonDeserialize(using = BigDecimalDeserializer.class)
        BigDecimal weight,

        @JsonDeserialize(using = BigDecimalDeserializer.class)
        BigDecimal insuranceValue,

        List<ProductItemResponse> products,

        DimensionsResponse dimensions
) {}