package com.everis.MicroServicioFeignClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableCircuitBreaker
//@EnableHystrix
@SpringBootApplication
public class MicroServicioFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioFeignClientApplication.class, args);
	}
}
