package ejercicioUno.domain.entities;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "PERSONAJES")
@Entity
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;

    @ManyToOne
    private PeliculaSerie filme;








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

    public Integer getEdad() {
        return edad;
    }

    public Double getPeso() {
        return peso;
    }

    public String getHistoria() {
        return historia;
    }

    public PeliculaSerie getFilme() {
        return filme;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public void setFilme(PeliculaSerie filme) {
        this.filme = filme;
    }
}

