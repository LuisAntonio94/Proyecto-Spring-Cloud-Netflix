package com.everis.MicroServicioFeignClient.feign;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/FeignClient")
public class FeignClientController {

	@Autowired
    private IFeignClient feignClient;
	
	@GetMapping("/ListStudents")
	public ResponseEntity<?> FindAll() {		
		return feignClient.FindAll();
	}
}
