package ejercicioUno.service.impl;

import ejercicioUno.domain.entities.Genero;
import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;
import ejercicioUno.domain.repository.GeneroRepository;
import ejercicioUno.service.GeneroService;
import ejercicioUno.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Genero> findAll() { //retorna la lista de generos
        return generoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<PeliculaSerie> findByName(String name) { //retorna uan lista de peliculas que posea un genero
        return generoRepository.findByNombre(name).getFilms();
    }
}
