package servicios;

import dominio.Pelicula;

import java.util.ArrayList;

public class Servicio implements IServicioPeliculas
{
    ArrayList<Pelicula> peliculas = new ArrayList<>();

    @Override
    public void listarPeliculas()
    {
        System.out.println("Listado de peliculas...");
        peliculas.forEach(System.out::println); // Imprimir cada uno de los elementos de la lista en consola
    }

    @Override
    public void agregarPelicula(Pelicula pelicula)
    {
        peliculas.add(pelicula);
        System.out.println("Agregando pelicula...");
    }

    @Override
    public void buscarPelicula(Pelicula pelicula)
    {
        var indice = peliculas.indexOf(pelicula);

        if(indice != -1)
        {
            System.out.println("Pelicula encontrada en el indice [" + indice + "]");
        }
        else
        {
            System.out.println("Pelicula no encontrada...");
        }
    }

    public static void main(String[] args)
    {
        // Objetos
        var pelicula1 = new Pelicula("Ted");
        var pelicula2 = new Pelicula("Xmen");

        // Creamos el servicio
        IServicioPeliculas servicioPeliculas = new Servicio();
        // Agregamos
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        // Listamos
        servicioPeliculas.listarPeliculas();
        // Buscar
        servicioPeliculas.buscarPelicula(new Pelicula("Batman"));
    }
}
