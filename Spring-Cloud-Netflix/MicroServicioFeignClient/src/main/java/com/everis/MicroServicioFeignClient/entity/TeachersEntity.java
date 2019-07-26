package com.everis.MicroServicioFeignClient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Teachers")
public class TeachersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacher_id;
	private String gender;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String other_teacher_details;
	
}
