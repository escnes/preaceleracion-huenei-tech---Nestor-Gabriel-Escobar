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

@Entity
@Table(name = "personaje")
public class Personaje implements Serializable {

    public Personaje() {
    }

    public Personaje(Long idPersonaje, String imagen, String nombre, int edad, float peso, String historia, List<Pelicula> peliculasAsociadas) {
        this.idPersonaje = idPersonaje;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculasAsociadas = peliculasAsociadas;
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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "pelicula_personaje",
            joinColumns = @JoinColumn(name = "id_personaje"),
            inverseJoinColumns = @JoinColumn(name = "id_pelicula")
    )
    private List<Pelicula> peliculasAsociadas;

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

    public List<Pelicula> getPeliculasAsociadas() {
        return peliculasAsociadas;
    }

    public void setPeliculasAsociadas(List<Pelicula> peliculaAsociada) {
        this.peliculasAsociadas = peliculaAsociada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idPersonaje);
        hash = 31 * hash + Objects.hashCode(this.imagen);
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + this.edad;
        hash = 31 * hash + Float.floatToIntBits(this.peso);
        hash = 31 * hash + Objects.hashCode(this.historia);
        hash = 31 * hash + Objects.hashCode(this.peliculasAsociadas);
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
        final Personaje other = (Personaje) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (Float.floatToIntBits(this.peso) != Float.floatToIntBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.imagen, other.imagen)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.historia, other.historia)) {
            return false;
        }
        if (!Objects.equals(this.idPersonaje, other.idPersonaje)) {
            return false;
        }
        if (!Objects.equals(this.peliculasAsociadas, other.peliculasAsociadas)) {
            return false;
        }
        return true;
    }
    
    
}
