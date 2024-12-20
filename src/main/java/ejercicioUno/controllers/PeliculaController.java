package ejercicioUno.controllers;

import ejercicioUno.predicates.Predicates;
import ejercicioUno.service.PeliculaService;
import ejercicioUno.utils.RandomDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
