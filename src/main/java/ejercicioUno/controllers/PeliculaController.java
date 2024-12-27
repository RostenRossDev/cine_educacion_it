package ejercicioUno.controllers;

import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.predicates.Predicates;
import ejercicioUno.service.PeliculaService;
import ejercicioUno.utils.RandomDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;


    @GetMapping("/")
    public ResponseEntity<?> getAlll(){

        return ResponseEntity.ok(peliculaService.findAll());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> getByTitulo(@PathVariable("titulo") String titulo){

        return ResponseEntity.ok(peliculaService.findByTitulo(titulo));

    }

    @GetMapping("/personaje/{name}")
    public ResponseEntity<?> allByPersonajeNombre(@PathVariable("name") String name){
        return ResponseEntity.ok(peliculaService.findAllByPersonajeNombre(name));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody PeliculaSerie peli){
        return ResponseEntity.ok(peliculaService.crearActualizar(peli));
    }

    @GetMapping("/starWar")
    public ResponseEntity<?> getStarWar(){
        return peliculaService.starWar();
    }
}
