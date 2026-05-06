package com.example.LaFachada.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Reseñas {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idreseñas;

    private String comentario;
    private Integer calificacion; // "1-5"
    private LocalDate fecha;

    private Long usuarioId;
    private Long propiedadId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id", nullable = false)
    @JsonBackReference
    private Publicacion publicacion;

    
}