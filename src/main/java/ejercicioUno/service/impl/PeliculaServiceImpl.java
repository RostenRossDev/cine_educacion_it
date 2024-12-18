package ejercicioUno.service.impl;

import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.repository.PeliculaRespository;
import ejercicioUno.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRespository peliculaRespository;

    public List<PeliculaSerie> findByAll(){
        return peliculaRespository.findAll();
    }

    public PeliculaSerie findById(Long id){
        return peliculaRespository.findById(id).orElse(new PeliculaSerie());
    }

    public PeliculaSerie crearActualizar(PeliculaSerie peliculaSerie){
        return peliculaRespository.save(peliculaSerie);
    }

    public void deleteById(Long id){
        peliculaRespository.deleteById(id);
    }
}