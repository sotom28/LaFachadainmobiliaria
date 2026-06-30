package com.example.LaFachada.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Respository.FotoRepository;
import com.example.LaFachada.Respository.PublicacionRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PublicacionServiceTest {

    @Mock
    private PublicacionRepository publicacionRepository;

    @Mock
    private FotoRepository fotoRepository;

    @Mock
    private S3Service s3Service;

    @InjectMocks
    private PublicacionService publicacionService;

    @Test
    void listarTodas() {

        Publicacion p = new Publicacion();
        p.setTitulo("Casa en venta");

        when(publicacionRepository.findAll()).thenReturn(List.of(p));

        List<Publicacion> lista = publicacionService.listarTodas();

        assertEquals(1, lista.size());
        verify(publicacionRepository).findAll();
    }

    @Test
    void obtenerPorId() {

        Publicacion p = new Publicacion();
        p.setTitulo("Casa en venta");

        when(publicacionRepository.findById(1))
                .thenReturn(Optional.of(p));

        Publicacion resultado = publicacionService.obtenerPublicacionPorId(1);

        assertEquals(p, resultado);
    }

    @Test
    void eliminarPublicacion() {

        when(publicacionRepository.existsById(1))
                .thenReturn(true);

        boolean eliminado = publicacionService.eliminarPublicacion(1);

        assertTrue(eliminado);

        verify(publicacionRepository).deleteById(1);
    }

}