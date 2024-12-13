package ejercicioUno.domain.entities;

import lombok.*;

import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Genero {
    private String nombre;
    private List<PeliculaSerie> films;

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
