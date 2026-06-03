package com.example.LaFachada.Dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
@Data
public class PublicacionModificarDto {
    private String titulo;

    private String descripcion;

    @PositiveOrZero
    private Double precio;

    private String estado;
}
