/** @author Lucía González Rosas */

/* 3º.) Realiza un programa equivalente al anterior pero en esta ocasión, el programa
debe ordenar palabras en lugar de números. */

import java.util.ArrayList;
import java.util.Random;

public class OrdenarPalabras {
    public static void main(String[] args) {

        Random random = new Random();

        int tamanoLista = random.nextInt(11) + 10;

        ArrayList<String> palabras = new ArrayList<>();

        for (int i = 0; i < tamanoLista; i++) {
            palabras.add(generarPalabraAleatoria());

        }

        int sumaLongitudes = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;

        for (String palabra : palabras) {
            int longitud = palabra.length();
            sumaLongitudes += longitud;

            if (longitud > maximo) {
                maximo = longitud;

            }
            if (longitud < minimo) {
                minimo = longitud;

            }
        }

        double media = (double) sumaLongitudes / tamanoLista;

        System.out.println("Las palabras aleatorias generadas son " + palabras);
        System.out.println("La suma de las longitudes de dichas palabras es " + sumaLongitudes);
        System.out.println("La media de las longitudes de dichas palabras es " + media);
        System.out.println("La máxima longitud de dichas palabras es " + maximo);
        System.out.println("La mínima longitud de dichas palabras es " + minimo);

    }

    private static String generarPalabraAleatoria() {

        Random random = new Random();
        int longitud = random.nextInt(10) + 1;
        StringBuilder palabra = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            char letra = (char) ('a' + random.nextInt(26));
            palabra.append(letra);

        }

        return palabra.toString();

    }
}

// El proceso para crear dicho programa es el siguiente =

/* Primero creamos el tamaño de la lista utilizando el formato "random" y creamos el "arraylist"
 * donde introduciremos las palabras aleatorias que queramos.
 * 
 * Después, utilizando un bucle "for" y sentencias "if" se irán sumando las palabras aleatorias
 * al arraylist formado anteriormente usando la función "generarPalabraAleatoria()", la cual,
 * utilizando el "StringBuilder" y un bucle "for", se va introduciendo las palabras aleatorias
 * usando el método ".append()" y ".nextInt()" para, luego, devolver las palabras introducidas.
 * 
 * Por último, se calcula la media de las longitudes de dichas palabras y se muestran tanto las palabras
 * que se generaron como la suma, la media, el máximo y el mínimo de sus longitudes indiciduales.
 */