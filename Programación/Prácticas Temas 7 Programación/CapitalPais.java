/** @author Lucía González Rosas */

/* 9º.) Realiza un programa que sepa decir la capital de un país (en caso de conocer
la respuesta) y que, además, sea capaz de aprender nuevas capitales. En
principio, el programa solo conoce las capitales de España, Portugal y Francia.
Estos datos deberán estar almacenados en un diccionario. Los datos sobre
capitales que vaya aprendiendo el programa se deben almacenar en el mismo
diccionario. El usuario sale del programa escribiendo la palabra “salir”.

Ejemplo:
Escribe el nombre de un país y te diré su capital: España
La capital de España es Madrid
Escribe el nombre de un país y te diré su capital: Alemania
No conozco la respuesta ¿cuál es la capital de Alemania?: Berlín
Gracias por enseñarme nuevas capitales
Escribe el nombre de un país y te diré su capital: Portugal
La capital de Portugal es Lisboa
Escribe el nombre de un país y te diré su capital: Alemania
La capital de Alemania es Berlín
Escribe el nombre de un país y te diré su capital: Francia
La capital de Francia es París
Escribe el nombre de un país y te diré su capital: salir */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CapitalPais {
    public static void main(String[] args) {

        Map<String, String> capitales = new HashMap<>();

        capitales.put("España", "Madrid");
        capitales.put("Portugal", "Lisboa");
        capitales.put("Francia", "París");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Escribe el nombre de un país y te diré su capital: ");
            String pais = scanner.nextLine();

            if (pais.equalsIgnoreCase("salir")) {
                System.out.println("¡Hasta luego!");
                break;

            }

            String capital = capitales.get(pais);

            if (capital != null) {
                System.out.println("La capital de " + pais + " es " + capital);

            } else {
                System.out.print("No conozco la respuesta. ¿Cuál es la capital de " + pais + "?: ");
                String nuevaCapital = scanner.nextLine();

                capitales.put(pais, nuevaCapital);
                System.out.println("Gracias por enseñarme nuevas capitales.");

            }
        }

        scanner.close();

    }
}

// El proceso para crear dicho programa es el siguiente =

/* Primero crearemos un "Map" donde se almacenarán los países (claves) y sus
 * capitales (valores) para insertar entonces varios utilizando el método ".put()".
 * 
 * Luego, utilizaremos un bucle "while" donde, mientras sea verdadero, se podrá
 * escribir por teclado los nombres de los países para, por medio de una sentencia
 * "if" y el método ".equalsIgnoreCase()", determinar la salida del programa.
 * 
 * Por último, y dentro del propio bucle "while", se utilizará el método ".get()"
 * para sacar las capitales de los países y, por medio de un bucle "if", se determinará
 * si se mostrará las capitales de sus respectivos países (si la capital no es igual a
 * "null") o si el programa decide preguntarnos acerca de una capital que desconozca en
 * su inventario.
 */