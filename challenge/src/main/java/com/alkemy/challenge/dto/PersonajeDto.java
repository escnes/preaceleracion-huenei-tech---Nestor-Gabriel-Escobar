package com.alkemy.challenge.dto;

import java.io.Serializable;

public class PersonajeDto implements Serializable{
    private String nombre;
    private String imagen;

    public PersonajeDto() {
    }

    public PersonajeDto(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
