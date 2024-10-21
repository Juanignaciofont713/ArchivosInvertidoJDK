package AIJDK;

//Librerias
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Clase que representa el Archivo Invertido
class ArchivoInvertido {
    // Mapa que asocia una palabra con un conjunto de IDs de documentos
    private Map<String, Set<Integer>> indice;

    public ArchivoInvertido() {
        indice = new HashMap<>();
    }

    // Método para preprocesar el texto (convertir a minúsculas y eliminar puntuación)
    private String preprocesarTexto(String texto) {
        // Eliminamos puntuación y convertimos a minúsculas
        return texto.replaceAll("\\p{Punct}", "").toLowerCase();
    }

    // Método para indexar un documento en el archivo invertido
    public void indexarDocumento(Documento doc) {
        String textoPreprocesado = preprocesarTexto(doc.getTexto());
        String[] palabras = textoPreprocesado.split("\\s+");

        for (String palabra : palabras) {
            // Si la palabra no está en el índice, se añade con un nuevo conjunto de documentos
            indice.computeIfAbsent(palabra, k -> new HashSet<>()).add(doc.getId());
        }
    }

    // Método para buscar documentos que contienen una palabra
    public List<Integer> buscar(String palabra) {
        palabra = preprocesarTexto(palabra);
        if (indice.containsKey(palabra)) {
            return new ArrayList<>(indice.get(palabra));
        } else {
            return new ArrayList<>(); // Devuelve una lista vacía si la palabra no está
        }
    }

    // Método para mostrar el archivo invertido
    public void mostrarIndice() {
        for (Map.Entry<String, Set<Integer>> entrada : indice.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
