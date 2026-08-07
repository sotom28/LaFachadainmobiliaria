package com.example.LaFachada.Controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


import com.example.LaFachada.Model.Publicacion;
import com.example.LaFachada.Service.PublicacionService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
(PublicacionController.class)
class PublicacionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    PublicacionService publicacionService;

    @Test
    void listarTodas() throws Exception {

        Publicacion p = new Publicacion();
      
        p.setTitulo("Casa en venta");

        when(publicacionService.listarTodas())
                .thenReturn(List.of(p));

        mockMvc.perform(get("/api/v1/publicacion/all"))
                .andExpect(status().isOk());

    }


    
    @Test
    void obtenerPorId() throws Exception {

        Publicacion p = new Publicacion();
        p.setTitulo("Casa en venta");

        when(publicacionService.obtenerPublicacionPorId(1))
                .thenReturn(p);

        mockMvc.perform(get("/api/v1/publicacion/1"))
                .andExpect(status().isOk());

    }

    
    
    
}