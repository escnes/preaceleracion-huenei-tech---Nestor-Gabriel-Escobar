package com.alkemy.challenge.dao;

import com.alkemy.challenge.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaDao extends JpaRepository<Pelicula,Long>{
    
}
