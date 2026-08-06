package com.example.LaFachada.Dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PublicacionDTO {
    @NotBlank(message = "El título es obligatorio")
    @Size(min = 2, max = 255, message = "El título debe tener entre 2 y 255 caracteres")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, message = "La descripción debe tener al menos 10 caracteres")
    private String descripcion;

    @NotBlank(message = "El precio es obligatorio")
    @Size(min = 1, message = "El precio debe ser un número positivo")
    private Double precio;

    @NotBlank(message = "La ubicación es obligatoria")
    @Size(min = 2, max = 255, message = "La ubicación debe tener entre 2 y 255 caracteres")
    private String ubicacion;

    @NotBlank(message = "El ID del vendedor es obligatorio")
    @Size (min = 1, message = "El ID del vendedor debe ser un número positivo")
    private Integer vendedorId;

    @NotBlank(message = "El ID de la propiedad es obligatorio")
    @Size (min = 1, message = "El ID de la propiedad debe ser un número positivo")
    private Integer propiedadId;

    @NotBlank(message = "El estado es obligatorio")
    @Size(min = 2, max = 255, message = "El estado debe tener entre 2 y 255 caracteres")
    private String estado;

    @NotBlank(message = "El tipo de propiedad es obligatorio")
    @Size(min = 2, max = 255, message = "El tipo de propiedad debe tener entre 2 y 255 caracteres")
    private String tipoPropiedad;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaPublicacion;
}
