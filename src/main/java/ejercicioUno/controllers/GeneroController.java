package ejercicioUno.controllers;

import ejercicioUno.predicates.Predicates;
import ejercicioUno.service.GeneroService;
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
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping("/")
    public ResponseEntity<?> getAlll(){
        return ResponseEntity.ok(generoService.findAll());
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<?> getByGenero(@PathVariable("genero") String genero){

        return ResponseEntity.ok(generoService.findByName(genero));

    }

}
