package com.everis.MicroServicioFeignClient.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Classes")
public class ClassesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int class_id;
	
	private int subject_id;
	private int teacher_id;
	
	private String class_code;
	private String class_name;
	
	@OneToMany(mappedBy = "Classes", fetch = FetchType.LAZY)
	//@JsonIgnoreProperties("Classes")
	@JsonIgnore
	private List<StudentClassesEntity> studentsClasses;
}
