package com.everis.MicroServicioRest.Service;

import java.util.List;
import java.util.Optional;

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
	public StudentEntity FindById(int student_id) {
		
		Optional<StudentEntity> objOpt = studentRepository.findById(student_id);
		
		StudentEntity objstud = null;
		
		if(objOpt.isPresent())
			objstud = studentRepository.findById(student_id).get();
		
		return objstud;
		
		//return studentRepository.findById(student_id);
	}

	@Override
	public List<StudentEntity> FindAllById(List<Integer> ids) {
		
		return studentRepository.findAllById(ids);
	}
}
