package com.everis.MicroServicioFeignClient.service;

import java.util.List;

import com.everis.MicroServicioFeignClient.entity.TeachersEntity;

public interface ITeacherService {

	TeachersEntity save(TeachersEntity teacher);
	List<TeachersEntity> FindAll();
	TeachersEntity FindById(int teacher_id);
	TeachersEntity update(TeachersEntity teacher);
	boolean delete(int teacher_id);
}
