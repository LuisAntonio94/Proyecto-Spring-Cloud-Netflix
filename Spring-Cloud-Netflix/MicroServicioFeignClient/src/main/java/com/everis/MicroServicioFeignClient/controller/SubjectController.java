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

import com.everis.MicroServicioFeignClient.entity.SubjectsEntity;
import com.everis.MicroServicioFeignClient.service.ISubjectService;

@RestController
@RequestMapping("/Subject")
public class SubjectController {

	@Autowired
	ISubjectService service;
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> FindAll(){
		return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
	}
	
	@GetMapping("/FindById/{subject_id}")
	public ResponseEntity<?> FindByIdClass(@Valid @PathVariable("subject_id") int subject_id){
		return new ResponseEntity<>(service.FindById(subject_id), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody SubjectsEntity subject){
		return new ResponseEntity<>(service.save(subject), HttpStatus.OK);
	}
	
	@PutMapping("/update/{subject_id}")
	public ResponseEntity<?> update(@Valid @PathVariable("subject_id") int subject_id, @RequestBody SubjectsEntity subject){
		SubjectsEntity subjectnew=null;
		if(service.FindById(subject_id) != null)
			subjectnew = service.update(subject);
		
		return new ResponseEntity<>(subjectnew, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{subject_id}")
	public ResponseEntity<?> delete(@Valid @PathVariable("subject_id") int subject_id){
		String msg = "Fallo la eliminacion!!!";
		if(service.delete(subject_id))
			msg = "eliminacion correcta";
			
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
}
