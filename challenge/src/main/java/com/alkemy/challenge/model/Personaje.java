package com.alkemy.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personaje")
public class Personaje implements Serializable {

    public Personaje() {
    }

    public Personaje(Long idPersonaje, String imagen, String nombre, int edad, float peso, String historia, List<Pelicula> peliculaAsociada) {
        this.idPersonaje = idPersonaje;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculaAsociada = peliculaAsociada;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personaje")
    private Long idPersonaje;
    
    @Column
    private String imagen;
    
    @Column
    private String nombre;
    
    @Column
    private int edad;
    
    @Column
    private float peso;
    
    @Column
    private String historia;

    @JsonIgnore
    @ManyToMany(mappedBy = "personajeAsociado")
    private List<Pelicula> peliculaAsociada;

    public Long getIdPersonaje() {
        return idPersonaje;
    }
    
    public void setIdPersonaje(Long idPersonaje) {
        this.idPersonaje = idPersonaje;
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

    public List<Pelicula> getPeliculaAsociada() {
        return peliculaAsociada;
    }

    public void setPeliculaAsociada(List<Pelicula> peliculaAsociada) {
        this.peliculaAsociada = peliculaAsociada;
    }
    
    
}
