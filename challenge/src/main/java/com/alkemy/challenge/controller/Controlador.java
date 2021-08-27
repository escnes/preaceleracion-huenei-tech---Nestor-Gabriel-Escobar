package com.alkemy.challenge.controller;

import com.alkemy.challenge.service.PeliculaService;
import com.alkemy.challenge.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Controlador {
    
    @Autowired
    private PersonajeService personajeService;
    
    @Autowired
    private PeliculaService peliculaService;
    
    
    @GetMapping("/")
    public String inicio(Model model){
      
        var personajes = personajeService.listarPersonajes();
        var peliculas = peliculaService.listarPeliculas();
        model.addAttribute("personajes",personajes);
        model.addAttribute("peliculas",peliculas);
        return "index";
    }
}
