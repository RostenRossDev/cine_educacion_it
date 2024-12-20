package ejercicioUno.controllers;

import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;
import ejercicioUno.service.PersonajeService;
import ejercicioUno.utils.RandomDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/")
    public ResponseEntity<?> getPersonajes(){
        //return new ResponseEntity<>(personajes, HttpStatus.OK);
        return ResponseEntity.ok(personajeService.findAll());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> getPersonajesByNombre(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok(personajeService.findByName(nombre));
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> getPersonajesByEdad(@PathVariable("edad") Integer edad){
        return ResponseEntity.ok(personajeService.findByEdad(edad));
    }

}
