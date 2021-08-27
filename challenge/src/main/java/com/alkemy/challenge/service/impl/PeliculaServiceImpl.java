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
    public void guardarPelicula(Pelicula pelicula) {
        peliculaDao.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Pelicula pelicula) {
        peliculaDao.delete(pelicula);
    }

    @Override
    public Pelicula encontrarPelicula(Pelicula pelicula) {
        return peliculaDao.findById(pelicula.getIdPelicula()).orElse(null);
    }
    
}
