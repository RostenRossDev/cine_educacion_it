package ejercicioUno.service;

import ejercicioUno.domain.entities.Genero;
import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;

import java.util.List;

public interface GeneroService {

    List<Genero> findAll();

    List<PeliculaSerie> findByName(String name);
}
