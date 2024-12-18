package ejercicioUno.utils;

import ejercicioUno.domain.entities.Genero;
import ejercicioUno.domain.entities.PeliculaSerie;
import ejercicioUno.domain.entities.Personaje;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Log4j2
public class RandomDataGenerator {

    private static final Random RANDOM = new Random();

    // Generar una lista de nombres ficticios
    private static final List<String> NOMBRES = Arrays.asList("Ana", "Luis", "Carlos", "Sofía", "María", "Pedro", "Elena", "Miguel");
    private static final List<String> HISTORIAS = Arrays.asList(
            "Un guerrero valiente", "Una princesa aventurera", "Un inventor curioso", "Un explorador intrépido"
    );

    private static final List<String> TITULOS = Arrays.asList("La Aventura", "El Misterio", "El Viaje", "La Leyenda");

    public static List<Personaje> generarPersonajes(int cantidad) {
        List<Personaje> personajes = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            Personaje personaje = new Personaje();
            int index = RANDOM.nextInt(3);
            String nombre = NOMBRES.get(index);

            personaje.setNombre(nombre);
            personaje.setEdad(RANDOM.nextInt(90) + 10); // Edades entre 10 y 99
            personaje.setPeso(RANDOM.nextDouble() * 50 + 50); // Peso entre 50 y 100 kg
            personaje.setHistoria(HISTORIAS.get(RANDOM.nextInt(HISTORIAS.size())));
            personaje.setFilme(null); // Asociar después si es necesario
            personajes.add(personaje);
        }
        return personajes;
    }

    public static List<PeliculaSerie> generarPeliculasSeries(int cantidad) {
        List<PeliculaSerie> peliculas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            PeliculaSerie pelicula = new PeliculaSerie();
            pelicula.setTitulo(TITULOS.get(RANDOM.nextInt(TITULOS.size())));
            pelicula.setCalificacion(RANDOM.nextInt(5) + 1); // Calificación entre 1 y 5
            pelicula.setFechaCreacion(LocalDateTime.now().minusDays(RANDOM.nextInt(1000))); // Fecha aleatoria
            pelicula.setPersonajes(generarPersonajes(RANDOM.nextInt(5) + 1)); // De 1 a 5 personajes
            peliculas.add(pelicula);
        }
        return peliculas;
    }

    public static List<Genero> generarGeneros(int cantidad) {
        List<Genero> generos = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            Genero genero = new Genero();
            genero.setNombre("Género" + (i + 1));
            System.out.println("generos: " + genero);
            genero.setFilms(generarPeliculasSeries(RANDOM.nextInt(5) + 1)); // De 1 a 5 películas por género
            generos.add(genero);
        }
        return generos;
    }

    public static void main(String[] args) {
        List<Genero> generos = generarGeneros(3); // Generar 3 géneros aleatorios
        for (Genero genero : generos) {
            System.out.println("Nombre del género: " + genero.getNombre());
            for (PeliculaSerie pelicula : genero.getFilms()) {
                System.out.println("  Título: " + pelicula.getTitulo());
                System.out.println("  Calificación: " + pelicula.getCalificacion());
                System.out.println("  Fecha de creación: " + pelicula.getFechaCreacion());
                System.out.println("  Personajes:");
                for (Personaje personaje : pelicula.getPersonajes()) {
                    System.out.println("    Nombre: " + personaje.getNombre());
                    System.out.println("    Edad: " + personaje.getEdad());
                    System.out.println("    Peso: " + personaje.getPeso());
                    System.out.println("    Historia: " + personaje.getHistoria());
                }
            }
        }
    }
}