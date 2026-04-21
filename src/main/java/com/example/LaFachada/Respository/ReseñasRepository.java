package com.example.LaFachada.Respository;

import com.example.LaFachada.Model.Reseñas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseñasRepository extends JpaRepository<Reseñas, Long> {
        List<Reseñas> findByPropiedadId(Long propiedadId);
        List<Reseñas> findByUsuarioId(Long usuarioId);


}
