package com.alkemy.challenge.dao;

import com.alkemy.challenge.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

//Al extender de JpaRepository no tengo que implementar algunos metodos que voy a usar después en el serviceimpl
public interface GeneroDao extends JpaRepository<Genero,Long>{
    
}
