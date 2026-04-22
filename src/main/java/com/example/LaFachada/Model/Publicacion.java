
package com.example.LaFachada.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Publicacion {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private Long idpublicacion;


private  String titulo;

private String descripcion;

private String precio;

private String ubicacion;


@OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonManagedReference
private List<Reseñas> reseñas = new ArrayList<>();

public Publicacion() {
}

public Publicacion(Long idpublicacion, String titulo, String descripcion, List<Reseñas> reseñas) {
	this.idpublicacion = idpublicacion;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.reseñas = reseñas;
}

public Long getIdpublicacion() {
	return idpublicacion;
}

public void setIdpublicacion(Long idpublicacion) {
	this.idpublicacion = idpublicacion;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public List<Reseñas> getReseñas() {
	return reseñas;
}

public void setReseñas(List<Reseñas> reseñas) {
	this.reseñas = reseñas;
}

public String getPrecio() {
    return precio;
}


public void setPrecio(String precio) {
    this.precio = precio;
}

public String getUbicacion() {
    return ubicacion;
}


public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;


}

}