package ejercicioUno.service;

import ejercicioUno.domain.entities.PeliculaSerie;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PeliculaService {

    ResponseEntity<Map<String, Object>> findAll();
    ResponseEntity<Map<String, Object>> findByTitulo(String name);

    ResponseEntity<Map<String, Object>> findById(Long id);

    ResponseEntity<Map<String, Object>> crearActualizar(PeliculaSerie peliculaSerie);

    void deleteById(Long id);

    ResponseEntity<Map<String, Object>>  findAllByPersonajeNombre(String nombre);

    ResponseEntity<Map<String, Object>> starWar();
}
