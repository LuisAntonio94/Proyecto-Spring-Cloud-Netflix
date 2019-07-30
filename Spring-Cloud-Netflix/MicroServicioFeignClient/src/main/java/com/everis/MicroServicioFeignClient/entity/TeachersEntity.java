package com.everis.MicroServicioFeignClient.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "Teachers")
public class TeachersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacher_id;
	
	@NotBlank(message = "gender may not be blank")
	@Size(min = 8, max = 9, message = "gender must be between 8 and 9 characters long") 
	private String gender;
	
	@NotBlank(message = "first_name may not be blank")
	@Size(min = 2, max = 50, message = "first_name must be between 2 and 50 characters long") 
	private String first_name;
	
	@NotBlank(message = "middle_name may not be blank")
	@Size(min = 2, max = 50, message = "middle_name must be between 2 and 50 characters long") 
	private String middle_name;
	
	@NotBlank(message = "last_name may not be blank")
	@Size(min = 2, max = 50, message = "last_name must be between 2 and 50 characters long") 
	private String last_name;
	
	@NotBlank(message = "other_teacher_details may not be blank")
	@Size(min = 2, max = 50, message = "other_teacher_details must be between 2 and 50 characters long") 
	private String other_teacher_details;
	
	@OneToMany(mappedBy = "Teacher", fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonIgnoreProperties("Classes")
	@JsonIgnore
	private List<ClassesEntity> Classes;
}
