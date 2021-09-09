package com.alkemy.challenge.controller;

import com.alkemy.challenge.model.Personaje;
import com.alkemy.challenge.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin("*")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;
    
    @GetMapping("/characters")
    public String listaPersonajes(Model model){
        var personajes = personajeService.listarPersonajes();
        model.addAttribute("personajes",personajes);
        return "characters";
    }
    
    @GetMapping("/characters/crear")
    public String crearPersonaje(Personaje personaje){
        return "modificarPersonaje";
    }
    
    @PostMapping("/characters/guardar")
    public String guardarPersonaje(Personaje personaje){
        personajeService.guardarPersonaje(personaje);
        return "redirect:/characters";
    }
    
    @GetMapping("/characters/editar")
    public String editar(Personaje personaje, Model model){
       personaje = personajeService.encontrarPersonaje(personaje);
       model.addAttribute("personaje", personaje);
       return "modificarPersonaje";
    }
    
    @DeleteMapping("/characters/eliminar")
    public String eliminarPersonaje(Personaje personaje){
        personajeService.eliminarPersonaje(personaje);
        return "redirect:/characters";
    }
    
    @GetMapping("/characters/detalle")
    public String detallePersonaje(Personaje personaje, Model model){
        personaje = personajeService.encontrarPersonaje(personaje);
        model.addAttribute("personaje", personaje);
        return "detallePersonaje";
    }
}
