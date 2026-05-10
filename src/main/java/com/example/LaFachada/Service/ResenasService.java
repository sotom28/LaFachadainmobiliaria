package com.example.LaFachada.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LaFachada.Model.Resenas;
import com.example.LaFachada.Respository.ResenasRepository;


@Service
public class ResenasService {

    private final ResenasRepository resenasRepository;

    public ResenasService(ResenasRepository resenasRepository) {
        this.resenasRepository = resenasRepository;
    }

    public List<Resenas> listarTodas() {
        return resenasRepository.findAll();
    }

    public Optional<Resenas> obtenerPorId(Long id) {
        return resenasRepository.findById(id);
    }

    public Resenas crearResena(Resenas resena) {
        return resenasRepository.save(resena);
    }

    public List<Resenas> obtenerResenasPorPropiedad(Long propiedadId) {
        return resenasRepository.findByPropiedadId(propiedadId);
    }

    public List<Resenas> obtenerResenasPorUsuario(Long usuarioId) {
        return resenasRepository.findByUsuarioId(usuarioId);
    }

    public List<Resenas> listarPorPropiedad(Long propiedadId) {
        return obtenerResenasPorPropiedad(propiedadId);
    }

    public List<Resenas> listarPorUsuario(Long usuarioId) {
        return obtenerResenasPorUsuario(usuarioId);
    }

    public boolean eliminarResena(Long resenaId) {
        if (resenasRepository.existsById(resenaId)) {
            resenasRepository.deleteById(resenaId);
            return true;
        }
        return false;
    }
    //// Método para actualizar una reseña
    public Resenas actualizarResena(Long resenaId, Resenas resenaActualizada) {
        Resenas resenaExistente = resenasRepository.findById(resenaId)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));

        // Actualiza campos manualmente
        if (resenaActualizada.getComentario() != null) {
            resenaExistente.setComentario(resenaActualizada.getComentario());
        }
        if (resenaActualizada.getCalificacion() != null) {
            resenaExistente.setCalificacion(resenaActualizada.getCalificacion());
        }

        return resenasRepository.save(resenaExistente);
    }
}
