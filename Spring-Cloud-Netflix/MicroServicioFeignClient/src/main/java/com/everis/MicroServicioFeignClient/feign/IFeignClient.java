package com.everis.MicroServicioFeignClient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


//realiza el descubrimiento del servicio y ribbon para el balanceo correspondiente
@FeignClient("EurekaClient")
public interface IFeignClient {

	//List<StudentBean>
	@GetMapping("/FindAll")
	ResponseEntity<?> FindAll();
	
}
