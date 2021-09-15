package com.alkemy.challenge.service;

import com.alkemy.challenge.model.Genero;
import java.util.List;

//Interfaz que voy a usar en el controller para poder hacer el crud
public interface GeneroService {
    public List<Genero> listarGeneros();
    
    public void guardarGenero(Genero genero);
    
    public void eliminarGenero(Genero genero);
    
    public Genero encontrarGenero(Genero genero);
    
    public Genero encontrarGeneroPorId(Long id);
}
