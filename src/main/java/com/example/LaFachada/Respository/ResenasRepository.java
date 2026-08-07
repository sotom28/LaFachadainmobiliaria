package com.example.LaFachada.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Model.Resenas;



@Repository
public interface ResenasRepository extends JpaRepository<Resenas, Long> {
    List<Resenas> findByUsuarioId(Long usuarioId);
    List<Resenas> findByPublicacion(Publicacion publicacion);
}
