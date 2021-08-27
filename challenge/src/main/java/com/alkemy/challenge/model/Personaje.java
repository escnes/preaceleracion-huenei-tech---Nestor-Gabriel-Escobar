package com.alkemy.challenge.model;

import java.awt.Image;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "personaje")
public class Personaje implements Serializable {
    
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


    @OneToOne
    @JoinColumn(name = "pelicula_asociada")
    private Pelicula peliculaAsociada;
}
