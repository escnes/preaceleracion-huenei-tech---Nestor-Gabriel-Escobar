package com.alkemy.challenge.dto;

import java.io.Serializable;

public class PeliculaDto implements Serializable{
    private String titulo;
    private String imagen;
    private String fechaCreacion;

    public PeliculaDto(){
    }
    
    public PeliculaDto(String titulo, String imagen, String fechaCreacion) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
