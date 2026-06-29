package com.example.LaFachada.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.LaFachada.Dto.PublicacionModificarDto;
import com.example.LaFachada.Dto.PublicacionRequestDTO;
import com.example.LaFachada.Model.Foto;
import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Service.PublicacionService;

import jakarta.validation.Valid;

@RequestMapping("/api/v1/publicacion")
@RestController
public class PublicacionController {

    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    // Listar todas las publicaciones
    @GetMapping("/all")
    public ResponseEntity<List<Publicacion>> listarTodas() {
        return ResponseEntity.ok(publicacionService.listarTodas());
    }

    @PostMapping("/por-propiedades")
    public ResponseEntity<List<Publicacion>> buscarPublicacionPorPropiedades(@RequestBody List<Integer> id) {
        List<Publicacion> publicaciones = publicacionService.buscarPorIdPropiedad(id);
        return ResponseEntity.ok(publicaciones);
    }

    // Obtener una publicación por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPorId(@PathVariable Integer id) {
        try {
            Publicacion publicacion = publicacionService.obtenerPublicacionPorId(id);
            return ResponseEntity.ok(publicacion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva publicación desde un DTO
    @PostMapping("/crear")
    public ResponseEntity<?> crearPublicacion(@Valid @RequestBody PublicacionRequestDTO dto, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

        try {
            Publicacion nuevaPublicacion = publicacionService.crearDesdeDTO(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPublicacion);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Map.of("error", "Error al crear la publicación: " + e.getMessage()));
        }
    }

    // Subir foto
    @PostMapping("/{id}/fotos")
    public ResponseEntity<?> subirFoto(@PathVariable("id") Integer publicacionId,
            @RequestParam("foto") List<MultipartFile> fotos) {
        try {
            if (fotos == null || fotos.isEmpty() || fotos.get(0).isEmpty()) {
                return ResponseEntity.badRequest().body("No se han seleccionado archivos válidos para subir.");
            }
            List<Foto> fotoGuardada = publicacionService.agregarFotoPublicacion(publicacionId, fotos);
            return ResponseEntity.status(HttpStatus.CREATED).body(fotoGuardada);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar y subir el archivo: " + e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Actualizar una publicación existente
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Integer id,
            @RequestBody PublicacionModificarDto dto) {
        try {
            Publicacion publicacion = publicacionService.actualizarPublicacion(id, dto);
            return ResponseEntity.ok(publicacion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una publicación por su ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Integer id) {
        boolean eliminado = publicacionService.eliminarPublicacion(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}