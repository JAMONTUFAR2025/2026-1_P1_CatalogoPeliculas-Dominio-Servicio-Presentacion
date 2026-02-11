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
        System.out.println("Pelicula " + pelicula + " agregada...");
    }

    @Override
    public void buscarPelicula(Pelicula pelicula)
    {
        var indice = peliculas.indexOf(pelicula);

        if(indice != -1)
        {
            System.out.println("Pelicula " + pelicula + " encontrada en el indice [" + indice + "]");
        }
        else
        {
            System.out.println("Pelicula no encontrada...");
        }
    }

    @Override
    public void eliminarPelicula(Pelicula pelicula)
    {

    }

//    public static void main(String[] args)
//    {
//        // Objetos
//        var pelicula1 = new Pelicula("Ted");
//        var pelicula2 = new Pelicula("Xmen");
//        var pelicula3 = new Pelicula("Avengers");
//        var pelicula4 = new Pelicula("Spiderman 3");
//        var pelicula5 = new Pelicula("Heroes Pokemon: Latios & Latias");
//
//
//        // Creamos el servicio
//        IServicioPeliculas servicioPeliculas = new Servicio();
//        // Agregamos
//        servicioPeliculas.agregarPelicula(pelicula1);
//        servicioPeliculas.agregarPelicula(pelicula2);
//        servicioPeliculas.agregarPelicula(pelicula3);
//        servicioPeliculas.agregarPelicula(pelicula4);
//        servicioPeliculas.agregarPelicula(pelicula5);
//        // Listamos
//        servicioPeliculas.listarPeliculas();
//        // Buscar
//        servicioPeliculas.buscarPelicula(new Pelicula("Xmen"));
//    }
}
