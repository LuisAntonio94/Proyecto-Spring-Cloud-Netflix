package com.everis.MicroServicioRest.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.MicroServicioRest.Service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	IStudentService studentService;
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> FindAll() {
		return new ResponseEntity<>(studentService.FindAll(), HttpStatus.OK);
	}
	
	@GetMapping("/FindById/{ids}")
	public ResponseEntity<?> FindById(@Valid @PathVariable("ids") List<Integer> ids) {
		return new ResponseEntity<>(studentService.FindAllById(ids), HttpStatus.OK);
	}
}
