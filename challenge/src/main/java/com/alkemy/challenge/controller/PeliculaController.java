package com.alkemy.challenge.controller;

import com.alkemy.challenge.model.Pelicula;
import com.alkemy.challenge.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin("*")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    
    @GetMapping("/movies")
    public String listaPersonajes(Model model){
        var peliculas = peliculaService.listarPeliculas();
        model.addAttribute("peliculas",peliculas);
        return "movies";
    }
    
    @GetMapping("/movies/crear")
    public String crearPersonaje(Pelicula pelicula){
        return "modificarPelicula";
    }
    
    @PostMapping("/movies/guardar")
    public String guardarPersonaje(Pelicula pelicula){
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/movies";
    }
    
    @GetMapping("/movies/editar")
    public String editar(Pelicula pelicula, Model model){
       pelicula = peliculaService.encontrarPelicula(pelicula);
       model.addAttribute("pelicula", pelicula);
       return "modificarPelicula";
    }
    
    @DeleteMapping("/movies/eliminar")
    public String eliminarPersonaje(Pelicula pelicula){
        peliculaService.eliminarPelicula(pelicula);
        return "redirect:/movies";
    }
    
    @GetMapping("/movies/detalle")
    public String detallePersonaje(Pelicula pelicula, Model model){
        pelicula = peliculaService.encontrarPelicula(pelicula);
        model.addAttribute("pelicula", pelicula);
        return "detallePelicula";
    }
}
