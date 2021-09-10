package com.alkemy.challenge.service;

import com.alkemy.challenge.model.Genero;
import java.util.List;

public interface GeneroService {
    public List<Genero> listarGeneros();
    
    public void guardarGenero(Genero genero);
    
    public void eliminarGenero(Genero genero);
    
    public Genero encontrarGenero(Genero genero);
}
