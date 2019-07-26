package com.everis.MicroServicioFeignClient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.MicroServicioFeignClient.entity.TeachersEntity;
import com.everis.MicroServicioFeignClient.repository.TeacherRepository;

@Service
public class TeacherServiceImp implements ITeacherService {

	@Autowired
	TeacherRepository repository;

	@Override
	public TeachersEntity save(TeachersEntity teacher) {
		return repository.saveAndFlush(teacher);
	}

	@Override
	public List<TeachersEntity> FindAll() {
		return repository.findAll();
	}

	@Override
	public TeachersEntity FindById(int teacher_id) {
		return repository.findById(teacher_id).get();
	}

	@Override
	public TeachersEntity update(TeachersEntity teacher) {
		return repository.save(teacher);
	}

	@Override
	public boolean delete(int teacher_id) {
		boolean valor = false;
		
		try{
			repository.deleteById(teacher_id);
			valor = true;
		}
		catch(Exception e) {
			e.getMessage();
		}
		return valor;
	}
	
	
}
