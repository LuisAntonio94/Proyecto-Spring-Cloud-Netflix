package com.everis.MicroServicioFeignClient.controller;

import org.springframework.http.HttpStatus;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.everis.MicroServicioFeignClient.entity.ClassesEntity;
import com.everis.MicroServicioFeignClient.service.ClassesServiceImp;
import com.everis.MicroServicioFeignClient.service.IClassesService;


public class ClassesControllerUnitTest {

	 private ClassesController controller;
	 private IClassesService service;

	    @Before
	    public void setUp() {
	    	service = Mockito.mock(ClassesServiceImp.class);
	        controller = new ClassesController();
	    }
	    
	    @Test
	    public void itShouldReturnTheServiceValueWith200StatusCode() {
	        Mockito.when(service.FindAll()).thenReturn(new List<ClassesEntity>());
	        ResponseEntity<?> httpResponse = controller.FindAll();

	        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
	        Assert.assertEquals("Saludos", httpResponse.getBody());
	    }
	
}
