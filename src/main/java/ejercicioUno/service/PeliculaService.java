package ejercicioUno.service;

import ejercicioUno.domain.entities.PeliculaSerie;

import java.util.List;

public interface PeliculaService {

    List<PeliculaSerie> findAll();
    List<PeliculaSerie> findByTitulo(String name);

    PeliculaSerie findById(Long id);

    PeliculaSerie crearActualizar(PeliculaSerie peliculaSerie);

    void deleteById(Long id);

    List<PeliculaSerie> findAllByPersonajeNombre(String nombre);
}
