package com.alkemy.challenge.webController;

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
public class WebController {
    @Autowired
    private PeliculaService peliculaService;
    
    @Autowired
    private PersonajeService personajeService;
    
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
    @GetMapping("/peliculas")
    public String listarPeliculas(Model model){
        var peliculas = peliculaService.listarPeliculas();
        model.addAttribute("peliculas",peliculas);
        return "peliculas";
    }
    
    @GetMapping("/peliculas/crear")
    public String crearPelicula(Pelicula pelicula){
        return "modificarPelicula";
    }
    
    @PostMapping("/peliculas/guardar")
    public String guardarPelicula(Pelicula pelicula){
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/peliculas";
    }
    
    @GetMapping("/peliculas/editar")
    public String editarPelicula(Pelicula pelicula, Model model){
       pelicula = peliculaService.encontrarPelicula(pelicula);
       model.addAttribute("pelicula", pelicula);
       return "modificarPelicula";
    }
    
    @GetMapping("/peliculas/eliminar")
    public String eliminarPelicula(Pelicula pelicula){
        peliculaService.eliminarPelicula(pelicula);
        return "redirect:/peliculas";
    }
    
    @GetMapping("/peliculas/detalle")
    public String detallePelicula(Pelicula pelicula, Model model){
        pelicula = peliculaService.encontrarPelicula(pelicula);
        model.addAttribute("pelicula", pelicula);
        return "detallePelicula";
    }
    
        
    @GetMapping("/personajes")
    public String listarPersonajes(Model model){
        var personajes = personajeService.listarPersonajes();
        model.addAttribute("personajes",personajes);
        return "personajes";
    }
    
        @GetMapping("/personajes/crear")
    public String crearPersonaje(Personaje personaje){
        return "modificarPersonaje";
    }
    
    @PostMapping("/personajes/guardar")
    public String guardarPersonaje(Personaje personaje){
        personajeService.guardarPersonaje(personaje);
        return "redirect:/personajes";
    }
    
    @GetMapping("/personajes/editar")
    public String editarPersonaje(Personaje personaje, Model model){
       personaje = personajeService.encontrarPersonaje(personaje);
       model.addAttribute("personaje", personaje);
       return "modificarPersonaje";
    }
    
    @GetMapping("/personajes/eliminar")
    public String eliminarPersonaje(Personaje personaje){
        personajeService.eliminarPersonaje(personaje);
        return "redirect:/personajes";
    }
    
        
    @GetMapping("/personajes/detalle")
    public String detallePersonaje(Personaje personaje, Model model){
        personaje = personajeService.encontrarPersonaje(personaje);
        model.addAttribute("personaje", personaje);
        return "detallePersonaje";
    }
}
