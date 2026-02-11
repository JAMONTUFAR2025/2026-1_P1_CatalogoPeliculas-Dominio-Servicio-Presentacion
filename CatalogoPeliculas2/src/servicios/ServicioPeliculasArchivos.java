package servicios;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivos implements IServicioPeliculas
{
    private final String NOMBRE_ARCHIVO = "Peliculas.txt";

    // Constructor
    public ServicioPeliculasArchivos()
    {
        var archivo = new File(NOMBRE_ARCHIVO);

        try
        {
            if(archivo.exists())
            {
                System.out.println("Ya existe el archivo.");
            }
            else
            {
                var salida = new PrintWriter(new FileWriter(archivo));
            }
        }
        catch (IOException e)
        {
            System.out.println("Error con el archivo, mensaje: " + (e.getMessage()));
        }
    }

    @Override
    public void listarPeliculas()
    {
        var archivo = new File(NOMBRE_ARCHIVO);

        try
        {
            if(archivo.exists())
            {
                System.out.println("===Listando las peliculas===");

                // Abrir el archivo para lectura
                var entrada = new BufferedReader(new FileReader(archivo));
                // Leemos linea a linea el archivo
                String linea;
                linea = entrada.readLine(); // Empieza por la linea 1, no hay linea 0

                // Ciclo para leer todox el documento
                while(linea != null)
                {
                    var pelicula = new Pelicula(linea);
                    System.out.println(pelicula);
                    // Volvemos a llamar y captura el valor de la siguiente linea
                    linea = entrada.readLine();
                }

                // Cerrar archivo siempre no lo olvides
                entrada.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Ocurrio un error: " + (e.getMessage()));
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula)
    {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);

        try
        {
            if(archivo.exists())
            {
                anexar = archivo.exists();
                // Aqui viene lo chido.... luisito
                var salida = new PrintWriter(new FileWriter(archivo, anexar));
                // Agregar la pelicula
                salida.println(pelicula);

                System.out.println("Se agrego la pelicula " + pelicula + " al archivo.");

                salida.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Ocurrio un error: " + (e.getMessage()));
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula)
    {
        var archivo = new File(NOMBRE_ARCHIVO);

        try
        {
            if(archivo.exists())
            {
                var entrada = new BufferedReader(new FileReader(archivo));
                String lineaTexto;
                lineaTexto = entrada.readLine();
                var indice = 1;
                boolean encontrada = false;
                var peliculaBuscar = pelicula.getNombre();

                // Recorrer el archivo
                while(lineaTexto != null)
                {
                    if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto))
                    {
                        encontrada = true;
                        break; // Romper el ciclo
                    }
                    // Leemos la siguiente linea de texto
                    lineaTexto = entrada.readLine();
                    indice++;
                } // while

                if(encontrada)
                    System.out.println("Pelicula " + peliculaBuscar + " encontrada en el indice [" + indice + "]");
                else
                    System.out.println("Pelicula " + peliculaBuscar + " no encontrada.");

                entrada.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al abrir el archivo: " + (e.getMessage()));
        }
    }

    @Override
    public void eliminarPelicula(Pelicula pelicula)
    {
        var original = new File(NOMBRE_ARCHIVO);
        var temporal = new File("temporal.txt");

        try
        {
            if (original.exists())
            {
                var entrada = new BufferedReader(new FileReader(original));
                var salida = new PrintWriter(new FileWriter(temporal));

                String lineaTexto;
                boolean encontrada = false;

                while((lineaTexto = entrada.readLine()) != null)
                {
                    // Escribimos las lineas que no queremos borrar en el archivo temporal
                    if (!lineaTexto.equalsIgnoreCase(pelicula.getNombre()))
                        salida.println(lineaTexto);
                    else
                        encontrada = true; // La linea a borrar no se escribe en el archivo temporal
                }

                entrada.close();
                salida.close();

                if(encontrada)
                {
                    // Borramos el original y renombramos el temporal
                    if(original.delete())
                    {
                        temporal.renameTo(original);
                        System.out.println("Pelicula " + pelicula + " eliminada.");
                    }
                }
                else
                {
                    // Borramos el archivo temporal y no hacemos nada al no encontrar la pelicula a borrar
                    temporal.delete();
                    System.out.println("Pelicula " + pelicula + " no encontrada.");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
