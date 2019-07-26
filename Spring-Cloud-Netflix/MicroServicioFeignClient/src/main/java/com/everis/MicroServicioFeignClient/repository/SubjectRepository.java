package com.everis.MicroServicioFeignClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.MicroServicioFeignClient.entity.SubjectsEntity;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectsEntity, Integer>{

}
