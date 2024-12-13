package ejercicioUno.controllers;

import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;
import ejercicioUno.utils.RandomDataGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @GetMapping("/")
    public ResponseEntity<?> getPersonajes(){
        //return new ResponseEntity<>(personajes, HttpStatus.OK);
        return ResponseEntity.ok(RandomDataGenerator.generarPersonajes(20));
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> getPersonajesByNombre(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok(RandomDataGenerator.generarPersonajes(20)
                .stream()
                .filter(item -> item.getNombre().equals(nombre))
                .collect(Collectors.toList()));
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> getPersonajesByEdad(@PathVariable("edad") Integer edad){
        return ResponseEntity.ok(RandomDataGenerator.generarPersonajes(200)
                .stream()
                .filter(item -> item.getEdad().intValue() == edad.intValue())
                .collect(Collectors.toList()));
    }
}
