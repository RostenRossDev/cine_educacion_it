package ejercicioUno.domain.repository;

import ejercicioUno.domain.entities.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRespository extends JpaRepository<PeliculaSerie, Long> {

    public List<PeliculaSerie> findByTitulo(String titulo);
    public List<PeliculaSerie> findByCalificacionGreaterThan(Integer calificacion);
    public List<PeliculaSerie> findByCalificacionGreaterThanEqual(Integer calificacion);

    @Query("SELECT p FROM PeliculaSerie p JOIN p.personajes pj WHERE pj.nombre = :nombrePersonaje")
    List<PeliculaSerie> findAllByPersonajeNombre(@Param("nombrePersonaje") String nombrePersonaje);

}
