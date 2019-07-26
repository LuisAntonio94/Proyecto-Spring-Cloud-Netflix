package com.everis.MicroServicioFeignClient.service;

import java.util.List;

import com.everis.MicroServicioFeignClient.entity.ClassesEntity;

public interface IClassesService {

	ClassesEntity save(ClassesEntity classes);
	List<ClassesEntity> FindAll();
	ClassesEntity FindById(int class_id);
	ClassesEntity update(ClassesEntity classes);
	boolean delete(int class_id);
}
