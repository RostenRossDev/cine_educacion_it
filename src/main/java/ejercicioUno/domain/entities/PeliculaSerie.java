package ejercicioUno.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "PELICULA_SERIES")
@Entity
public class PeliculaSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Integer calificacion;

    @JsonIgnore
    @OneToMany(mappedBy = "filme", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Personaje> personajes;

    @Column(name = "CREATION_DATE")
    private LocalDateTime fechaCreacion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PELICULA_GENERO", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "pelicula_id"), // FK de esta clase
            inverseJoinColumns = @JoinColumn(name = "genero_id") // FK de la otra clase
    )
    private List<Genero> generos;













    //GETTERS Y SETERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
