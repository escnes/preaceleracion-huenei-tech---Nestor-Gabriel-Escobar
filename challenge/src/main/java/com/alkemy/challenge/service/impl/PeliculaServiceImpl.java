package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dao.PeliculaDao;
import com.alkemy.challenge.model.Pelicula;
import com.alkemy.challenge.service.PeliculaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    PeliculaDao peliculaDao;
    
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
                .map( pelicula -> {
                    pelicula.setCalificacion(nuevaPelicula.getCalificacion());
                    pelicula.setFechaCreacion(nuevaPelicula.getFechaCreacion());
                    pelicula.setImagen(nuevaPelicula.getImagen());
                    pelicula.setTitulo(nuevaPelicula.getTitulo());
                    pelicula.setGeneroAsociado(nuevaPelicula.getGeneroAsociado());
                    pelicula.setPersonajeAsociado(nuevaPelicula.getPersonajeAsociado());
                    return peliculaDao.save(pelicula);
                })
                .orElseGet(() -> {
                    nuevaPelicula.setIdPelicula(id);
                    return peliculaDao.save(nuevaPelicula);
                });
    }
    
}
