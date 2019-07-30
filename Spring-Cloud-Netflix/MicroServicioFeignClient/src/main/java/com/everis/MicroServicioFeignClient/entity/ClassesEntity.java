package com.everis.MicroServicioFeignClient.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Classes")
public class ClassesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int class_id;
	
	//@Min(value =  1, message = "subject_id must be between 1 and 2 characters long")
	//@Max(value = 99, message = "subject_id must be between 1 and 2 characters long")
	//private int subject_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	//@JsonIgnoreProperties("Subject")
	@JsonIgnore
	private SubjectsEntity Subject;
	
	//@Min(value = 1, message = "teacher_id must be between 1 and 2 characters long")
	//@Max(value = 99, message = "teacher_id must be between 1 and 2 characters long")
	//private int teacher_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id")
	//@JsonIgnoreProperties("Classes")
	@JsonIgnore
	private TeachersEntity Teacher;
	
	
	@NotBlank(message = "class_code may not be blank")
	@Size(min = 3, max = 6, message = "class_code must be between 3 and 6 characters long") 
	private String class_code;
	
	@NotBlank(message = "class_name may not be blank")
	@Size(min = 5, max = 50, message = "class_name must be between 5 and 50 characters long") 
	private String class_name;
	
	@OneToMany(mappedBy = "Classes", fetch = FetchType.LAZY)
	//@JsonIgnoreProperties("Classes")
	@JsonIgnore
	private List<StudentClassesEntity> studentsClasses;
}
