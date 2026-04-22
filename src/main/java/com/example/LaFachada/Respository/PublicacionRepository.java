package com.example.LaFachada.Respository;

import com.example.LaFachada.Model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
