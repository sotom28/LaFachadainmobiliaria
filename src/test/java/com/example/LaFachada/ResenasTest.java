package com.example.LaFachada;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Model.Resenas;

class ResenasTest {

	@Test
	void crearResenaConPublicacion() {
		Publicacion publicacion = new Publicacion();
		publicacion.setIdpublicacion(1);
		publicacion.setTitulo("Departamento en arriendo");
		publicacion.setDescripcion("Cerca del metro");
		publicacion.setPrecio(550000.0);
		publicacion.setUbicacion("Santiago");

		Resenas resena = new Resenas();
		resena.setComentario("Muy buena ubicación");
		resena.setCalificacion(5);
		resena.setFecha(LocalDate.of(2026, 4, 21));
		resena.setUsuarioId(10);
		resena.setPublicacion(publicacion);

		assertNotNull(resena.getPublicacion());
		assertEquals(1, resena.getPublicacion().getIdpublicacion());
		assertEquals("Muy buena ubicación", resena.getComentario());
		assertEquals(5, resena.getCalificacion());
		assertEquals(LocalDate.of(2026, 4, 21), resena.getFecha());
	}

}
