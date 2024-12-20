package ejercicioUno.service.impl;

import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;
import ejercicioUno.domain.repository.PeliculaRespository;
import ejercicioUno.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRespository peliculaRespository;

    @Transactional(readOnly = true)
    public List<PeliculaSerie> findAll(){ //detorna todas las peliculas
        return peliculaRespository.findAll();
    }

    @Override
    public List<PeliculaSerie> findByTitulo(String name) {
        return peliculaRespository.findByTitulo(name);
    }

    @Transactional(readOnly = true)
    public PeliculaSerie findById(Long id){ // retorna una pelicula segun su id
        return peliculaRespository.findById(id).orElse(new PeliculaSerie());
    }

    @Transactional
    public PeliculaSerie crearActualizar(PeliculaSerie peliculaSerie){ // crea/actualiza 1 pelicula
        return peliculaRespository.save(peliculaSerie);
    }

    @Transactional
    public void deleteById(Long id){//elimina 1 pelicula por su id
        peliculaRespository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public List<PeliculaSerie> findAllByPersonajeNombre(String nombre){//retorna una lista de peliculas que posea un personaje dado
        return peliculaRespository.findAllByPersonajeNombre(nombre);
    }
}