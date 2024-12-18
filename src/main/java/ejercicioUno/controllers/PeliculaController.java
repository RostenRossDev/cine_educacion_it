package ejercicioUno.controllers;

import ejercicioUno.predicates.Predicates;
import ejercicioUno.service.impl.PeliculaServiceImpl;
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
    private PeliculaServiceImpl peliculaService;

    @GetMapping("/")
    public ResponseEntity<?> getAlll(){

        return ResponseEntity.ok(RandomDataGenerator.generarPeliculasSeries(1000));
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> getByTitulo(@PathVariable("titulo") String titulo){
        Predicate<String> tituloIsEqualToRequesttitulo = Predicates.StringEqualAnotherString(titulo);

        return ResponseEntity.ok(RandomDataGenerator.generarPeliculasSeries(1000)
                .stream()
                .filter(item -> tituloIsEqualToRequesttitulo.test(item.getTitulo()))
                .collect(Collectors.toList()));

    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<?> getByGenero(@PathVariable("genero") String genero){
        Predicate<String> generoIsEqualToRequestGenero = Predicates.StringEqualAnotherString(genero);

        return ResponseEntity.ok(RandomDataGenerator.generarGeneros(1000)
                .stream()
                .filter(item -> generoIsEqualToRequestGenero.test(item.getNombre()))
                .collect(Collectors.toList()));
    }
}
