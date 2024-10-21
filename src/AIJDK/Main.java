package AIJDK;

//Librerias
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Clase principal para probar el archivo invertido
public class Main {
    public static void main(String[] args) {
        // Crear algunos documentos
        Documento doc1 = new Documento(1, "El gato negro corre rapido");
        Documento doc2 = new Documento(2, "El perro duerme todo el dia");
        Documento doc3 = new Documento(3, "El gato y el perro son amigos");
        Documento doc4 = new Documento(4, "El día es soleado y cálido");

        // Crear archivo invertido
        ArchivoInvertido archivoInvertido = new ArchivoInvertido();

        // Indexar los documentos
        archivoInvertido.indexarDocumento(doc1);
        archivoInvertido.indexarDocumento(doc2);
        archivoInvertido.indexarDocumento(doc3);
        archivoInvertido.indexarDocumento(doc4);

        // Mostrar el archivo invertido
        System.out.println("Archivo Invertido:");
        archivoInvertido.mostrarIndice();

        // Búsqueda de ejemplo
        String palabraABuscar = "gato";
        List<Integer> resultados = archivoInvertido.buscar(palabraABuscar);
        System.out.println("\nDocumentos que contienen la palabra '" + palabraABuscar + "': " + resultados);
    }
}