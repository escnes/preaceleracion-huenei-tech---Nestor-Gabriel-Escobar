package com.alkemy.challenge.service;

import com.alkemy.challenge.model.Personaje;
import java.util.List;

public interface PersonajeService {
    
    public List<Personaje> listarPersonajes();
    
    public Personaje guardarPersonaje(Personaje personaje);
    
    public Personaje guardarPersonaje(Long id, Personaje nuevopersonaje);
    
    public void eliminarPersonaje(Personaje personaje);
    
    public void eliminarPersonajePorId(Long id);
    
    public Personaje encontrarPersonaje(Personaje personaje);
    
    public Personaje encontrarPersonajePorId(Long id);
}
