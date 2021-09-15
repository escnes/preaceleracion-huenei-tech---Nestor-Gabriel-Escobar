package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dao.GeneroDao;
import com.alkemy.challenge.dao.PeliculaDao;
import com.alkemy.challenge.dao.PersonajeDao;
import com.alkemy.challenge.model.Genero;
import com.alkemy.challenge.model.Pelicula;
import com.alkemy.challenge.model.Personaje;
import com.alkemy.challenge.service.PeliculaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaDao peliculaDao;

    @Autowired
    PersonajeDao personajeDao;

    @Autowired
    GeneroDao generoDao;

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaDao.findAll();
    }

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaDao.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Pelicula pelicula) {
        peliculaDao.delete(pelicula);
    }

    @Override
    public Pelicula encontrarPelicula(Pelicula pelicula) {
        return peliculaDao.findById(pelicula.getIdPelicula()).orElse(null);
    }

    @Override
    public void eliminarPeliculaPorId(Long id) {
        peliculaDao.deleteById(id);
    }

    @Override
    public Pelicula encontrarPeliculaPorId(Long id) {
        return peliculaDao.findById(id).get();
    }

    @Override
    public Pelicula guardarPelicula(Long id, Pelicula nuevaPelicula) {
        return peliculaDao.findById(id)
                .map((Pelicula pelicula) -> {
                    pelicula.setCalificacion(nuevaPelicula.getCalificacion());
                    pelicula.setFechaCreacion(nuevaPelicula.getFechaCreacion());
                    pelicula.setImagen(nuevaPelicula.getImagen());
                    pelicula.setTitulo(nuevaPelicula.getTitulo());
                    List<Genero> generos = new ArrayList<>();
                    nuevaPelicula.getGenerosAsociados().forEach((genero) -> {
                        generos.add(generoDao.getById(genero.getIdGenero()));
                    });
                    pelicula.setGenerosAsociados(generos);
                    List<Personaje> personajes = new ArrayList<>();
                    nuevaPelicula.getPersonajesAsociados().forEach((personaje) -> {
                        personajes.add(personajeDao.getById(personaje.getIdPersonaje()));
                    });
                    pelicula.setPersonajesAsociados(personajes);
                    return peliculaDao.save(pelicula);
                })
                .orElseGet(() -> {
                    nuevaPelicula.setIdPelicula(id);
                    return peliculaDao.save(nuevaPelicula);
                });
    }

}
