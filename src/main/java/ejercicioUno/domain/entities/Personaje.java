package ejercicioUno.domain.entities;

import lombok.*;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Personaje {
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    private PeliculaSerie filme;

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

