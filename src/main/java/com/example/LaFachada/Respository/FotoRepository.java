package com.example.LaFachada.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LaFachada.Model.Foto;


@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{

}