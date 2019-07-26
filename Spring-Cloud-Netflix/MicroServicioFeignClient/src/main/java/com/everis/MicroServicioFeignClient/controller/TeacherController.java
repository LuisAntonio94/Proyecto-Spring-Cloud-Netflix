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

import com.everis.MicroServicioFeignClient.entity.TeachersEntity;
import com.everis.MicroServicioFeignClient.service.ITeacherService;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {

	@Autowired
	ITeacherService service;
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> FindAll(){
		return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
	}
	
	@GetMapping("/FindById/{teacher_id}")
	public ResponseEntity<?> FindByIdClass(@Valid @PathVariable("teacher_id") int teacher_id){
		return new ResponseEntity<>(service.FindById(teacher_id), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody TeachersEntity teacher){
		return new ResponseEntity<>(service.save(teacher), HttpStatus.OK);
	}
	
	@PutMapping("/update/{teacher_id}")
	public ResponseEntity<?> update(@Valid @PathVariable("teacher_id") int teacher_id, @RequestBody TeachersEntity teacher){
		TeachersEntity teachernew=null;
		if(service.FindById(teacher_id) != null)
			teachernew = service.update(teacher);
		
		return new ResponseEntity<>(teachernew, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{teacher_id}")
	public ResponseEntity<?> delete(@Valid @PathVariable("teacher_id") int teacher_id){
		String msg = "Fallo la eliminacion!!!";
		if(service.delete(teacher_id))
			msg = "eliminacion correcta";
			
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
}
