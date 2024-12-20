package ejercicioUno.domain.repository;

import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRespository extends JpaRepository<Personaje, Long> {

    public List<Personaje> findByNombre(String nombre);

    public List<Personaje> findByEdad(Integer edad);
}
