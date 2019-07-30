package com.everis.MicroServicioFeignClient.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.MicroServicioFeignClient.entity.ClassesEntity;
import com.everis.MicroServicioFeignClient.entity.StudentClassesEntity;
import com.everis.MicroServicioFeignClient.repository.ClassesRepository;
import com.everis.MicroServicioFeignClient.repository.StudentClassesRepository;

@Service
public class ClassesServiceImp implements IClassesService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
			lista.add(studentClasses);
		}
		
		repoStudentClass.saveAll(lista);
		logger.info("Class is inserted!!!");
		
		/*
		ClassesEntity classs = repository.save(classes);
		
		classes.getStudentsClasses().forEach(StudentClassesEntity -> StudentClassesEntity.setClasses(classs));
		
		repoStudentClass.saveAll(classes.getStudentsClasses());
		*/
		return classs;
	}

	
	@Override
	public List<ClassesEntity> FindAll() {
		return repository.findAll();
	}

	
	@Override
	public ClassesEntity FindById(int class_id) {
		
		Optional<ClassesEntity> objOpt = repository.findById(class_id);
		
		ClassesEntity objclass = null;
		
		if(objOpt.isPresent())
			objclass = repository.findById(class_id).get();
		
		return objclass;
	}

	
	@Override
	public ClassesEntity update(ClassesEntity classes) {
		
		try {
			ClassesEntity cls = repository.save(classes);
			logger.info("Class updated!!!");
			return cls;
		}catch(Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	
	@Override
	public boolean delete(int class_id) {
		
		boolean valor = false;
		
		try{
			repository.deleteById(class_id);
			logger.info("Student deleted!!!");
			valor = true;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		return valor;
	}

}
