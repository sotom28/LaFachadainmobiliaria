package com.example.LaFachada.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LaFachada.Model.Reseñas;
import com.example.LaFachada.Respository.ReseñasRepository;


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

        asignarComentario(reseñaExistente, obtenerComentario(reseñaActualizada));
        asignarCalificacion(reseñaExistente, obtenerCalificacion(reseñaActualizada));

        return reseñasRepository.save(reseñaExistente);
    }

    private void asignarComentario(Reseñas reseña, String comentario) {
        if (comentario == null) {
            return;
        }

        try {
            Method metodo = reseña.getClass().getMethod("setComentario", String.class);
            metodo.invoke(reseña, comentario);
        } catch (ReflectiveOperationException ex) {
            try {
                Method metodo = reseña.getClass().getMethod("setComentarioReseña", String.class);
                metodo.invoke(reseña, comentario);
            } catch (ReflectiveOperationException ex2) {
                // No-op if the model uses a different mutator name.
            }
        }
    }

    private String obtenerComentario(Reseñas reseña) {
        try {
            Method metodo = reseña.getClass().getMethod("getComentario");
            Object comentario = metodo.invoke(reseña);
            return comentario != null ? comentario.toString() : null;
        } catch (ReflectiveOperationException ex) {
            try {
                Method metodo = reseña.getClass().getMethod("getComentarioReseña");
                Object comentario = metodo.invoke(reseña);
                return comentario != null ? comentario.toString() : null;
            } catch (ReflectiveOperationException ex2) {
                // No-op if the model uses a different accessor name.
            }
        }
        return null;
    }

    
    private Integer obtenerCalificacion(Reseñas reseña) {
        Object calificacion = null;
        try {
            Method metodo = reseña.getClass().getMethod("getCalificacion");
            calificacion = metodo.invoke(reseña);
        } catch (ReflectiveOperationException ex) {
            try {
                Method metodo = reseña.getClass().getMethod("getCalificación");
                calificacion = metodo.invoke(reseña);
            } catch (ReflectiveOperationException ex2) {
                // No-op if the model uses a different accessor name.
            }
        }
        return calificacion instanceof Integer ? (Integer) calificacion : null;
    }

    private void asignarCalificacion(Reseñas reseña, Integer calificacion) {
        if (calificacion == null) {
            return;
        }

        try {
            Method metodo = reseña.getClass().getMethod("setCalificacion", Integer.class);
            metodo.invoke(reseña, calificacion);
        } catch (ReflectiveOperationException ex) {
            try {
                Method metodo = reseña.getClass().getMethod("setCalificación", Integer.class);
                metodo.invoke(reseña, calificacion);
            } catch (ReflectiveOperationException ex2) {
                // No-op if the model uses a different mutator name.
            }
        }
    }

    
   


}
