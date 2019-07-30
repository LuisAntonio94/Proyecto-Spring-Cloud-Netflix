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

import com.everis.MicroServicioFeignClient.entity.TeachersEntity;
import com.everis.MicroServicioFeignClient.exceptions.DataException;
import com.everis.MicroServicioFeignClient.exceptions.ResourceNotFoundException;
import com.everis.MicroServicioFeignClient.service.ITeacherService;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ITeacherService service;
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> FindAll(){
		return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
	}
	
	@GetMapping("/FindById/{teacher_id}")
	public ResponseEntity<?> FindByIdClass(@Valid @PathVariable("teacher_id") int teacher_id){
		
		TeachersEntity objTeacher = service.FindById(teacher_id);
		
		if(objTeacher == null)
			throw new ResourceNotFoundException("The teacher with the id-"+ teacher_id +" does not exist!");
		
		return new ResponseEntity<>(objTeacher, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody TeachersEntity teacher){
		
		TeachersEntity objTeacher = service.save(teacher);
		
		if(objTeacher == null) {
			logger.warn("Class not save!!!");
			throw new DataException("Class not save!!!");
		}
		
		return new ResponseEntity<>(objTeacher, HttpStatus.OK);
	}
	
	@PutMapping("/update/{teacher_id}")
	public ResponseEntity<?> update(@Valid @PathVariable("teacher_id") int teacher_id, @RequestBody TeachersEntity teacher){
		
		TeachersEntity objTeacher = service.FindById(teacher_id);
		
		if(objTeacher == null)
			throw new ResourceNotFoundException("The teacher with the id-"+ teacher_id +" does not exist!");
		
		objTeacher = service.update(teacher);
		if(objTeacher == null) {
			logger.warn("Teacher not updated!!!");
			throw new DataException("Teacher not updated!!!");
		}
		
		return new ResponseEntity<>(objTeacher, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{teacher_id}")
	public ResponseEntity<?> delete(@Valid @PathVariable("teacher_id") int teacher_id){
		
		TeachersEntity objTeacher = service.FindById(teacher_id);
		
		if(objTeacher == null)
			throw new ResourceNotFoundException("The teacher with the id-"+ teacher_id +" does not exist!");
		
		String msg = "";
		if(!service.delete(teacher_id)) {
			logger.warn("Class not deleted!!!");
			throw new DataException("Class not deleted!!!");
		}
		else {
			msg = "correct disposal";
		}
			
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
}
