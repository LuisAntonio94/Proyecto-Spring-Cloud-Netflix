package com.everis.MicroServicioFeignClient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.MicroServicioFeignClient.entity.ClassesEntity;
import com.everis.MicroServicioFeignClient.entity.StudentClassesEntity;
import com.everis.MicroServicioFeignClient.repository.ClassesRepository;
import com.everis.MicroServicioFeignClient.repository.StudentClassesRepository;

@Service
public class StudentClassesServiceImp implements IStudentClassesService {

	@Autowired
	StudentClassesRepository repository;
	
	@Autowired
	ClassesRepository repoclass;
	
	@Override
	public StudentClassesEntity save(StudentClassesEntity studentClasses_id) {
		return repository.saveAndFlush(studentClasses_id);
	}

	@Override
	public List<StudentClassesEntity> FindAll() {
		return repository.findAll();
	}
	
	
	@Override
	public StudentClassesEntity FindById(int class_id) {
		return repository.findById(class_id).get();
	}

	
	@Override
	public List<StudentClassesEntity> FindByIdClass(int class_id) {
		ClassesEntity objClass =  new ClassesEntity();
		objClass.setClass_id(class_id);
		
		List<StudentClassesEntity> listporId = new ArrayList<>();
		
		List<StudentClassesEntity> ListstdClass = repository.findAll();
		
		for(StudentClassesEntity stdCl : ListstdClass) {
			
			if(stdCl.getClasses().getClass_id() == class_id) {
				listporId.add(stdCl);
			}
			
		}
		return listporId;
	}
	

	@Override
	public StudentClassesEntity update(StudentClassesEntity studentClasses) {
		return repository.save(studentClasses);
	}

	@Override
	public boolean delete(int studentClasses_id) {
		boolean valor = false;
		
		try{
			repository.deleteById(studentClasses_id);
			valor = true;
		}
		catch(Exception e) {
			e.getMessage();
		}
		return valor;
	}

}
