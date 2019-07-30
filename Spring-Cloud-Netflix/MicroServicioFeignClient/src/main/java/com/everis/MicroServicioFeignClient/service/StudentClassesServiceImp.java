package com.everis.MicroServicioFeignClient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.MicroServicioFeignClient.entity.StudentClassesEntity;
import com.everis.MicroServicioFeignClient.repository.ClassesRepository;
import com.everis.MicroServicioFeignClient.repository.StudentClassesRepository;

@Service
public class StudentClassesServiceImp implements IStudentClassesService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentClassesRepository repository;
	
	@Autowired
	ClassesRepository repoclass;
	
	@Override
	public StudentClassesEntity save(StudentClassesEntity studentClasses) {
		
		StudentClassesEntity stdCls = null;
		try {
			stdCls = repository.save(studentClasses);
			logger.info("StudentClass inserted!!!");
			return stdCls;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return stdCls;
		}
	}

	@Override
	public List<StudentClassesEntity> FindAll() {
		return repository.findAll();
	}
	
	
	@Override
	public StudentClassesEntity FindById(int class_id) {
		
		Optional<StudentClassesEntity> objOpt = repository.findById(class_id);
		
		StudentClassesEntity objStdClass = null;
		
		if(objOpt.isPresent())
			objStdClass = repository.findById(class_id).get();
		
		return objStdClass;
	}

	
	@Override
	public List<StudentClassesEntity> FindByIdClass(int class_id) {
		
		//Creo un ArrayList  para agregar los objetos que coincidan con el id de la clase
		List<StudentClassesEntity> listxId = new ArrayList<>();
		
		//Creo un ArrayList para listar todos los SudentsClasses
		List<StudentClassesEntity> ListstdClass = repository.findAll();
		
		//Recorro cada objeto de la Lista de los StudentClasses para comparar su id de clase 
		//y añadirle a la Lista de objetos que coincidan con el id de clase mandado por parametro
		for(StudentClassesEntity stdCl : ListstdClass) {
			if(stdCl.getClasses().getClass_id() == class_id)
				listxId.add(stdCl);
		}
		
		return listxId;
	}
	
	@Override
	public List<Integer> FindIdStdClassByIdClass(int class_id) {
				
		//Creo un ArrayList  para agregar los objetos que coincidan con el id de la clase
		List<Integer> listIdxIdClass = new ArrayList<>();
		
		//Creo un ArrayList para listar todos los SudentsClasses
		List<StudentClassesEntity> ListstdClass = repository.findAll();
				
		//Recorro cada objeto de la Lista de los StudentClasses para comparar su id de clase 
		//y añadirle a la Lista de objetos que coincidan con el id de clase mandado por parametro
		for(StudentClassesEntity stdCl : ListstdClass) {
			if(stdCl.getClasses().getClass_id() == class_id)
				listIdxIdClass.add(stdCl.getStudent_id());
		}
				
		return listIdxIdClass;
	}
	

	@Override
	public StudentClassesEntity update(StudentClassesEntity studentClasses) {
		
		StudentClassesEntity objStdCls = null;
		try {
			objStdCls = repository.save(studentClasses);
			logger.info("StudentClass updated!!!");
			return objStdCls;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return objStdCls;
		}
	}

	@Override
	public boolean delete(int studentClasses_id) {
		boolean valor = false;
		
		try{
			repository.deleteById(studentClasses_id);
			logger.info("StudentClass deleted!!!");
			valor = true;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		return valor;
	}

}
