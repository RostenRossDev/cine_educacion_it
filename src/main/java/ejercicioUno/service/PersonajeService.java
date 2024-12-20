package ejercicioUno.service;

import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;

import java.util.List;

public interface PersonajeService {

    List<Personaje> findAll();

    List<Personaje> findByName(String name);

    List<PeliculaSerie> findPeliculasByName(String name);

    List<Personaje> findByEdad(Integer edad);
}
