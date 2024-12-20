package ejercicioUno.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "GENEROS")
@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToMany(mappedBy = "generos", fetch = FetchType.EAGER)
    private List<PeliculaSerie> films;







    //GETTERS Y SETERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<PeliculaSerie> getFilms() {
        return films;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFilms(List<PeliculaSerie> films) {
        this.films = films;
    }
}
