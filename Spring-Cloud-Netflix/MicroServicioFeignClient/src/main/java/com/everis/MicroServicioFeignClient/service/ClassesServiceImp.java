package com.everis.MicroServicioFeignClient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.MicroServicioFeignClient.entity.ClassesEntity;
import com.everis.MicroServicioFeignClient.entity.StudentClassesEntity;
import com.everis.MicroServicioFeignClient.repository.ClassesRepository;
import com.everis.MicroServicioFeignClient.repository.StudentClassesRepository;

@Service
public class ClassesServiceImp implements IClassesService{

	@Autowired
	ClassesRepository repository;
	
	@Autowired
	StudentClassesRepository repoStudentClass;
	
	@Override
	public ClassesEntity save(ClassesEntity classes) {
		
		ClassesEntity classs = repository.save(classes);
		
		List<StudentClassesEntity> lista = classes.getStudentsClasses();
		
		for (StudentClassesEntity studentClasses : lista) {
			studentClasses.setClasses(classs);
		}
		
		repoStudentClass.saveAll(lista);
		
		return classs;
	}

	@Override
	public List<ClassesEntity> FindAll() {
		return repository.findAll();
	}

	@Override
	public ClassesEntity FindById(int class_id) {
		return repository.findById(class_id).get();
	}

	@Override
	public ClassesEntity update(ClassesEntity classes) {
		return repository.save(classes);
	}

	@Override
	public boolean delete(int class_id) {
		boolean valor = false;
		
		try{
			repository.deleteById(class_id);
			valor = true;
		}
		catch(Exception e) {
			e.getMessage();
		}
		return valor;
	}

}
