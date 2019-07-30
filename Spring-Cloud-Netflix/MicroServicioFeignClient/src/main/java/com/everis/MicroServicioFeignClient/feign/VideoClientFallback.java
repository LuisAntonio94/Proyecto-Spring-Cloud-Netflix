package com.everis.MicroServicioFeignClient.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class VideoClientFallback implements IFeignClient {

	@Override
	public ResponseEntity<?> FindAll() {
		return new ResponseEntity<>("Inactive service, we show the message thanks to Circuit Breaker (Hystrix)", HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> FindById(@Valid int student_id) {
		return new ResponseEntity<>("Inactive service, we show the message thanks to Circuit Breaker (Hystrix)", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> FindAllById(@Valid List<Integer> ids) {
		return new ResponseEntity<>("Inactive service, we show the message thanks to Circuit Breaker (Hystrix)", HttpStatus.OK);
	}

}
