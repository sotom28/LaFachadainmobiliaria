package com.example.LaFachada.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Service.PublicacionService;


@Controller
@RequestMapping("/api/publicacion")
@RestController
public class PublicacionController {

  
    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Publicacion>> listarTodas() {
        return ResponseEntity.ok(publicacionService.listarTodas());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPorId(@PathVariable Long id) {
        try {
            Publicacion publicacion = publicacionService.obtenerPublicacionPorId(id);
            return ResponseEntity.ok(publicacion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        Publicacion nuevaPublicacion = publicacionService.crearPublicacion(publicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPublicacion);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacionActualizada) {
        try {
            Publicacion publicacion = publicacionService.actualizarPublicacion(id, publicacionActualizada);
            return ResponseEntity.ok(publicacion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) {
        boolean eliminado = publicacionService.eliminarPublicacion(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }





    
}
