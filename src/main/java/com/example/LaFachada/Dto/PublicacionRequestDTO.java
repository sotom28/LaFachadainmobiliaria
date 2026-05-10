package com.example.LaFachada.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PublicacionRequestDTO {

    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 3, max = 150, message = "El título debe tener entre 3 y 150 caracteres")
    private String titulo;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 1000, message = "La descripción debe tener entre 10 y 1000 caracteres")
    private String descripcion;

    @NotNull(message = "El precio no puede ser nulo")
    @Min(value = 0, message = "El precio no puede ser negativo")
    @Max(value = 999999999, message = "El precio excede el límite permitido")
    private Integer precio;

    @NotBlank(message = "La ubicación no puede estar vacía")
    @Size(min = 3, max = 200, message = "La ubicación debe tener entre 3 y 200 caracteres")
    private String ubicacion;

    @NotNull(message = "El vendedorId no puede ser nulo")
    @Positive(message = "El vendedorId debe ser positivo")
    private Integer vendedorId;

    @NotBlank(message = "El tipo de venta no puede estar vacío")
    @Pattern(regexp = "venta|arriendo", message = "El tipo de venta debe ser 'venta' o 'arriendo'")
    private String tipoventas;

 

    @NotNull(message = "El propiedadId no puede ser nulo")
    @Positive(message = "El propiedadId debe ser positivo")
    private Integer propiedadId;

    @NotBlank(message = "El estado no puede estar vacío")
    @Pattern(regexp = "disponible|vendido|suspendido", message = "El estado debe ser 'disponible', 'vendido' o 'suspendido'")
    private String estado;
    

    
    
}

