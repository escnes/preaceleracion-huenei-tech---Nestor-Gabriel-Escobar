package com.alkemy.challenge.controller;

import com.alkemy.challenge.model.Pelicula;
import com.alkemy.challenge.model.Personaje;
import com.alkemy.challenge.service.PeliculaService;
import com.alkemy.challenge.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Controlador {
    
    @Autowired
    private PersonajeService personajeService;
    
    @Autowired
    private PeliculaService peliculaService;
    
    
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
    @GetMapping("/characters")
    public String listaPersonajes(Model model){
        var personajes = personajeService.listarPersonajes();
        model.addAttribute("personajes",personajes);
        return "characters";
    }
    
    @GetMapping("/movies")
    public String listaPeliculas(Model model){
        var peliculas = peliculaService.listarPeliculas();
        model.addAttribute("peliculas",peliculas);
        return "movies";
    }
    
    @GetMapping("/crearPersonaje")
    public String crearPersonaje(Personaje personaje){
        return "modificarPersonaje";
    }
    
    @GetMapping("/crearPelicula")
    public String crearPelicula(Pelicula pelicula){
        return "modificarPelicula";
    }
    
    @PostMapping("/guardarPersonaje")
    public String guardarPersonaje(Personaje personaje){
        personajeService.guardarPersonaje(personaje);
        return "redirect:/characters";
    }
    
    @PostMapping("/guardarPelicula")
    public String guardarPelicula(Pelicula pelicula){
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/movies";
    }
}
