package com.example.LaFachada;

import com.example.LaFachada.Controller.PublicacionController;
import com.example.LaFachada.Model.Publicacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LaFachadaApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
	}

	@Test
	void publicacionControllerBeanExiste() {
		Assertions.assertNotNull(applicationContext.getBean(PublicacionController.class));
	}

	

}
