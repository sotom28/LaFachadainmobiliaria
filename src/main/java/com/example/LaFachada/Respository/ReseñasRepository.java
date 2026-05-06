package com.example.LaFachada.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LaFachada.Model.Reseñas;

@Repository
public interface ReseñasRepository extends JpaRepository<Reseñas, Long> {
        List<Reseñas> findByPropiedadId(Long propiedadId);
        List<Reseñas> findByUsuarioId(Long usuarioId);


}
