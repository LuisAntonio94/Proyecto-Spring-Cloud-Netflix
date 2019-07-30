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

import com.everis.MicroServicioFeignClient.entity.StudentClassesEntity;
import com.everis.MicroServicioFeignClient.exceptions.DataException;
import com.everis.MicroServicioFeignClient.exceptions.ResourceNotFoundException;
import com.everis.MicroServicioFeignClient.feign.IFeignClient;
import com.everis.MicroServicioFeignClient.service.IStudentClassesService;

@RestController
@RequestMapping("/StudentClasses")
public class StudentClassesController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IStudentClassesService service;
	
	@Autowired
	IFeignClient feignClient;
	
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> FindAll(){
		return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
	}
	
	//Metodo que lista Student_Classes por su Id de Clases
	@GetMapping("/FindById/{class_id}")
	public ResponseEntity<?> FindByIdClass(@Valid @PathVariable("class_id") int class_id){
		
		StudentClassesEntity studentClass = service.FindById(class_id);
		
		if(studentClass==null) {
			throw new ResourceNotFoundException("The class with the id-"+ class_id +" does not exist!");
		}
		
		return new ResponseEntity<>(studentClass, HttpStatus.OK);
	}
	
	//Metodo que lista Students por Id de Clases
	@GetMapping("/FindStudByIdClass/{class_id}")
	public ResponseEntity<?> FindStudByIdClass(@Valid @PathVariable("class_id") int class_id){
		
		StudentClassesEntity studentClass = service.FindById(class_id);
		
		if(studentClass==null) {
			throw new ResourceNotFoundException("The class with the id-"+ class_id +" does not exist!");
		}
		
		return feignClient.FindById(service.FindIdStdClassByIdClass(class_id));
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody StudentClassesEntity stdClass){
		
		StudentClassesEntity studentClass = service.save(stdClass);
		
		if(studentClass == null) {
			logger.warn("StudentClasses not save!!!");
			throw new DataException("StudentClasses not save!!!");
		}
		
		return new ResponseEntity<>(studentClass, HttpStatus.OK);
	}
	
	@PutMapping("/update/{studentClasses_id}")
	public ResponseEntity<?> update(@Valid @PathVariable("studentClasses_id") int studentClasses_id, @RequestBody StudentClassesEntity stdClass){
		
		StudentClassesEntity studentClass = service.FindById(studentClasses_id);
		
		if(studentClass==null) 
			throw new ResourceNotFoundException("The StudentClasses with the id-"+ studentClasses_id +" does not exist!");
		
		studentClass = service.update(stdClass);
		if(studentClass == null) {
			logger.warn("StudentClasses not updated!!!");
			throw new DataException("StudentClasses not updated!!!");
		}
		
		return new ResponseEntity<>(studentClass, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{studentClasses_id}")
	public ResponseEntity<?> delete(@Valid @PathVariable("studentClasses_id") int studentClasses_id){
		
		StudentClassesEntity studentClass = service.FindById(studentClasses_id);
		
		if(studentClass==null) 
			throw new ResourceNotFoundException("The StudentClasses with the id-"+ studentClasses_id +" does not exist!");
		
		String msg = "";
		if(!service.delete(studentClasses_id)) {
			logger.warn("StudentClasses not deleted!!!");
			throw new DataException("StudentClasses not deleted!!!");
		}
		else {
			msg = "correct disposal";
		}
			
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
