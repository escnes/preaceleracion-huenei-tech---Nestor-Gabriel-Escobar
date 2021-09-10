package com.alkemy.challenge.dto;

import java.io.Serializable;
import java.util.List;

public class DetallePersonajeDto implements Serializable{
    private String imagen;

    private String nombre;

    private int edad;

    private float peso;

    private String historia;

    private List<PeliculaDto> peliculasAsociadas;

    public DetallePersonajeDto(String imagen, String nombre, int edad, float peso, String historia, List<PeliculaDto> peliculasAsociadas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculasAsociadas = peliculasAsociadas;
    }
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public List<PeliculaDto> getPeliculasAsociadas() {
        return peliculasAsociadas;
    }

    public void setPeliculasAsociadas(List<PeliculaDto> peliculasAsociadas) {
        this.peliculasAsociadas = peliculasAsociadas;
    }
    
    
}
