package com.everis.MicroServicioFeignClient.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.MicroServicioFeignClient.entity.ClassesEntity;
import com.everis.MicroServicioFeignClient.service.IClassesService;

@RestController
@RequestMapping("/Classes")
public class ClassesController {

	@Autowired
	IClassesService service;
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> FindAll(){
		return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
	}
	
	@GetMapping("/FindById/{class_id}")
	public ResponseEntity<?> FindByIdClass(@Valid @PathVariable("class_id") int class_id){
		return new ResponseEntity<>(service.FindById(class_id), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody ClassesEntity classes){
		return new ResponseEntity<>(service.save(classes), HttpStatus.OK);
	}
	
	@PutMapping("/update/{class_id}")
	public ResponseEntity<?> update(@Valid @PathVariable("class_id") int class_id, @RequestBody ClassesEntity classes){
		ClassesEntity classnew=null;
		if(service.FindById(class_id) != null)
			classnew = service.update(classes);
		
		return new ResponseEntity<>(classnew, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{class_id}")
	public ResponseEntity<?> delete(@Valid @PathVariable("class_id") int class_id){
		String msg = "Fallo la eliminacion!!!";
		if(service.delete(class_id))
			msg = "eliminacion correcta";
			
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
}
