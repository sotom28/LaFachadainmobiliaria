package com.example.LaFachada.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Publicacion {

    @Column(name = "publicacion_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpublicacion;

    @jakarta.persistence.Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "precio",nullable = false)
    private Double precio;

    @Column(name = "ubicacion",nullable = false)
    private String ubicacion;

    @Column(name = "vendedor_id",nullable = false)
    private Integer vendedorId;

    @Column(name = "propiedad_id",nullable = false)
    private Integer propiedadId;

    @Column(name = "estado",nullable = false)
    private String estado;

    @Column(name = "fecha_publicacion", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaPublicacion;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Resenas> resenas = new ArrayList<>();

}
