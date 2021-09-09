package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dao.PersonajeDao;
import com.alkemy.challenge.model.Personaje;
import com.alkemy.challenge.service.PersonajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    PersonajeDao personajeDao;
    
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
    public Personaje modificarPersonaje(Long id, Personaje personaje) {
        Personaje p = personajeDao.findById(id).get();
        p.setEdad(personaje.getEdad());
        p.setHistoria(personaje.getHistoria());
        p.setImagen(personaje.getImagen());
        p.setNombre(personaje.getNombre());
        p.setPeliculaAsociada(personaje.getPeliculaAsociada());
        p.setPeso(personaje.getPeso());
        return personajeDao.save(p);
    }
}
