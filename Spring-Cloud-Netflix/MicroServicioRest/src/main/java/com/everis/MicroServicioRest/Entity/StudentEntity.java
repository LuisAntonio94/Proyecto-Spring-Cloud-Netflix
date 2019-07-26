package com.everis.MicroServicioRest.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "Students")
@Data
public class StudentEntity {
		
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private int student_id;
			
		private String gender;
		private String first_name;
		private String middle_name;
		private String last_name;
		private Date date_of_birth;
		private String other_parent_details;
		
		/*
		@ManyToMany(mappedBy = "students",cascade = CascadeType.ALL)
		@JsonIgnoreProperties("students")
		private Set<Parents> parents;
		*/
}
