package com.example.LaFachada.Dto;

import java.time.LocalDate;

public class ResenasRequestDTO {
    private String comentario;
    private Integer calificacion;
    private LocalDate fecha;
    private Long usuarioId;
    private Long publicacionId;

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Integer getCalificacion() { return calificacion; }
    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getPublicacionId() { return publicacionId; }
    public void setPublicacionId(Long publicacionId) { this.publicacionId = publicacionId; }
}
