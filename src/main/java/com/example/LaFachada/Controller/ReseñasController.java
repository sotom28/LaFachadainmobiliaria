package com.example.LaFachada.Controller;

import com.example.LaFachada.Model.Reseñas;
import com.example.LaFachada.Service.ReseñasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<Reseñas> actualizar(@PathVariable Long id, @RequestBody Reseñas reseña) {
        return reseñasService.actualizar(id, reseña)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = reseñasService.eliminar(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}

