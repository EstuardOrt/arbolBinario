import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {
        Scanner lector = new Scanner(System.in);
        System.out.println("Por favor ingrese el nombre del archivo de texto tomando en cuenta que se deferencia entre mayusculas y minusculas:");
        String nombre = lector.nextLine()+".txt";
        ObtenerRutaFacil ruta = new ObtenerRutaFacil(nombre);
        
        RecorrerArchivo archivito = new RecorrerArchivo(ruta.getRuta());
        archivito.imprimirResultados();
    }
}
