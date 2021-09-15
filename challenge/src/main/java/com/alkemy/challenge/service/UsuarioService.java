package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.UsuarioDto;
import com.alkemy.challenge.model.Usuario;


public interface UsuarioService {
    public Usuario findByUsername(String username);
    public Usuario save(UsuarioDto usuarioDto);
}
