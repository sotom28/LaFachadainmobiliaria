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
import jakarta.persistence.Column;

@Data
@Entity
public class Resenas {

    @Column(name = "idresenas")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResenas;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "calificacion", nullable = false)
    private Integer calificacion;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "propiedad_id", nullable = false)
    private Long propiedadId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id", nullable = false)
    @JsonBackReference
    private Publicacion publicacion;

}
