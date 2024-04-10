import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Programa PALABRAS
 * Para ejecutar desde consola
 * Lee un fichero de texto y modifica el texto según 4 opciones:
 * -m pasa el texto a minúsculas
 * -M pasa el texto a mayúsculas
 * -c cuenta palabras
 * -l muestra palabras de longitud dada
 * 
 * 
 * @author: Lucía González Rosas
 * 
 */

public class Palabras {
  static final String ROJO = "\u001B[31m"; // Formatea texto a rojo
  static final String RESET = "\033[0m";   // Restablece formato texto

  public static void main (String[] args) {

    String opcion = "";          // minusculas/mayusculas/contar/longitud
    String fichero = "";         // El fichero a leer
    String palabraBuscada = "";  // Para la opción contar
    int longitudPalabra = 0;     // Para la opción palabrasDeLongitud

    // Parte 1
    // Lee parámetros de línea de comandos (Sin orden)
    // Establece nombre del fichero y la opción
    for(int i = 0; i < args.length; i++) {

      switch (args[i]) {
        case "-f":
          fichero = args[i + 1];
          break;

        case "-m":
          opcion = "minusculas";
          break;

        case "-M":
          opcion = "mayusculas";
          break;

        case "-c":
          opcion = "contar";
          palabraBuscada = args[i + 1];
          break;

        case "-l":
          opcion = "longitud";

          try {
            longitudPalabra = Integer.parseInt(args[i + 1]);

          } catch (Exception e) {
            System.out.println("Parámetro longitud no válido");
            System.exit(0);

          }
        }
    }

    // Parte 2
    // Comprueba si hay fichero, entonces lee su contenido, lo introduce en una variable String[] texto y lo imprime.
    // De lo contrario, imdica el error y finaliza el programa
    if (fichero.equals("")) { 
      System.out.println("Falta el fichero de origen.");
      System.exit(0);

    }

    String[] texto = leerFichero(fichero);
    System.out.println("\nEl texto original es:");
    imprimir(texto);

    // Parte 3
    // Llamada a la función de cada opción, opcion puede ser "minusculas", "mayusculas", "contar" o "longitud"
    switch (opcion) {
      case "minusculas":
        texto = pasarMinusculas(texto);
        System.out.println("---------------------\nEl texto pasado a minúsculas:");
        imprimir(texto);
        break;

      case "mayusculas":
        texto = pasarMayusculas(texto);
        System.out.println("---------------------\nEl texto pasado a mayúsculas:");
        imprimir(texto);
        break;

      case "contar":
        texto = contarPalabras(texto, palabraBuscada);
        System.out.println("---------------------\nLa palabra buscada:");
        imprimir(texto);
        break;

      case "longitud":
        String[] texto2 = longitud(texto, longitudPalabra);
        System.out.println("Las palabras que tienen de longitud " + longitudPalabra + " son:");
        imprimir(texto2);
        break;

      default:
        System.out.println("Esta función no está especificada");
    }

  }  

  // Cuenta e indica el número de veces que se encuentra la palabra dada en el texto
   private static String[] contarPalabras(String[] texto, String palabraBuscada) {

    int cuenta = 0;

    for (int i = 0; i < texto.length; i++) {
      if (texto[i].equalsIgnoreCase(palabraBuscada)) { 
        texto[i] = ROJO + texto[i] + RESET;

        cuenta++;
        
      }
    }
    System.out.println("---------------------\n Las veces que aparece la palabra " + palabraBuscada + " son: " + cuenta + "\n");

    return texto;

  }

  // Dado un array de Strings, lo imprime, añadiendo espacios entre las palabras
  private static void imprimir(String[] texto) {

    for(String palabra : texto){
      System.out.print(palabra + (palabra.equals("\n")?"":" "));
    }
    System.out.println();
  }

  // Dado un array de Strings, lo devuelve modificado, pasando a minúsculas todos sus elementos
  private static String[] pasarMinusculas(String[] texto) {
    for (int i=0; i<texto.length; i++) {
      texto[i] = texto[i].toLowerCase();

    }
    return texto;

  }

    // Dado un array de Strings, lo devuelve modificado, pasando a mayúsculas todos sus elementos
  private static String[] pasarMayusculas(String[] texto) {

    for (int i = 0; i < texto.length; i++) {
      texto[i] = texto[i].toUpperCase();

    }

    return texto;
  
  }

  // 1. Cuenta las palabras que tienen la longitud proporcionada
  // 2. Crea un nuevo array con la longitud igual al número de palabras contadas
  // 3. Rellena el array con todas las palabras que cumplen la condición
  // 4. Devuelve el array con las palabras que cumplen la condición
  private static String[] longitud(String[] texto, int longitud) {

    int contador = 0;
    // Primero contamos las palabras de esa longitud
    for (String p: texto){
      if (p.length()==longitud) contador ++;

    }

    String[] textoDevolver = new String[contador]; // Se crea un nuevo array con el tamaño adecuado
    contador = 0;  // Reiniciamos el contador
    // Volvemos a recorrer el array original para pasar las palabras al nuevo array
    for (int i = 0; i < texto.length; i++) {
      if (texto[i].length()==longitud){
        textoDevolver[contador]=texto[i];

        contador++;

      } 
    }

    return textoDevolver;
  
  }

  // Devuelve un array de Strings, donde cada elemento es una palabra del fichero leído.
  // La longitud del array devuelto es igual al número de palabras en el fichero.
  // No contiene los espacios. Los saltos de línea ocupan 1 palabra.
  private static String[] leerFichero(String nombreFichero) {

    String[] textoLeido = new String[100];
    int indice = 0;

    try {
        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
        String linea = br.readLine();

        while (linea != null) {
            String[] palabrasLinea = linea.split(" "); //Separa por espacios

            for (String palabra : palabrasLinea) {
                textoLeido[indice] = palabra;

                indice++;

            }

            textoLeido[indice] = "\n";
            
            indice++;

            linea = br.readLine();
        }

        br.close();

    } catch (IOException e) {
        System.out.println("Error en fichero: " + e.getMessage());

    }

    String[] textoDevolver = new String[indice];

    for(int i=0; i<textoDevolver.length; i++) {
      textoDevolver[i]=textoLeido[i];

    }

    return textoDevolver;
  
  }
}
