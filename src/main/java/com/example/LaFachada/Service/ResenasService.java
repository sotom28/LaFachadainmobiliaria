package com.example.LaFachada.Service;

import com.example.LaFachada.Respository.PublicacionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LaFachada.Dto.ResenaCrearDTO;
import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Model.Resenas;
import com.example.LaFachada.Respository.ResenasRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ResenasService {

    private final PublicacionRepository publicacionRepository;
    private final ResenasRepository resenasRepository;

    public ResenasService(ResenasRepository resenasRepository, PublicacionRepository publicacionRepository) {
        this.resenasRepository = resenasRepository;
        this.publicacionRepository = publicacionRepository;
    }

    public List<Resenas> listarTodas() {
        return resenasRepository.findAll();
    }

    public Optional<Resenas> obtenerPorId(Long id) {
        return resenasRepository.findById(id);
    }


    public List<Resenas> obtenerPorPublicacionId(Integer id) {
        Publicacion pub =publicacionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se han encontrado esta publicacion"));
        return resenasRepository.findByPublicacion(pub);
    }

    public Resenas crearResena(ResenaCrearDTO dto) {
        Publicacion pub = publicacionRepository.findById(dto.getPublicacionId())
                .orElseThrow(() -> new EntityNotFoundException("Publicacion no encontrada"));
        Resenas resena = new Resenas();
        resena.setFecha(LocalDate.now());
        resena.setCalificacion(dto.getCalificacion());
        resena.setComentario(dto.getComentario());
        resena.setUsuarioId(dto.getUsuarioId());
        resena.setPublicacion(pub);
        return resenasRepository.save(resena);
    }

    public List<Resenas> obtenerResenasPorUsuario(Long usuarioId) {
        return resenasRepository.findByUsuarioId(usuarioId);
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
