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

import com.everis.MicroServicioFeignClient.entity.StudentClassesEntity;
import com.everis.MicroServicioFeignClient.service.IStudentClassesService;

@RestController
@RequestMapping("/StudentClasses")
public class StudentClassesController {

	@Autowired
	IStudentClassesService service;
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> FindAll(){
		return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/FindById/{class_id}")
	public ResponseEntity<?> FindByIdClass(@Valid @PathVariable("class_id") int class_id){
		return new ResponseEntity<>(service.FindByIdClass(class_id), HttpStatus.OK);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody StudentClassesEntity stdClass){
		return new ResponseEntity<>(service.save(stdClass), HttpStatus.OK);
	}
	
	@PutMapping("/update/{studentClasses_id}")
	public ResponseEntity<?> update(@Valid @PathVariable("studentClasses_id") int studentClasses_id, @RequestBody StudentClassesEntity stdClass){
		StudentClassesEntity studentClass=null;
		if(service.FindById(studentClasses_id) != null)
			studentClass = service.update(stdClass);
		
		return new ResponseEntity<>(studentClass, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{studentClasses_id}")
	public ResponseEntity<?> delete(@Valid @PathVariable("studentClasses_id") int studentClasses_id){
		String msg = "Fallo la eliminacion!!!";
		if(service.delete(studentClasses_id))
			msg = "eliminacion correcta";
			
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
