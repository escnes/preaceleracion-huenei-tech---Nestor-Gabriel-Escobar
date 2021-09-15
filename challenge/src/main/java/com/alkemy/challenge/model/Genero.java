package com.alkemy.challenge.model;

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

@Entity//Clase que se modela desde la base de datos
@Table(name = "genero")
public class Genero implements Serializable {
    
    @Id//Este atributo es el identificador en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Me indica que el atributo es autoincremental
    @Column(name = "id_genero")//Al tener nombre diferente en la base de datos lo dejo indicado aca
    private Long idGenero;
    
    @Column
    private String nombre;
    
    @Column
    private String imagen;
    
    @ManyToMany(cascade = CascadeType.MERGE)//La relación es de muchos a muchos, al tener cascadeType.MERGE y no cascadeType.ALL no me borra la pelicula al borrar un genero
    @JoinTable(
            name = "pelicula_genero",//El nombre de la tabla en la base de datos
            joinColumns = @JoinColumn(name = "id_genero"),
            inverseJoinColumns = @JoinColumn(name = "id_pelicula")
    )
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.idGenero);
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.imagen);
        hash = 31 * hash + Objects.hashCode(this.peliculaAsociada);
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
        final Genero other = (Genero) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.imagen, other.imagen)) {
            return false;
        }
        if (!Objects.equals(this.idGenero, other.idGenero)) {
            return false;
        }
        if (!Objects.equals(this.peliculaAsociada, other.peliculaAsociada)) {
            return false;
        }
        return true;
    }
    
    
}
