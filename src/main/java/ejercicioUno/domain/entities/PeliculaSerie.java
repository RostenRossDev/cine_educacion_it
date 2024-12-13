package ejercicioUno.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class PeliculaSerie {

    private String titulo;
    private Integer calificacion;
    @JsonIgnore
    private List<Personaje> personajes;
    private LocalDateTime fechaCreacion;

    public String getTitulo() {
        return titulo;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
