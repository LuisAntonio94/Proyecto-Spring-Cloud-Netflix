package com.everis.MicroServicioFeignClient.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity@Table(name="Student_Classes")
//@NamedQuery(name = "StudentClassesEntity.FindAllByIdClass", query = "SELECT s FROM StudentClassesEntity s s.class_id =:class_id ")
public class StudentClassesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentClasses_id;
	
	private int student_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id")
	@JsonIgnoreProperties("studentsClasses")
	@JsonIgnore
	private ClassesEntity Classes;
}
