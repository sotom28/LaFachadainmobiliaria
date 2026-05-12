package com.example.LaFachada.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LaFachada.Model.Publicacion;


@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {
    List<Publicacion> findByTituloContainingIgnoreCase(String titulo);
    List<Publicacion> findByUbicacionContainingIgnoreCase(String ubicacion);
    List<Publicacion> findByPrecioBetween(Double precioMin, Double precioMax);
    List<Publicacion> findByDescripcionContainingIgnoreCase(String descripcion);

}
