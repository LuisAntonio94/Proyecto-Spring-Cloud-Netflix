package com.everis.MicroServicioFeignClient.service;

import java.util.List;

import com.everis.MicroServicioFeignClient.entity.SubjectsEntity;

public interface ISubjectService {

	SubjectsEntity save(SubjectsEntity subject);
	List<SubjectsEntity> FindAll();
	SubjectsEntity FindById(int subject_id);
	SubjectsEntity update(SubjectsEntity subject);
	boolean delete(int subject_id);
}
