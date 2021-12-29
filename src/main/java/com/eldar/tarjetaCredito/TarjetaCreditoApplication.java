package com.eldar.tarjetaCredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TarjetaCreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarjetaCreditoApplication.class, args);
	}

}
