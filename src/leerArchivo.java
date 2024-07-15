import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileNotFoundException;

public class leerArchivo {
    public static Queue<String> Operaciones = new LinkedList<>();
    public static String rutaArchivo;
    public static int contador;
    public leerArchivo(String ruta) {
        
        leerArchivo.rutaArchivo = ruta;
        leerArchivo.contador = 0;

        try {
            // Crear objeto File con la ruta del archivo
            File archivo = new File(rutaArchivo);

            // Crear objeto Scanner para leer el archivo
            Scanner scanner = new Scanner(archivo);

            // Leer el contenido línea por línea
            while (scanner.hasNextLine()) {
                
                Operaciones.offer(scanner.nextLine());
                contador++;
            }

            // Cerrar el scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + rutaArchivo);
        }
    }

    public String primerElemento(){
        String elemento = Operaciones.poll();
        return elemento;
    }

    public int cantidad(){
        return contador;
    }


    public void imprimir(){

        for(int i = 0; i < contador ; i++){
            String elemento = Operaciones.poll();
            System.out.println(elemento);
            Operaciones.offer(elemento);
        }
    }


}
