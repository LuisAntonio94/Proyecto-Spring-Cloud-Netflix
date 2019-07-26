package com.everis.MicroServicioFeignClient.entity;

import java.util.Date;

import lombok.Data;

@Data
public class StudentEntity {

	private int student_id;
	private String gender;
	private String first_name;
	private String middle_name;
	private String last_name;
	private Date date_of_birth;
	private String other_parent_details;
	
}
