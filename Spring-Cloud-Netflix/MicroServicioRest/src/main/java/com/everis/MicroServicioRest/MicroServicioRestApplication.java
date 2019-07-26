package com.everis.MicroServicioRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@Configuration
//hace que su aplicación Spring Boot actúe como un cliente Eureka
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class MicroServicioRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioRestApplication.class, args);
	}

}
