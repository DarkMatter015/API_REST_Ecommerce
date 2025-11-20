package br.edu.utfpr.pb.ecommerce.server_ecommerce.client.melhorEnvioAPI.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class MelhorEnvioFeignConfig {

    @Value("${MELHOR_ENVIO_API_TOKEN}")
    private String token;

    @Bean
    public RequestInterceptor melhorEnvioAuthInterceptor() {
        return template -> {
            template.header("Authorization", "Bearer " + token);
            template.header("Accept", "application/json");
            template.header("Content-Type", "application/json");
        };
    }
}
