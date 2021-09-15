package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.DetallePersonajeDto;
import com.alkemy.challenge.dto.PeliculaDto;
import com.alkemy.challenge.model.Personaje;
import com.alkemy.challenge.service.PersonajeService;
import com.alkemy.challenge.dto.PersonajeDto;
import com.alkemy.challenge.model.Pelicula;
import com.alkemy.challenge.service.PeliculaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PersonajeController {
    
    @Autowired
    private PersonajeService personajeService;
    
    @Autowired
    private PeliculaService peliculaService;
    
    @GetMapping("/characters")
    public List<PersonajeDto> listCharacters(@RequestParam(name = "name") Optional<String> nombre, @RequestParam(name = "age") Optional<Integer> edad,@RequestParam(name = "idMovie") Optional<Long> idPelicula){
        List<PersonajeDto> personajesDto = new ArrayList<>();
        List<Personaje> personajes = personajeService.listarPersonajes();
        if(nombre.isPresent()){
            personajes.forEach(personaje -> {
            if(personaje.getNombre().equalsIgnoreCase(nombre.get()))
                personajesDto.add(new PersonajeDto(personaje.getNombre(),personaje.getImagen()));
            });
            return personajesDto;
        }else if(edad.isPresent()){
            personajes.forEach(personaje -> {
            if(personaje.getEdad()==edad.get())
                personajesDto.add(new PersonajeDto(personaje.getNombre(),personaje.getImagen()));
            });
            return personajesDto;
        }else if(idPelicula.isPresent()){
            personajes.forEach(personaje -> {
            personaje.getPeliculasAsociadas().forEach((peliculaAsociada) -> {
                if(peliculaAsociada.getIdPelicula().compareTo(idPelicula.get()) == 0)
                    personajesDto.add(new PersonajeDto(personaje.getNombre(),personaje.getImagen()));
                });
            });
            return personajesDto;
        }
        personajes.forEach(personaje -> {
            personajesDto.add(new PersonajeDto(personaje.getNombre(),personaje.getImagen()));
        });
        return personajesDto;
    }
    
    @PostMapping("/characters")
    public DetallePersonajeDto saveCharacter(@RequestBody Personaje nuevoPersonaje){
        personajeService.guardarPersonaje(nuevoPersonaje);
        List<PeliculaDto> peliculasDto = new ArrayList();
        List<Pelicula> peliculas = nuevoPersonaje.getPeliculasAsociadas();
        peliculas.forEach((pelicula) -> {
            Pelicula nuevaPelicula = peliculaService.encontrarPeliculaPorId(pelicula.getIdPelicula());
            peliculasDto.add(new PeliculaDto(nuevaPelicula.getTitulo(), nuevaPelicula.getImagen(), nuevaPelicula.getFechaCreacion()));
        });
        return new DetallePersonajeDto(nuevoPersonaje.getImagen(), nuevoPersonaje.getNombre(), nuevoPersonaje.getEdad(), nuevoPersonaje.getPeso(), nuevoPersonaje.getHistoria(), peliculasDto);
    }
    
    @GetMapping("/characters/{id}")
    public DetallePersonajeDto oneCharacter(@PathVariable Long id){
        Personaje personaje = personajeService.encontrarPersonajePorId(id);
        List<PeliculaDto> peliculasDto = new ArrayList();
        List<Pelicula> peliculas = personaje.getPeliculasAsociadas();
        peliculas.forEach(pelicula->{
            peliculasDto.add(new PeliculaDto(pelicula.getTitulo(),pelicula.getImagen(),pelicula.getFechaCreacion()));
        });
        return new DetallePersonajeDto(personaje.getImagen(),personaje.getNombre(),personaje.getEdad(),personaje.getPeso(),personaje.getHistoria(),peliculasDto);
    }
    
    @PutMapping("/characters/{id}")
    public DetallePersonajeDto editCharacter(@RequestBody Personaje nuevoPersonaje, @PathVariable Long id){
        Personaje personaje = personajeService.guardarPersonaje(id,nuevoPersonaje);
        List<PeliculaDto> peliculasDto = new ArrayList();
        List<Pelicula> peliculas = personaje.getPeliculasAsociadas();
        peliculas.forEach((pelicula)->{
            peliculasDto.add(new PeliculaDto(pelicula.getTitulo(),pelicula.getImagen(),pelicula.getFechaCreacion()));
        });
        return new DetallePersonajeDto(personaje.getImagen(),personaje.getNombre(),personaje.getEdad(),personaje.getPeso(),personaje.getHistoria(),peliculasDto);
    }
    
    @DeleteMapping("/characters/{id}")
    public void deleteCharacter(@PathVariable Long id){
        personajeService.eliminarPersonajePorId(id);
    }
}
