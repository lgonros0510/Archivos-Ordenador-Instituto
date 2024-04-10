/** @author Lucía González Rosas */

/* 1º.) Crea un ArrayList con los nombres de 6 compañeros de clase. A continuación,
muestra esos nombres por pantalla. Utiliza para ello un bucle for que recorra
todo el ArrayList sin usar ningún índice. */

import java.util.ArrayList;

public class ArrayListAlumnos {
    public static void main(String[] args) {

        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Ángel");
        nombres.add("Eloísa");
        nombres.add("Kike");
        nombres.add("Ana");
        nombres.add("Triano");
        nombres.add("Manuel");

        System.out.println("Los nombres de mis compañeros de clase son ");

        for (String nombre : nombres) {
            System.out.println(nombre);

        }
    }
}

// El proceso para crear dicho programa es el siguiente =

/* Primero formamos un "arraylist" que contenga los nombres de los alumnos que queramos
 * mostrar por pantalla.
 * 
 * Después, vamos añadiendo al arraylist los nombres que queramos utilizando el método
 * ".add()", el cual permite añadir de forma secuencial dichos elementos; es decir, que
 * cada nombre que se introduzca en el arraylist se introduce a la derecha del anterior.
 * 
 * Por último, utilizamos un bucle "for-each" que muestre los nombres de los alumnos por
 * pantalla.
 */