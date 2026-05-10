package com.example.LaFachada.Dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResenaCrearDTO {
    @NotBlank(message = "El comentario no puede venir vacio")
    private String comentario;

    @Min(value = 0, message = "La calificacion no puede ser menor a 0")
    @Max(value = 5, message = "La calificacion no puede ser mayor a 5")
    @NotNull
    private Integer calificacion;

    private LocalDate fecha;

    @NotNull(message = "La resena tiene que estar asociada a una publicacion")
    private Long publicacionId;

    @NotNull(message = "El id usuario no puede ser nulo")
    private Long usuarioId;

}
