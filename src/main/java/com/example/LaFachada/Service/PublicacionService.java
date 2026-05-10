package com.example.LaFachada.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LaFachada.Dto.PublicacionRequestDTO;
import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Respository.PublicacionRepository;
import java.time.LocalDateTime;


@Service
public class PublicacionService {

    // Inyección de dependencia del repositorio
    private final PublicacionRepository publicacionRepository;
    //
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



    /// mapero de DTO a y guardarlo
   public Publicacion crearDesdeDTO(PublicacionRequestDTO dto) {
    Publicacion pub = new Publicacion();
    pub.setTitulo(dto.getTitulo());
    pub.setDescripcion(dto.getDescripcion());
    pub.setPrecio(dto.getPrecio());
    pub.setUbicacion(dto.getUbicacion());
    
    pub.setVendedorId(dto.getVendedorId());
    pub.setTipoventas(dto.getTipoventas());
    pub.setPropiedadId(dto.getPropiedadId());
    
    pub.setEstado(dto.getEstado());
    pub.setFechaPublicacion(LocalDateTime.now());
   

    

    return publicacionRepository.save(pub);
    
}

}