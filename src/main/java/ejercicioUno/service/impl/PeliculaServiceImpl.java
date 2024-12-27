package ejercicioUno.service.impl;

import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;
import ejercicioUno.domain.repository.PeliculaRespository;
import ejercicioUno.dto.ApiResponse;
import ejercicioUno.exception.DivisionInvalidaException;
import ejercicioUno.service.PeliculaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private static final Logger log = LoggerFactory.getLogger(PeliculaServiceImpl.class);
    @Autowired
    private PeliculaRespository peliculaRespository;

    @Autowired
    private WebClient webClient;

    @Transactional(readOnly = true)
    public ResponseEntity<Map<String, Object>> findAll(){ //detorna todas las peliculas
        Map<String, Object> respuesta = new HashMap<>();
        List<PeliculaSerie> pelis =  peliculaRespository.findAll();
        respuesta.put("peliculas", pelis);
        return ResponseEntity.ok(respuesta);
    }

    @Override
    public ResponseEntity<Map<String, Object>> findByTitulo(String name) {
        List<PeliculaSerie> pelis = peliculaRespository.findByTitulo(name);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("peliculas", pelis);
        return ResponseEntity.ok(respuesta);
    }

    @Transactional(readOnly = true)
    public  ResponseEntity<Map<String, Object>> findById(Long id){ // retorna una pelicula segun su id
        PeliculaSerie peli = peliculaRespository.findById(id).orElse(new PeliculaSerie());
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("pelicula", peli);
        return ResponseEntity.ok(respuesta);
    }

    @Transactional
    public ResponseEntity<Map<String, Object>> crearActualizar(PeliculaSerie peliculaSerie){ // crea/actualiza 1 pelicula
        PeliculaSerie peli = peliculaRespository.save(peliculaSerie);
        Map<String, Object> respuesta = new HashMap<>();
        if(peli.getId() == null){
            //return ResponseEntity.ok(peli);
            respuesta.put("mensaje", "Ocurrio un error en la persistencia, pruebe mas tarde.");
            return new ResponseEntity(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "Se guardo la pelicula con exito.");
        respuesta.put("pelicula", peli);
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @Transactional
    public void deleteById(Long id){//elimina 1 pelicula por su id
        peliculaRespository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public  ResponseEntity<Map<String, Object>> findAllByPersonajeNombre(String nombre){//retorna una lista de peliculas que posea un personaje dado
        List<PeliculaSerie> pelis = peliculaRespository.findAllByPersonajeNombre(nombre);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("peliculas", pelis);
        return ResponseEntity.ok(respuesta);
    }

    @Transactional(readOnly = true)
    public  ResponseEntity<Map<String, Object>> starWar(){//retorna una lista de peliculas que posea un personaje dado

        ApiResponse response = webClient.get().uri("people/1").retrieve().bodyToMono(ApiResponse.class).block();

        Map<String, Object> respuesta = new HashMap<>();

        respuesta.put("response", response);
        return ResponseEntity.ok(respuesta);
    }
}