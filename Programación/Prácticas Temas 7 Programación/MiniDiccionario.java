/** @author Lucía González Rosas */

/* 7º.) Crea un mini-diccionario español-inglés que contenga, al menos, 20 palabras
(con su correspondiente traducción). Utiliza un objeto de la clase HashMap para
almacenar las parejas de palabras. El programa pedirá una palabra en español
y dará la correspondiente traducción en inglés. */

import java.util.HashMap;
import java.util.Scanner;

public class MiniDiccionario {
    public static void main(String[] args) {

        HashMap<String, String> diccionario = new HashMap<>();
        
        diccionario.put("casa", "house");
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");
        diccionario.put("árbol", "tree");
        diccionario.put("coche", "car");
        diccionario.put("libro", "book");
        diccionario.put("ordenador", "computer");
        diccionario.put("amarillo", "yellow");
        diccionario.put("azul", "blue");
        diccionario.put("rojo", "red");
        diccionario.put("verde", "green");
        diccionario.put("naranja", "orange");
        diccionario.put("manzana", "apple");
        diccionario.put("plátano", "banana");
        diccionario.put("fresa", "strawberry");
        diccionario.put("nube", "cloud");
        diccionario.put("sol", "sun");
        diccionario.put("luna", "moon");
        diccionario.put("estrella", "star");
        diccionario.put("agua", "water");
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca una palabra en español: ");
        String palabraEspañol = scanner.nextLine().toLowerCase();
        
        String traduccion = diccionario.get(palabraEspañol);
        
        if (traduccion != null) {
            System.out.println("La traducción al inglés es " + traduccion);

        } else {
            System.out.println("La palabra no se encuentra en el diccionario.");

        }
        
        scanner.close();

    }
}

// El proceso para crear dicho programa es el siguiente =

/* Primero se creará un listado "HashMap" donde se formará el diccionario e iremos
 * introduciendo, a base de utilizar el método ".put(clave, valor)", las palabras en
 * español (las que introduciremos por teclado) y en inglés (las que nos saldrán como
 * la traducción de dichas palabras que introduzcamos).
 * 
 * Después, se utilizará un "sysout" para pedirle al usuario que escriba una palabra en
 * español y, para que se pueda escanear, utlizaremos los métodos".nextLine()" (para que,
 * al pulsar el tabulador, se pueda pasar a la siguiente parte del programa) y ".toLowerCase()"
 * (para que la palabra introducida esté siempre en minúsculas).
 * 
 * Por último, se introducirá la palabra insertada por teclado en el diccionario empleando el
 * método ".get()" y, a base de sentencias "if", se mostrará por pantalla un mensaje dependiendo
 * si la palabra que introduzcamos por teclado está dentro del diccionario o no.
 */