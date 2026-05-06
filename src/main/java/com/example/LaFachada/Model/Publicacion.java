
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

private Integer precio;

private String ubicacion;

private String Region;

private String Comuna;

private String contacto;

private String estado;

private String fechaPublicacion;

private String tipoventas; 

private String fotosUrl;

private String tipoPropiedad;

private Integer cantidadhabitaciones;

private Integer cantidadbaños;




@OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonManagedReference
private List<Reseñas> reseñas = new ArrayList<>();

public Publicacion() {
}

}