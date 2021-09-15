package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dao.GeneroDao;
import com.alkemy.challenge.model.Genero;
import com.alkemy.challenge.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//En esta clase utilizo el Dao para desarrollar las clases de la interfaz del service
@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    GeneroDao generoDao;
    
    @Override
    public List<Genero> listarGeneros() {
        return generoDao.findAll();
    }

    @Override
    public void guardarGenero(Genero genero) {
        generoDao.save(genero);
    }

    @Override
    public void eliminarGenero(Genero genero) {
        generoDao.delete(genero);
    }

    @Override
    public Genero encontrarGenero(Genero genero) {
        return generoDao.findById(genero.getIdGenero()).orElse(null);
    }

    @Override
    public Genero encontrarGeneroPorId(Long id) {
        return generoDao.findById(id).get();
    }
    
}
