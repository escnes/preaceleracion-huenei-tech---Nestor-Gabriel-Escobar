package com.alkemy.challenge.service;

import com.alkemy.challenge.model.Pelicula;
import java.util.List;

public interface PeliculaService {
    
    public List<Pelicula> listarPeliculas();
    
    public Pelicula guardarPelicula(Pelicula pelicula);
    
    public Pelicula guardarPelicula(Long id, Pelicula pelicula);
    
    public void eliminarPelicula(Pelicula pelicula);
    
    public void eliminarPeliculaPorId(Long id);
    
    public Pelicula encontrarPelicula(Pelicula pelicula);
    
    public Pelicula encontrarPeliculaPorId(Long id);
}
