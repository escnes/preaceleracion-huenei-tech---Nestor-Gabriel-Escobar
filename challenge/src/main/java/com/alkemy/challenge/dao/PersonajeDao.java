package com.alkemy.challenge.dao;

import com.alkemy.challenge.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeDao extends JpaRepository<Personaje,Long>{
    
}
