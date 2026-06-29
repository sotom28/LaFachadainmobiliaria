package com.example.LaFachada.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.LaFachada.Dto.PublicacionModificarDto;
import com.example.LaFachada.Dto.PublicacionRequestDTO;
import com.example.LaFachada.Model.Foto;
import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Respository.FotoRepository;
import com.example.LaFachada.Respository.PublicacionRepository;

import jakarta.transaction.Transactional;

@Service
public class PublicacionService {

    // Inyección de dependencia del repositorio
    private final PublicacionRepository publicacionRepository;
    private final FotoRepository fotoRepository;
    private final S3Service s3Service;

    public PublicacionService(PublicacionRepository publicacionRepository,
            FotoRepository fotoRepository,
            S3Service s3Service) {
        this.publicacionRepository = publicacionRepository;
        this.fotoRepository = fotoRepository;
        this.s3Service = s3Service;
    }

    public List<Publicacion> listarTodas() {
        return publicacionRepository.findAll();
    }

    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public List<Publicacion> buscarPorIdPropiedad(List<Integer> propiedadIds) {
        if(propiedadIds == null || propiedadIds.isEmpty()) {
            return List.of();
        }

        return publicacionRepository.buscarPorPropiedadIds(propiedadIds);
    }

    @Transactional
    public List<Foto> agregarFotoPublicacion(Integer publicacionId, List<MultipartFile> foto) throws IOException {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RuntimeException("Publicacion no encontrada"));

        List<Foto> fotosGuardadas = new ArrayList<>();
        List<String> urlFotos = s3Service.subirFoto(publicacionId, foto);
        int totalProcesar = Math.min(urlFotos.size(), foto.size());
        for (int i = 0; i < totalProcesar; i++) {
            Foto fotoGuardada = new Foto();
            fotoGuardada.setUrl(urlFotos.get(i));
            fotoGuardada.setNombre(foto.get(i).getOriginalFilename());
            fotoGuardada.setPublicacion(publicacion);
            fotoRepository.save(fotoGuardada);
            fotosGuardadas.add(fotoGuardada);
        }
        return fotosGuardadas;
    }

    /// actualizar una publicación existente
    public Publicacion actualizarPublicacion(Integer id, PublicacionModificarDto dto) {
        return publicacionRepository.findById(id)
                .map(publicacion -> {
                    if (dto.getDescripcion() != null)
                        publicacion.setDescripcion(dto.getDescripcion());
                    if (dto.getTitulo() != null)
                        publicacion.setTitulo(dto.getTitulo());
                    if (dto.getPrecio() != null)
                        publicacion.setPrecio(dto.getPrecio());
                    if (dto.getEstado() != null)
                        publicacion.setEstado(dto.getEstado());
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

    // mapero de DTO a y guardarlo
    public Publicacion crearDesdeDTO(PublicacionRequestDTO dto) {
        Publicacion pub = new Publicacion();
        pub.setTitulo(dto.getTitulo());
        pub.setDescripcion(dto.getDescripcion());
        pub.setPrecio(dto.getPrecio());
        pub.setUbicacion(dto.getUbicacion());

        pub.setVendedorId(dto.getVendedorId());
        pub.setPropiedadId(dto.getPropiedadId());

        pub.setEstado("disponible");
        pub.setFechaPublicacion(LocalDateTime.now());
        return publicacionRepository.save(pub);
    }

}
