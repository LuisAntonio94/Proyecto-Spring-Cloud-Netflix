package com.everis.MicroServicioFeignClient.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Implemented the CircuitBreaker pattern using the Fallback method
@FeignClient(name = "EurekaClient", fallback = VideoClientFallback.class)
public interface IFeignClient {

	//List<StudentBean>
	@GetMapping("/FindAll")
	ResponseEntity<?> FindAll();
	
	@GetMapping("/FindById/{ids}")
	public ResponseEntity<?> FindById(@Valid @PathVariable("ids") List<Integer> ids);
	
}
