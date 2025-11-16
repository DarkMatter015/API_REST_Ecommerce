package br.edu.utfpr.pb.ecommerce.server_ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
@EnableFeignClients
public class ServerEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerEcommerceApplication.class, args);
	}

}
