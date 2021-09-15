package com.alkemy.challenge.dao;

import com.alkemy.challenge.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
