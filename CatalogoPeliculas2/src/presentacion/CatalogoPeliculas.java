package presentacion;

import dominio.Pelicula;
import servicios.IServicioPeliculas;
import servicios.Servicio;
import servicios.ServicioPeliculasArchivos;

import java.util.Scanner;

public class CatalogoPeliculas
{
    public static void main(String[] args)
    {
        // Declarar variables
        var salir = false;
        var consola = new Scanner(System.in);

        // Agregamos la implementacion de los servicios
        //IServicioPeliculas servicioPeliculas = new Servicio();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivos();

        while(!salir)
        {
            try
            {
                mostrarMenu();
                salir = ejecutarServicio(consola, servicioPeliculas);
                System.out.println("...");
            }
            catch(Exception e)
            {
                System.out.println("Ocurrio un error: " + (e.getMessage()));
            }
        }
    } // Fin main

    private static void mostrarMenu()
    {
        System.out.print("""
                *** Catalogo de Peliculas ***
                1. Agregar peliculas
                2. Listar peliculas
                3. Buscar peliculas
                4. Salir
                """);
    } // Mostrar menu

    private static boolean ejecutarServicio(Scanner consola, IServicioPeliculas servicioPeliculas)
    {
        System.out.print("Opcion: ");
        var opciones = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch(opciones)
        {
            case 1->
            {
                System.out.print("Escribe el nombre de la pelicula a agregar: ");
                var nombrePelicula = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            } // 1
            case 2->
            {
                servicioPeliculas.listarPeliculas();
            } // 2
            case 3->
            {
                System.out.print("Escribe el nombre de la pelicula a buscar: ");
                var buscarPelicula = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscarPelicula));
            } // 3
            case 4->
            {
                System.out.println("Has salido del programa");
                salir = true;
            } // 4
            default->
            {
                System.out.println("Opcion no valida...");
            } // default
        } // Opciones

        return salir;
    } // Ejecutar servicio
} // Fin clase

