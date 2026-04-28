
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
import lombok.Data;


@Data	
@Entity
public class Publicacion {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private Long idpublicacion;


private  String titulo;

private String descripcion;

private String precio;

private String ubicacion;

private String Region;

private String Comuna;

private String contacto;

private String estado;

private String fechaPublicacion;

private String tipoventas; 

private String fotosUrl;

private String tipoPropiedad;

private int cantidadhabitaciones;

private int cantidadbaños;




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
public String getRegion() {
	return Region;
}

public void setRegion(String region) {
	Region = region;
}

public String getComuna() {
	return Comuna;
}

public void setComuna(String comuna) {
	Comuna = comuna;
}

public String getContacto() {
	return contacto;
}

public void setContacto(String contacto) {
	this.contacto = contacto;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public String getFechaPublicacion() {
	return fechaPublicacion;
}

public void setFechaPublicacion(String fechaPublicacion) {
	this.fechaPublicacion = fechaPublicacion;
}

public String getTipoventas() {
	return tipoventas;
}

public void setTipoventas(String tipoventas) {
	this.tipoventas = tipoventas;
}

public String getFotosUrl() {
	return fotosUrl;
}

public String getTipoPropiedad() {
	return tipoPropiedad;
}

public void setTipoPropiedad(String tipoPropiedad) {
	this.tipoPropiedad = tipoPropiedad;
}

public void setFotosUrl(String fotosUrl) {
	this.fotosUrl = fotosUrl;

	
	}

public int getCantidadhabitaciones() {
	return cantidadhabitaciones;

}
public int getCantidadbaños() {
		return cantidadbaños;
	}
public void setCantidadbaños(int cantidadbaños) {
	this.cantidadbaños = cantidadbaños;

}
public void setCantidadhabitaciones(int cantidadhabitaciones) {
	this.cantidadhabitaciones = cantidadhabitaciones;

}
}