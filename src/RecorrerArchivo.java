public class RecorrerArchivo {
    public leerArchivo archivo;
    public int contador;
    public RecorrerArchivo(String ruta){

        archivo = new leerArchivo(ruta);
        contador = archivo.cantidad();
        

    }

    public void imprimirResultados(){
        for(int i = 0; i<contador; i++){
            Traductor op = new Traductor(archivo.primerElemento());
        System.out.println(op.getPosfija());

        ArbolExpresion arbol = new ArbolExpresion(op.getPosfija());
        System.out.println(arbol.resolver()+"\n");
        }
    }
}
