package com.everis.MicroServicioFeignClient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.MicroServicioFeignClient.entity.SubjectsEntity;
import com.everis.MicroServicioFeignClient.repository.SubjectRepository;

@Service
public class SubjectServiceImp implements ISubjectService{

	@Autowired
	SubjectRepository repository;
	
	@Override
	public SubjectsEntity save(SubjectsEntity subject) {
		return repository.save(subject);
	}

	@Override
	public List<SubjectsEntity> FindAll() {
		return repository.findAll();
	}

	@Override
	public SubjectsEntity FindById(int subject_id) {
		return repository.findById(subject_id).get();
	}

	@Override
	public SubjectsEntity update(SubjectsEntity subject) {
		return repository.save(subject);
	}

	@Override
	public boolean delete(int subject_id) {
		boolean valor = false;
		
		try{
			repository.deleteById(subject_id);
			valor = true;
		}
		catch(Exception e) {
			e.getMessage();
		}
		return valor;
	}

}
