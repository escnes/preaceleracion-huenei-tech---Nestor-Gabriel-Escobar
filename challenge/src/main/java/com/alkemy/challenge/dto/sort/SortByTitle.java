package com.alkemy.challenge.dto.sort;

import com.alkemy.challenge.dto.PeliculaDto;
import java.util.Comparator;

//Clase utilizada para el orden ascendente y descendente de las peliculas según su titulo
public class SortByTitle implements Comparator<PeliculaDto> {

    @Override
    public int compare(PeliculaDto p1, PeliculaDto p2) {
        return p1.getTitulo().compareTo(p2.getTitulo());
    }

    @Override
    public Comparator<PeliculaDto> reversed() {
        return Comparator.super.reversed();
    }
}
