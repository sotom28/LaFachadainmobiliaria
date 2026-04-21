package com.example.LaFachada.Service;

import com.example.LaFachada.Model.Reseñas;
import com.example.LaFachada.Respository.ReseñasRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReseñasService {


    private final ReseñasRepository reseñasRepository;

    public ReseñasService(ReseñasRepository reseñasRepository) {
        this.reseñasRepository = reseñasRepository;
    }

    public List<Reseñas> listarTodas() {
        return reseñasRepository.findAll();
    }

    public Optional<Reseñas> obtenerPorId(Long id) {
        return reseñasRepository.findById(id);
    }

    public Reseñas crearReseña(Reseñas reseña) {
        if (reseña.getFecha() == null) {
            reseña.setFecha(LocalDate.now());
        }
        return reseñasRepository.save(reseña);
    }

    public List<Reseñas> obtenerResenasPorPropiedad(Long propiedadId) {
        return reseñasRepository.findByPropiedadId(propiedadId);
    }

    public List<Reseñas> obtenerResenasPorUsuario(Long usuarioId) {
        return reseñasRepository.findByUsuarioId(usuarioId);
    }

    public List<Reseñas> listarPorPropiedad(Long propiedadId) {
        return obtenerResenasPorPropiedad(propiedadId);
    }

    public List<Reseñas> listarPorUsuario(Long usuarioId) {
        return obtenerResenasPorUsuario(usuarioId);
    }

    public boolean eliminarReseña(Long reseñaId) {
        if (reseñasRepository.existsById(reseñaId)) {
            reseñasRepository.deleteById(reseñaId);
            return true;
        }
        return false;
    }

    public Reseñas actualizarReseñas(Long reseñaId, Reseñas reseñaActualizada) {
        Reseñas reseñaExistente = reseñasRepository.findById(reseñaId)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));

        reseñaExistente.setComentario(reseñaActualizada.getComentario());
        reseñaExistente.setCalificacion(reseñaActualizada.getCalificacion());
        reseñaExistente.setFecha(reseñaActualizada.getFecha());

        return reseñasRepository.save(reseñaExistente);
    }

    public Optional<Reseñas> actualizar(Long id, Reseñas data) {
        return reseñasRepository.findById(id).map(reseña -> {
            reseña.setComentario(data.getComentario());
            reseña.setCalificacion(data.getCalificacion());
            reseña.setFecha(data.getFecha());
            reseña.setUsuarioId(data.getUsuarioId());
            reseña.setPropiedadId(data.getPropiedadId());
            return reseñasRepository.save(reseña);
        });
    }

    public boolean eliminar(Long id) {
        return eliminarReseña(id);
    }


}
