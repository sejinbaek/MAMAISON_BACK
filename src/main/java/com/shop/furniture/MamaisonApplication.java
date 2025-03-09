package com.shop.furniture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config/secu.properties")
public class MamaisonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MamaisonApplication.class, args);
	}

}
