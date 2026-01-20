package dominio;

import java.util.Objects;

public class Pelicula
{
    private String nombre;

    // Se coloca un constructo vacio porque la clase no lo va a crear automaticamente si ya existe uno con argumentos
    public Pelicula() { }
    public Pelicula(String nombre)
    {
        this.nombre = nombre;
    }

    // Getter y Setter
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    // Equals y Hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    // ToString
    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

//    public static void main(String[] args)
//    {
//        var pelicula1 = new Pelicula("Mamá, SOY PAQUITO");
//        var pelicula2 = new Pelicula("Mikudayooo");
//
//        System.out.println(pelicula1);
//        System.out.println(pelicula2);
//    }
}
