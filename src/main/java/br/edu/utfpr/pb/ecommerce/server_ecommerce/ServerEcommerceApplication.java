package br.edu.utfpr.pb.ecommerce.server_ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ServerEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerEcommerceApplication.class, args);
	}

}
