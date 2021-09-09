package com.alkemy.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long idPelicula;
    
    @Column
    private String imagen;
    
    @Column
    private String titulo;
    
    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    @Column(name = "fecha_creacion")
    private String fechaCreacion;
    
    @Column
    private int calificacion;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "pelicula_personaje",
            joinColumns = @JoinColumn(name = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_personaje")
    )
    private List<Personaje> personajeAsociado;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "pelicula_genero",
            joinColumns = @JoinColumn(name = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private List<Genero> generoAsociado;

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
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

    public List<Personaje> getPersonajeAsociado() {
        return personajeAsociado;
    }

    public void setPersonajeAsociado(List<Personaje> personajeAsociado) {
        this.personajeAsociado = personajeAsociado;
    }

    public List<Genero> getGeneroAsociado() {
        return generoAsociado;
    }

    public void setGeneroAsociado(List<Genero> generoAsociado) {
        this.generoAsociado = generoAsociado;
    }
    
    
}
