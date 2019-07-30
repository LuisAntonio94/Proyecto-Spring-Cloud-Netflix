package com.everis.MicroServicioFeignClient.feign;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/FindById/{student_id}")
	public ResponseEntity<?> FindById(@Valid @PathVariable int student_id) {		
		return feignClient.FindById(student_id);
	}
}
