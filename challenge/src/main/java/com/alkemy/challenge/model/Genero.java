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
@Table(name = "persona")
public class Genero implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Long idGenero;
    
    @Column
    private String imagen;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "generoAsociado")
    private List<Pelicula> peliculaAsociada;

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Pelicula> getPeliculaAsociada() {
        return peliculaAsociada;
    }

    public void setPeliculaAsociada(List<Pelicula> peliculaAsociada) {
        this.peliculaAsociada = peliculaAsociada;
    }
    
    
}
