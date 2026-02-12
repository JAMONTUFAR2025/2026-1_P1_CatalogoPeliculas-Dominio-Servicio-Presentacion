package auditoria;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auditoria
{
    private static final String NOMBRE_ARCHIVO_LOG = "auditoria.txt";

    public static void registrarAccion(String accion)
    {
        var archivo = new File(NOMBRE_ARCHIVO_LOG);

        // Formato de fecha: yyyy/MM/dd HH:mm
        var formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String fechaHora = LocalDateTime.now().format(formato);

        try
        {
            var salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println("[" + fechaHora + "] ACCION: " + accion);
            salida.close();
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en la auditoría: " + e.getMessage());
        }
    }
}
