package com.everis.MicroServicioRest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.MicroServicioRest.Entity.StudentEntity;
import com.everis.MicroServicioRest.Repository.StudentRepository;

@Service
public class StudentServiceImp implements IStudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<StudentEntity> FindAll() {
		
		return studentRepository.findAll();
	}

	@Override
	public List<StudentEntity> FindAllById(List<Integer> ids) {
		
		return studentRepository.findAllById(ids);
	}
}
