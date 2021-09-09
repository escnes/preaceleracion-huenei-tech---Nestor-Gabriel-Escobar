package com.alkemy.challenge.service;

import com.alkemy.challenge.model.Personaje;
import java.util.List;

public interface PersonajeService {
    public List<Personaje> listarPersonajes();
    
    public Personaje guardarPersonaje(Personaje personaje);
    
    public void eliminarPersonaje(Personaje personaje);
    
    public Personaje encontrarPersonaje(Personaje personaje);
    
    public Personaje modificarPersonaje(Long id, Personaje personaje);
}
