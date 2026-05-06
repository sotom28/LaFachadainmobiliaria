package com.example.LaFachada.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LaFachada.Model.Reseñas;
import com.example.LaFachada.Service.ReseñasService;

@RestController
@RequestMapping("/api/reseñas")
public class ReseñasController {

    private final ReseñasService reseñasService;

    public ReseñasController(ReseñasService reseñasService) {
        this.reseñasService = reseñasService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reseñas>> listarTodas() {
        return ResponseEntity.ok(reseñasService.listarTodas());
    }

    @PostMapping("/crear")
    public ResponseEntity<Reseñas> crearReseña(@RequestBody Reseñas reseña) {
        Reseñas nuevaReseña = reseñasService.crearReseña(reseña);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReseña);
    }

    @GetMapping("/propiedad/{propiedadId}")
    public ResponseEntity<List<Reseñas>> listarPorPropiedad(@PathVariable Long propiedadId) {
        return ResponseEntity.ok(reseñasService.listarPorPropiedad(propiedadId));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Reseñas>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(reseñasService.listarPorUsuario(usuarioId));
    }

    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = reseñasService.eliminarReseña(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}

