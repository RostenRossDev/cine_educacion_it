package ejercicioUno.service.impl;

import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;
import ejercicioUno.domain.repository.PersonajeRespository;
import ejercicioUno.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRespository personajeRespository;

    @Transactional(readOnly = true)
    @Override
    public List<Personaje> findAll() {
        return personajeRespository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Personaje> findByName(String name) {
        return personajeRespository.findByNombre(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PeliculaSerie> findPeliculasByName(String name) {
        return  personajeRespository.findByNombre(name)
                .stream()
                .map(Personaje::getFilme)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Personaje> findByEdad(Integer edad) {
        return personajeRespository.findByEdad(edad);
    }
}
