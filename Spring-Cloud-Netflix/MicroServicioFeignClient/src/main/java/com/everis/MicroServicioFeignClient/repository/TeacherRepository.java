package com.everis.MicroServicioFeignClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.MicroServicioFeignClient.entity.TeachersEntity;

@Repository
public interface TeacherRepository extends JpaRepository<TeachersEntity, Integer>{

}
