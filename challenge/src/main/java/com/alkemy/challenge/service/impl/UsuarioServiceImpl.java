package com.alkemy.challenge.service.impl;

import com.alkemy.challenge.dao.UsuarioDao;
import com.alkemy.challenge.dto.UsuarioDto;
import com.alkemy.challenge.model.Usuario;
import com.alkemy.challenge.model.builder.UsuarioBuilder;
import com.alkemy.challenge.service.SendMailService;
import com.alkemy.challenge.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
        @Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private SendMailService sendMailService;
	
	@Override
	public Usuario findByUsername(String username) {
		Usuario usuario = usuarioDao.findByUsername(username);
		return usuario;
	}

        
	@Override
	public Usuario save(UsuarioDto usuarioDto) {
		Usuario usuario = new UsuarioBuilder().withUsuarioDto(usuarioDto).build();
		usuario = usuarioDao.save(usuario);
		sendMailService.sendEmail(usuario);
		return usuario;
	}
}
