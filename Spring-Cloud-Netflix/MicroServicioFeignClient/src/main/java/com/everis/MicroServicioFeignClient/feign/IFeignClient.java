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

	
	@GetMapping("/FindAll")
	ResponseEntity<?> FindAll();
	
	@GetMapping("/FindById/{student_id}")
	public ResponseEntity<?> FindById(@Valid @PathVariable int student_id);
	
	@GetMapping("/FindAllById/{ids}")
	public ResponseEntity<?> FindAllById(@Valid @PathVariable("ids") List<Integer> ids);
	
}
