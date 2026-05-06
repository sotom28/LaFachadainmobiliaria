package com.example.LaFachada.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PublicacionDTO {
    private Long idpublicacion;
    private String titulo;
    private String descripcion;
    private Integer precio;
    private String ubicacion;
    private String Region;
    private String Comuna;
    private String contacto;
    private String estado;
    private String fechaPublicacion;
    private String tipoventas;
    private String fotosUrl;
    private String tipoPropiedad;
    private Integer cantidadhabitaciones;
    private Integer cantidadbaños;
}
