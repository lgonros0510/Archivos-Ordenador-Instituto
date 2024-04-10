/** @author Lucía González Rosas */

/* 2º.) Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un
ArrayList y que luego calcule la suma, la media, el máximo y el mínimo de esos
números. El tamaño de la lista también será aleatorio y podrá oscilar entre 10
y 20 elementos ambos inclusive. */

import java.util.ArrayList;
import java.util.Random;

public class SumaMediaMaxMin {
    public static void main(String[] args) {

        Random random = new Random();

        int tamanoLista = random.nextInt(11) + 10;

        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < tamanoLista; i++) {
            numeros.add(random.nextInt(101));

        }

        int suma = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;

        for (int num : numeros) {
            suma += num;

            if (num > maximo) {
                maximo = num;

            }
            if (num < minimo) {
                minimo = num;

            }
        }

        double media = (double) suma / tamanoLista;

        System.out.println("los valores aleatorios generados son " + numeros);
        System.out.println("La suma de dichos números es " + suma);
        System.out.println("La media de dichos números es " + media);
        System.out.println("El máximo de dichos números es " + maximo);
        System.out.println("El mínimo de dichos números es " + minimo);
        
    }
}

// El proceso para crear dicho programa es el siguiente =

/* Primero creamos el tamaño de la lista utilizando el formato "random" y creamos el "arraylist"
 * donde introduciremos los números aleatorios que queramos.
 * 
 * Después, utilizando un bucle "for", se va introduciendo dichos números que van desde el 0 al 101
 * usando los métodos ".add" y ".nextInt()".
 * 
 * Por último, se crea un bucle "for" donde se va formando el máximo y el mínimo de dichos números para,
 * posteriormente, mostrar tanto los números que se han generado como la suma, la media, el máximo y el
 * mínimo de dichas números.
 */