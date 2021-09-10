package com.alkemy.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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
    
    @ManyToMany(cascade = CascadeType.ALL)
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idPelicula);
        hash = 97 * hash + Objects.hashCode(this.imagen);
        hash = 97 * hash + Objects.hashCode(this.titulo);
        hash = 97 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 97 * hash + this.calificacion;
        hash = 97 * hash + Objects.hashCode(this.personajeAsociado);
        hash = 97 * hash + Objects.hashCode(this.generoAsociado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (this.calificacion != other.calificacion) {
            return false;
        }
        if (!Objects.equals(this.imagen, other.imagen)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) {
            return false;
        }
        if (!Objects.equals(this.idPelicula, other.idPelicula)) {
            return false;
        }
        if (!Objects.equals(this.personajeAsociado, other.personajeAsociado)) {
            return false;
        }
        if (!Objects.equals(this.generoAsociado, other.generoAsociado)) {
            return false;
        }
        return true;
    }

    
}
