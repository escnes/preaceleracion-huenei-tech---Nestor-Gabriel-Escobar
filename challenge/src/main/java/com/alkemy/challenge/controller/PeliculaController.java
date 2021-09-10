package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.DetallePeliculaDto;
import com.alkemy.challenge.dto.PeliculaDto;
import com.alkemy.challenge.dto.PersonajeDto;
import com.alkemy.challenge.model.Pelicula;
import com.alkemy.challenge.model.Personaje;
import com.alkemy.challenge.service.PeliculaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    
    @GetMapping("/movies")
    public List<PeliculaDto> listMovie(){
        List<PeliculaDto> peliculasDto = new ArrayList<>();
        List<Pelicula> peliculas = peliculaService.listarPeliculas();
        peliculas.forEach(pelicula -> {
            peliculasDto.add(new PeliculaDto(pelicula.getTitulo(),pelicula.getImagen(),pelicula.getFechaCreacion()));
        });
        return peliculasDto;
    }
    
    @PostMapping("/movies")
    public Pelicula saveMovie(@RequestBody Pelicula pelicula){
        return peliculaService.guardarPelicula(pelicula);
    }
    
    @GetMapping("/movies/{id}")
    public DetallePeliculaDto oneMovie(@PathVariable Long id){
        Pelicula pelicula = peliculaService.encontrarPeliculaPorId(id);
        List<PersonajeDto> personajesDto = new ArrayList();
        List<Personaje> personajes = pelicula.getPersonajeAsociado();
        personajes.forEach(personaje -> {
            personajesDto.add(new PersonajeDto(personaje.getNombre(),personaje.getImagen()));
        });
        return new DetallePeliculaDto(pelicula.getImagen(),pelicula.getTitulo(),pelicula.getFechaCreacion(),pelicula.getCalificacion(),personajesDto);
    }
    
    @PutMapping("/movies/{id}")
    public Pelicula editMovie(@RequestBody Pelicula personaje, @PathVariable Long id){
       return peliculaService.guardarPelicula(id, personaje);
    }
    
    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Long id){
        peliculaService.eliminarPeliculaPorId(id);
    }
}
