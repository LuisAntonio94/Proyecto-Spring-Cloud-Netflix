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

import lombok.Data;

@Data
@Entity
@Table(name = "Subjetcs")
public class SubjectsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subject_id;
	
	@NotBlank(message = "subject_name may not be blank")
	@Size(min = 5, max = 50, message = "subject_name must be between 5 and 50 characters long") 
	private String subject_name;
	
	@OneToMany(mappedBy = "Subject", fetch = FetchType.LAZY)
	//@JsonIgnoreProperties("Classes")
	@JsonIgnore
	private List<ClassesEntity> Classes;
}
