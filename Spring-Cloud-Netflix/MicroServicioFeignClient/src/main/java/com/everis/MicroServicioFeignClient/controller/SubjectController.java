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

import com.everis.MicroServicioFeignClient.entity.SubjectsEntity;
import com.everis.MicroServicioFeignClient.exceptions.DataException;
import com.everis.MicroServicioFeignClient.exceptions.ResourceNotFoundException;
import com.everis.MicroServicioFeignClient.service.ISubjectService;

@RestController
@RequestMapping("/Subject")
public class SubjectController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ISubjectService service;
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> FindAll(){
		return new ResponseEntity<>(service.FindAll(), HttpStatus.OK);
	}
	
	@GetMapping("/FindById/{subject_id}")
	public ResponseEntity<?> FindByIdClass(@Valid @PathVariable("subject_id") int subject_id){
		
		SubjectsEntity objSubj = service.FindById(subject_id);
		
		if(objSubj==null)
			throw new ResourceNotFoundException("The subject with the id-"+ subject_id +" does not exist!");
		
		return new ResponseEntity<>(objSubj, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody SubjectsEntity subject){
		
		SubjectsEntity objSubj = service.save(subject);
		
		if(objSubj == null) {
			logger.warn("Class not save!!!");
			throw new DataException("Subject not save!!!");
		}
		
		return new ResponseEntity<>(objSubj, HttpStatus.OK);
	}
	
	@PutMapping("/update/{subject_id}")
	public ResponseEntity<?> update(@Valid @PathVariable("subject_id") int subject_id, @RequestBody SubjectsEntity subject){
		
		SubjectsEntity objSubj = service.FindById(subject_id);
		
		if(objSubj==null)
			throw new ResourceNotFoundException("The subject with the id-"+ subject_id +" does not exist!");
		
		objSubj = service.update(subject);
		if(objSubj == null) {
			logger.warn("Subject not updated!!!");
			throw new DataException("Subject not updated!!!");
		}
		
		return new ResponseEntity<>(objSubj, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{subject_id}")
	public ResponseEntity<?> delete(@Valid @PathVariable("subject_id") int subject_id){
		
		SubjectsEntity objSubj = service.FindById(subject_id);
		
		if(objSubj==null)
			throw new ResourceNotFoundException("The subject with the id-"+ subject_id +" does not exist!");
		
		String msg = "";
		if(!service.delete(subject_id)) {
			logger.warn("Subject not deleted!!!");
			throw new DataException("Subject not deleted!!!");
		}
		else {
			msg = "correct disposal";
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
}
