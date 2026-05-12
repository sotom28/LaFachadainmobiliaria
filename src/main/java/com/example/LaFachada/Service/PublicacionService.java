package com.example.LaFachada.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LaFachada.Dto.PublicacionModificarDto;
import com.example.LaFachada.Dto.PublicacionRequestDTO;
import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Respository.PublicacionRepository;
import java.time.LocalDateTime;

@Service
public class PublicacionService {

    // Inyección de dependencia del repositorio
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

    /// actualizar una publicación existente
    public Publicacion actualizarPublicacion(Integer id, PublicacionModificarDto dto) {
        return publicacionRepository.findById(id)
                .map(publicacion -> {
                    if(dto.getDescripcion() != null) publicacion.setDescripcion(dto.getDescripcion());
                    if(dto.getTitulo() != null) publicacion.setTitulo(dto.getTitulo());
                    if(dto.getPrecio() != null) publicacion.setPrecio(dto.getPrecio());
                    if(dto.getEstado() != null) publicacion.setEstado(dto.getEstado());
                    return publicacionRepository.save(publicacion);
                })
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada con id: " + id));
    }

    public boolean eliminarPublicacion(Integer id) {
        if (publicacionRepository.existsById(id)) {
            publicacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Publicacion obtenerPublicacionPorId(Integer id) {
        return publicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada con id: " + id));
    }

    /// mapero de DTO a y guardarlo
    public Publicacion crearDesdeDTO(PublicacionRequestDTO dto) {
        Publicacion pub = new Publicacion();
        pub.setTitulo(dto.getTitulo());
        pub.setDescripcion(dto.getDescripcion());
        pub.setPrecio(dto.getPrecio());
        pub.setUbicacion(dto.getUbicacion());

        pub.setVendedorId(dto.getVendedorId());
        pub.setTipoventas(dto.getTipoVentas());
        pub.setPropiedadId(dto.getPropiedadId());

        pub.setEstado("disponible");
        pub.setFechaPublicacion(LocalDateTime.now());
        return publicacionRepository.save(pub);
    }

}