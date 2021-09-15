package com.alkemy.challenge.dto;

import java.io.Serializable;
import java.util.List;

//Objeto plano que me sirve para poder devolver atributos personalizados
public class DetallePeliculaDto implements Serializable {
    
    private String imagen;

    private String titulo;
    
    private String fechaCreacion;
    
    private int calificacion;
    
    private List<PersonajeDto> personajesAsociados;

    private List<GeneroDto> generosAsociados;
    
    public DetallePeliculaDto(String imagen, String titulo, String fechaCreacion, int calificacion, List<GeneroDto> generosAsociados, List<PersonajeDto> personajesAsociados) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.generosAsociados = generosAsociados;
        this.personajesAsociados = personajesAsociados;
    }
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<PersonajeDto> getPersonajesAsociados() {
        return personajesAsociados;
    }

    public void setPersonajesAsociados(List<PersonajeDto> personajesAsociados) {
        this.personajesAsociados = personajesAsociados;
    }

    public List<GeneroDto> getGenerosAsociados() {
        return generosAsociados;
    }

    public void setGenerosAsociados(List<GeneroDto> generosAsociados) {
        this.generosAsociados = generosAsociados;
    }
    
    
}
