package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.DetallePersonajeDto;
import com.alkemy.challenge.dto.PeliculaDto;
import com.alkemy.challenge.model.Personaje;
import com.alkemy.challenge.service.PersonajeService;
import com.alkemy.challenge.dto.PersonajeDto;
import com.alkemy.challenge.model.Pelicula;
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
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;
    
    @GetMapping("/characters")
    public List<PersonajeDto> listCharacters(){
        List<PersonajeDto> personajesDto = new ArrayList<>();
        List<Personaje> personajes = personajeService.listarPersonajes();
        personajes.forEach(personaje -> {
            personajesDto.add(new PersonajeDto(personaje.getNombre(),personaje.getImagen()));
        });
        return personajesDto;
    }
    
    @PostMapping("/characters")
    public Personaje saveCharacter(@RequestBody Personaje personaje){
        return personajeService.guardarPersonaje(personaje);
    }
    
    @GetMapping("/characters/{id}")
    public DetallePersonajeDto oneCharacter(@PathVariable Long id){
        Personaje personaje = personajeService.encontrarPersonajePorId(id);
        List<PeliculaDto> peliculasDto = new ArrayList();
        List<Pelicula> peliculas = personaje.getPeliculaAsociada();
        peliculas.forEach(pelicula->{
            peliculasDto.add(new PeliculaDto(pelicula.getTitulo(),pelicula.getImagen(),pelicula.getFechaCreacion()));
        });
        return new DetallePersonajeDto(personaje.getImagen(),personaje.getNombre(),personaje.getEdad(),personaje.getPeso(),personaje.getHistoria(),peliculasDto);
    }
    
    @PutMapping("/characters/{id}")
    public DetallePersonajeDto editCharacter(@RequestBody Personaje nuevoPersonaje, @PathVariable Long id){
        Personaje personaje = personajeService.guardarPersonaje(id,nuevoPersonaje);
        List<PeliculaDto> peliculasDto = new ArrayList();
        List<Pelicula> peliculas = personaje.getPeliculaAsociada();
        peliculas.forEach(pelicula->{
            peliculasDto.add(new PeliculaDto(pelicula.getTitulo(),pelicula.getImagen(),pelicula.getFechaCreacion()));
        });
        return new DetallePersonajeDto(personaje.getImagen(),personaje.getNombre(),personaje.getEdad(),personaje.getPeso(),personaje.getHistoria(),peliculasDto);
    }
    
    @DeleteMapping("/characters/{id}")
    public void deleteCharacter(@PathVariable Long id){
        personajeService.eliminarPersonajePorId(id);
    }
}
