import java.io.File;

public class ObtenerRutaFacil {
    public String rutaAbsoluta;
    public ObtenerRutaFacil(String ruta){
        String nombreArchivo = ruta;
        File archivo = new File(nombreArchivo);

        rutaAbsoluta = archivo.getAbsolutePath();
        
    }

    public String getRuta(){
        return rutaAbsoluta;
    }
}
