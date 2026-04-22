package com.example.LaFachada;

import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Model.Reseñas;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ResenasTest {

	@Test
	void crearResenaConPublicacion() {
		Publicacion publicacion = new Publicacion();
		publicacion.setIdpublicacion(1L);
		publicacion.setTitulo("Departamento en arriendo");
		publicacion.setDescripcion("Cerca del metro");
		publicacion.setPrecio("550000");
		publicacion.setUbicacion("Santiago");

		Reseñas resena = new Reseñas();
		resena.setComentario("Muy buena ubicación");
		resena.setCalificacion(5);
		resena.setFecha(LocalDate.of(2026, 4, 21));
		resena.setUsuarioId(10L);
		resena.setPropiedadId(20L);
		resena.setPublicacion(publicacion);

		assertNotNull(resena.getPublicacion());
		assertEquals(1L, resena.getPublicacion().getIdpublicacion());
		assertEquals("Muy buena ubicación", resena.getComentario());
		assertEquals(5, resena.getCalificacion());
		assertEquals(LocalDate.of(2026, 4, 21), resena.getFecha());
	}


    



}
