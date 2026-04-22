package com.example.LaFachada.Respository;

import com.example.LaFachada.Model.Publicacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    List<Publicacion> findByTituloContainingIgnoreCase(String titulo);
    List<Publicacion> findByUbicacionContainingIgnoreCase(String ubicacion);
    List<Publicacion> findByPrecioBetween(Double precioMin, Double precioMax);
    List<Publicacion> findByDescripcionContainingIgnoreCase(String descripcion);

}
