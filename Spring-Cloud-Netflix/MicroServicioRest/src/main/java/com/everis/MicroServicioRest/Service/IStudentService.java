package com.everis.MicroServicioRest.Service;

import java.util.List;

import com.everis.MicroServicioRest.Entity.StudentEntity;

public interface IStudentService {

	List<StudentEntity> FindAll();
}
