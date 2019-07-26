package com.everis.MicroServicioFeignClient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Subjetcs")
public class SubjectsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subject_id;
	
	private String subject_name;
}
