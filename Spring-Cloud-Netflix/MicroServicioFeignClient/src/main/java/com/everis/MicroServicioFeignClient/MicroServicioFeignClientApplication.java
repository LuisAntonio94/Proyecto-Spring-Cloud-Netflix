package com.everis.MicroServicioFeignClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroServicioFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioFeignClientApplication.class, args);
	}
}
