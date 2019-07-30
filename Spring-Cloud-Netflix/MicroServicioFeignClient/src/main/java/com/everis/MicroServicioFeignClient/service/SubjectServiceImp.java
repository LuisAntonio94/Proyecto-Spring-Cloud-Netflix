package com.everis.MicroServicioFeignClient.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.MicroServicioFeignClient.entity.SubjectsEntity;
import com.everis.MicroServicioFeignClient.repository.SubjectRepository;

@Service
public class SubjectServiceImp implements ISubjectService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SubjectRepository repository;
	
	@Override
	public SubjectsEntity save(SubjectsEntity subject) {
		
		SubjectsEntity objSubj = null;
		try {
			objSubj = repository.save(subject);
			logger.info("Subject inserted!!!");
			return objSubj;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return objSubj;
		}
	}

	@Override
	public List<SubjectsEntity> FindAll() {
		return repository.findAll();
	}

	@Override
	public SubjectsEntity FindById(int subject_id) {
		
		Optional<SubjectsEntity> objOpt = repository.findById(subject_id);
		
		SubjectsEntity objsubj = null;
		
		if(objOpt.isPresent())
			objsubj = repository.findById(subject_id).get();
		
		return objsubj;
	}

	@Override
	public SubjectsEntity update(SubjectsEntity subject) {
		
		SubjectsEntity objSubj = null;
		try {
			objSubj = repository.save(subject);
			logger.info("Subject updated!!!");
			return objSubj;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			return objSubj;
		}
	}

	@Override
	public boolean delete(int subject_id) {
		boolean valor = false;
		
		try{
			repository.deleteById(subject_id);
			logger.info("Subject deleted!!!");
			valor = true;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		return valor;
	}

}
