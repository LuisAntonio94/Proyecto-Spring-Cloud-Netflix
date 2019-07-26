package com.everis.MicroServicioFeignClient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.MicroServicioFeignClient.entity.ClassesEntity;

@Repository
public interface ClassesRepository extends JpaRepository<ClassesEntity, Integer> {

}
