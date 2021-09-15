package com.alkemy.challenge.controller;

import com.alkemy.challenge.dto.DetallePeliculaDto;
import com.alkemy.challenge.dto.GeneroDto;
import com.alkemy.challenge.dto.PeliculaDto;
import com.alkemy.challenge.dto.PersonajeDto;
import com.alkemy.challenge.dto.sort.SortByTitle;
import com.alkemy.challenge.model.Genero;
import com.alkemy.challenge.model.Pelicula;
import com.alkemy.challenge.model.Personaje;
import com.alkemy.challenge.service.GeneroService;
import com.alkemy.challenge.service.PeliculaService;
import com.alkemy.challenge.service.PersonajeService;
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

@RestController//Para usar el patron rest.
@CrossOrigin("*")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    
    @Autowired
    private PersonajeService personajeService;
    
    @Autowired
    private GeneroService generoService;
    
    @GetMapping("/movies")//Me devuelve un listado de peliculasDto, con query params title,idGenre y order para que se liste en orden ascendente o descendente según el titulo.
    public List<PeliculaDto> listMovie(@RequestParam(name = "title") Optional<String> titulo,@RequestParam(name = "idGenre") Optional<Long> idGenero,@RequestParam(name = "order") Optional<String> orden){
        List<PeliculaDto> peliculasDto = new ArrayList<>();
        List<Pelicula> peliculas = peliculaService.listarPeliculas();
        if(titulo.isPresent()){
            peliculas.forEach((pelicula) -> {
                if(pelicula.getTitulo().equalsIgnoreCase(titulo.get())){
                    peliculasDto.add(new PeliculaDto(pelicula.getTitulo(), pelicula.getImagen(), pelicula.getFechaCreacion()));
                }
            });
            return peliculasDto;
        }else if(idGenero.isPresent()){
            peliculas.forEach((pelicula) -> {
                pelicula.getGenerosAsociados().forEach((genero) -> {
                    if(genero.getIdGenero().compareTo(idGenero.get())==0){
                        peliculasDto.add(new PeliculaDto(pelicula.getTitulo(), pelicula.getImagen(), pelicula.getFechaCreacion()));
                    }
                });
            });
            return peliculasDto;
        }
        peliculas.forEach(pelicula -> {
            peliculasDto.add(new PeliculaDto(pelicula.getTitulo(),pelicula.getImagen(),pelicula.getFechaCreacion()));
        });
        if(orden.isPresent()){
            if(orden.get().equalsIgnoreCase("ASC"))
                peliculasDto.sort(new SortByTitle());
            if(orden.get().equalsIgnoreCase("DESC"))
                peliculasDto.sort(new SortByTitle().reversed());
        }
        return peliculasDto;
    }
    
    @PostMapping("/movies")//Para guardar una pelicula
    public DetallePeliculaDto saveMovie(@RequestBody Pelicula nuevaPelicula){
        peliculaService.guardarPelicula(nuevaPelicula);
        List<GeneroDto> generosDto = new ArrayList();
        List<Genero> generos = nuevaPelicula.getGenerosAsociados();
        generos.forEach((genero) -> {
            Genero nuevoGenero = generoService.encontrarGeneroPorId(genero.getIdGenero());
            generosDto.add(new GeneroDto(nuevoGenero.getNombre(), nuevoGenero.getImagen()));
        });
        List<PersonajeDto> personajesDto = new ArrayList();
        List<Personaje> personajes = nuevaPelicula.getPersonajesAsociados();
        personajes.forEach((personaje) -> {
            Personaje nuevoPersonaje = personajeService.encontrarPersonajePorId(personaje.getIdPersonaje());
            personajesDto.add(new PersonajeDto(nuevoPersonaje.getNombre(), nuevoPersonaje.getImagen()));
        });
        return new DetallePeliculaDto(nuevaPelicula.getImagen(), nuevaPelicula.getTitulo(), nuevaPelicula.getFechaCreacion(), nuevaPelicula.getCalificacion(),generosDto, personajesDto);
    }
    
    @GetMapping("/movies/{id}")//Me devuelve una sola película con mas detalle 
    public DetallePeliculaDto oneMovie(@PathVariable Long id){
        Pelicula pelicula = peliculaService.encontrarPeliculaPorId(id);
        List<GeneroDto> generosDto = new ArrayList();
        List<Genero> generos = pelicula.getGenerosAsociados();
        generos.forEach((genero) -> {
            Genero nuevoGenero = generoService.encontrarGeneroPorId(genero.getIdGenero());
            generosDto.add(new GeneroDto(nuevoGenero.getNombre(), nuevoGenero.getImagen()));
        });
        List<PersonajeDto> personajesDto = new ArrayList();
        List<Personaje> personajes = pelicula.getPersonajesAsociados();
        personajes.forEach(personaje -> {
            
            personajesDto.add(new PersonajeDto(personaje.getNombre(),personaje.getImagen()));
        });
        return new DetallePeliculaDto(pelicula.getImagen(),pelicula.getTitulo(),pelicula.getFechaCreacion(),pelicula.getCalificacion(),generosDto,personajesDto);
    }
    
    @PutMapping("/movies/{id}")//Sirve para editar una pelicula desde su nombre hasta los generos al cual pertenece
    public DetallePeliculaDto editMovie(@RequestBody Pelicula nuevaPelicula, @PathVariable Long id){
       Pelicula pelicula = peliculaService.guardarPelicula(id, nuevaPelicula);
       List<GeneroDto> generosDto = new ArrayList();
       List<Genero> generos = pelicula.getGenerosAsociados();
       generos.forEach((genero) -> {
            generosDto.add(new GeneroDto(genero.getNombre(), genero.getImagen()));
        });
       List<PersonajeDto> personajesDto = new ArrayList();
       List<Personaje> personajes = pelicula.getPersonajesAsociados();
       personajes.forEach((personaje) -> {
           personajesDto.add(new PersonajeDto(personaje.getNombre(), personaje.getImagen()));
       });
       return new DetallePeliculaDto(pelicula.getImagen(), pelicula.getTitulo(), pelicula.getFechaCreacion(), pelicula.getCalificacion(), generosDto, personajesDto);
    }
    
    @DeleteMapping("/movies/{id}")//Elimina una pelicula que tenga el id que se pasa por parametro
    public void deleteMovie(@PathVariable Long id){
        peliculaService.eliminarPeliculaPorId(id);
    }
}
