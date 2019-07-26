package com.everis.MicroServicioFeignClient.service;

import java.util.List;

import com.everis.MicroServicioFeignClient.entity.StudentClassesEntity;

public interface IStudentClassesService {
	
	StudentClassesEntity save(StudentClassesEntity studentClasses);
	List<StudentClassesEntity> FindAll();
	StudentClassesEntity FindById(int studentClasses_id);
	List<StudentClassesEntity> FindByIdClass(int class_id);
	StudentClassesEntity update(StudentClassesEntity studentClasses);
	boolean delete(int studentClasses_id);
}
