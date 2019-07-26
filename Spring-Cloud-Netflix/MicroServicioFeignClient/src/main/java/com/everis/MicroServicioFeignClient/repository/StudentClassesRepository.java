package com.everis.MicroServicioFeignClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.MicroServicioFeignClient.entity.StudentClassesEntity;

@Repository
public interface StudentClassesRepository extends JpaRepository<StudentClassesEntity, Integer>{
	
	//List<StudentClassesEntity> FindAllByIdClass(@Param("class_id") int class_id);
}
