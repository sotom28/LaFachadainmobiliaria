package com.example.LaFachada.Service;


import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Respository.PublicacionRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PublicacionService {


    private final PublicacionRepository publicacionRepository;

    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;

    }

    public List<Publicacion> listarTodas() {
        return publicacionRepository.findAll();
    }

    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public Publicacion actualizarPublicacion(Long id, Publicacion publicacionActualizada) {
        return publicacionRepository.findById(id)
                .map(publicacion -> {
                    publicacion.setTitulo(publicacionActualizada.getTitulo());
                    publicacion.setDescripcion(publicacionActualizada.getDescripcion());
                    publicacion.setPrecio(publicacionActualizada.getPrecio());
                    publicacion.setUbicacion(publicacionActualizada.getUbicacion());
                    return publicacionRepository.save(publicacion);
                })
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada con id: " + id));
    }

    public boolean eliminarPublicacion(Long id) {
        if (publicacionRepository.existsById(id)) {
            publicacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Publicacion obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada con id: " + id));
    }

}