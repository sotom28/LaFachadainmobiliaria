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

import com.example.LaFachada.Dto.ResenaCrearDTO;
import com.example.LaFachada.Model.Resenas;
import com.example.LaFachada.Service.ResenasService;


@RestController
@RequestMapping("/api/v1/resenas")
public class ResenasController {

    private final ResenasService resenasService;

    ResenasController(ResenasService resenasService) {
        this.resenasService = resenasService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Resenas>> listarTodas() {
        return ResponseEntity.ok(resenasService.listarTodas());
    }

    @GetMapping("/publicacionId/{id}")
    public ResponseEntity<List<Resenas>> listarTodasPorPublicacionId(@PathVariable Integer id) {
        List<Resenas> resenas = resenasService.obtenerPorPublicacionId(id);
        return ResponseEntity.ok(resenas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Resenas> obtenerPorId(@PathVariable Long id) {
        return resenasService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Resenas> crearResena(@RequestBody ResenaCrearDTO dto) {
        Resenas nueva = resenasService.crearResena(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);

    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Resenas>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(resenasService.listarPorUsuario(usuarioId));
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = resenasService.eliminarResena(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
