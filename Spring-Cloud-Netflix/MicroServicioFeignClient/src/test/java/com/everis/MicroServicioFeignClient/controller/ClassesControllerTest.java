package com.everis.MicroServicioFeignClient.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClassesControllerTest {

	 	@Autowired
	    private MockMvc mvc;
	 
	    @Test
	    public void findAll() throws Exception {
	        this.mvc.perform(get("/Classes/FindAll"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType("application/json;charset=UTF-8"));
	    }

	    @Test
	    public void findById() throws Exception {
	        this.mvc.perform(get("/Classes/FindById/1"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType("application/json;charset=UTF-8"));
	    }
	    
	    @Test
	    public void create() throws Exception {
	    	String studentJSON = "{ \"class_code\" : \"DAMI\", \"class_name\" : \"Desarrollo de Aplicaciones Moviles I\", \"Subject\" : { \"subject_name\" : \"Android Studio\" }, \"Teacher\" : { \"gender\" : \"masculino\", \"first_name\" : \"Luis\", \"middle_name\" : \"Otero\", \"last_name\" : \"Serrano\", \"other_teacher_details\" : \"Contratado\" }, \"studentsClasses\" :[ { \"student_id\" : \"1\" }, { \"student_id\" : \"2\" } ] \"}";

	        this.mvc.perform(post("/Classes/save")
	                .contentType("application/json;charset=UTF-8")
	                .content(studentJSON))
	                .andExpect(status().isCreated())
	                .andExpect(content().contentType("application/json;charset=UTF-8"));
	    }

	    @Test
	    public void update() throws Exception {
	        String studentJSON = "{ \"class_code\" : \"DAMI\", \"class_name\" : \"Desarrollo de Aplicaciones Moviles I\", \"Subject\" : { \"subject_name\" : \"Android Studio\" }, \"Teacher\" : { \"gender\" : \"masculino\", \"first_name\" : \"Luis\", \"middle_name\" : \"Otero\", \"last_name\" : \"Serrano\", \"other_teacher_details\" : \"Contratado\" }, \"studentsClasses\" :[ { \"student_id\" : \"1\" }, { \"student_id\" : \"2\" } ] \"}";

	        this.mvc.perform(put("/Classes/update/2")
	                .contentType("application/json;charset=UTF-8")
	                .content(studentJSON))
	                .andExpect(status().isCreated())
	                .andExpect(content().contentType("application/json;charset=UTF-8"));
	    }

	    @Test
	    public void delete() throws Exception {
	        this.mvc.perform(MockMvcRequestBuilders.delete("/Classes/delete/4"))
	                .andExpect(status().isNoContent());
	    }
	
}
