package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dao.PeliculaDao;
import com.alkemy.challenge.dao.PersonajeDao;
import com.alkemy.challenge.model.Pelicula;
import com.alkemy.challenge.model.Personaje;
import com.alkemy.challenge.service.PersonajeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    PersonajeDao personajeDao;
    
    @Autowired
    PeliculaDao peliculaDao;
    
    @Override
    public List<Personaje> listarPersonajes() {
        return personajeDao.findAll();
    }

    @Override
    public Personaje guardarPersonaje(Personaje personaje) {
        return personajeDao.save(personaje);
    }

    @Override
    public void eliminarPersonaje(Personaje personaje) {
        personajeDao.delete(personaje);
    }

    @Override
    public Personaje encontrarPersonaje(Personaje personaje) {
        return personajeDao.findById(personaje.getIdPersonaje()).orElse(null);
    }

    @Override
    public Personaje encontrarPersonajePorId(Long id) {
        return personajeDao.findById(id).orElse(null);
    }

    @Override
    public void eliminarPersonajePorId(Long id) {
        personajeDao.deleteById(id);
    }

    @Override
    public Personaje guardarPersonaje(Long id, Personaje nuevoPersonaje) {
        return personajeDao.findById(id)
                .map((Personaje personaje) -> {
                    personaje.setImagen(nuevoPersonaje.getImagen());
                    personaje.setNombre(nuevoPersonaje.getNombre());
                    personaje.setEdad(nuevoPersonaje.getEdad());
                    personaje.setHistoria(nuevoPersonaje.getHistoria());
                    personaje.setPeso(nuevoPersonaje.getPeso());
                    List<Pelicula> peliculas = new ArrayList<>();
                    nuevoPersonaje.getPeliculasAsociadas().forEach((t) -> {
                        peliculas.add(peliculaDao.getById(t.getIdPelicula()));
                    });
                    personaje.setPeliculasAsociadas(peliculas);
                    return personajeDao.save(personaje);
                })
                .orElseGet(() -> {
                    nuevoPersonaje.setIdPersonaje(id);
                    return personajeDao.save(nuevoPersonaje);
                });
    }
}
