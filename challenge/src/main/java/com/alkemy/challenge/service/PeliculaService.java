package com.alkemy.challenge.service;

import com.alkemy.challenge.model.Pelicula;
import java.util.List;

public interface PeliculaService {
    
    public List<Pelicula> listarPeliculas();
    
    public void guardarPelicula(Pelicula pelicula);
    
    public void eliminarPelicula(Pelicula pelicula);
    
    public Pelicula encontrarPelicula(Pelicula pelicula);
}
