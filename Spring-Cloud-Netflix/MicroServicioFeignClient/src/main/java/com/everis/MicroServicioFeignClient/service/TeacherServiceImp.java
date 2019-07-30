package com.everis.MicroServicioFeignClient.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.MicroServicioFeignClient.entity.TeachersEntity;
import com.everis.MicroServicioFeignClient.repository.TeacherRepository;

@Service
public class TeacherServiceImp implements ITeacherService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TeacherRepository repository;

	@Override
	public TeachersEntity save(TeachersEntity teacher) {
		
		TeachersEntity objTeacher = null;
		try {
			objTeacher = repository.save(teacher);
			logger.info("Teacher inserted!!!");
			return objTeacher;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return objTeacher;
		}
	}

	@Override
	public List<TeachersEntity> FindAll() {
		return repository.findAll();
	}

	@Override
	public TeachersEntity FindById(int teacher_id) {
		
		Optional<TeachersEntity> objOpt = repository.findById(teacher_id);
		
		TeachersEntity objteacher = null;
		
		if(objOpt.isPresent())
			objteacher = repository.findById(teacher_id).get();
		
		return objteacher;
	}

	@Override
	public TeachersEntity update(TeachersEntity teacher) {
		
		TeachersEntity objTeacher = null;
		try {
			objTeacher = repository.save(teacher);
			logger.info("Teacher updated!!!");
			return objTeacher;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return objTeacher;
		}
	}

	@Override
	public boolean delete(int teacher_id) {
		boolean valor = false;
		
		try{
			repository.deleteById(teacher_id);
			logger.info("Teacher deleted!!!");
			valor = true;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		return valor;
	}
	
	
}
