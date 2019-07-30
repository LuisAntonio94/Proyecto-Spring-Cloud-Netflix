package com.everis.MicroServicioFeignClient.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.everis.MicroServicioFeignClient.exceptions.DataException;
import com.everis.MicroServicioFeignClient.exceptions.ResourceNotFoundException;
import com.everis.MicroServicioFeignClient.service.IClassesService;

@RestController
@RequestMapping("/Classes")
public class ClassesController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IClassesService service;
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> FindAll(){
		return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/FindById/{class_id}")
	public ResponseEntity<?> FindByIdClass(@Valid @PathVariable("class_id") int class_id){
		
		ClassesEntity objClass = service.FindById(class_id);
		
		if(objClass==null) {
			throw new ResourceNotFoundException("The class with the id-"+ class_id +" does not exist!");
		}
		
		return new ResponseEntity<>(objClass, HttpStatus.OK);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody ClassesEntity classes){
		
		ClassesEntity objClass = service.save(classes);
		
		if(objClass == null) {
			logger.warn("Class not save!!!");
			throw new DataException("Class not save!!!");
		}
		
		return new ResponseEntity<>(objClass, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{class_id}")
	public ResponseEntity<?> update(@Valid @PathVariable("class_id") int class_id, @RequestBody ClassesEntity classes){
		
		ClassesEntity objClass = service.FindById(class_id);
		
		if(objClass==null) 
			throw new ResourceNotFoundException("The class with the id-"+ class_id +" does not exist!");
		
		ClassesEntity objClassnew = service.update(classes);
		
		if(objClassnew == null) {
			logger.warn("Class not updated!!!");
			throw new DataException("Class not updated!!!");
		}
		
		return new ResponseEntity<>(objClassnew, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{class_id}")
	public ResponseEntity<?> delete(@Valid @PathVariable("class_id") int class_id){
		
		ClassesEntity objClass = service.FindById(class_id);
		
		if(objClass==null) 
			throw new ResourceNotFoundException("The class with the id-"+ class_id +" does not exist!");
		
		String msg = "";
		if(!service.delete(class_id)) {
			logger.warn("Class not deleted!!!");
			throw new DataException("Class not deleted!!!");
		}
		else {
			msg = "correct disposal";
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
}
