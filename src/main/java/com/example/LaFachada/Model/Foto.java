package com.example.LaFachada.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable =  false)
    private String url;
    @Column(nullable =  false)
    private String nombre;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "publicacion_id", nullable = false)
    @JsonBackReference(value = "publicacion-fotos")
    private Publicacion publicacion;
}
