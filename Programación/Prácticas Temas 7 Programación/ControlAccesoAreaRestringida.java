/** @author Lucía González Rosas */

/* 4º.) Implementa el control de acceso al área restringida de un programa. Se debe
pedir un nombre de usuario y una contraseña. Si el usuario introduce los
datos correctamente, el programa dirá “Ha accedido al área restringida”. El
usuario tendrá un máximo de 3 oportunidades. Si se agotan las oportunidades
el programa dirá “Lo siento, no tiene acceso al área restringida”. Los nombres
de usuario con sus correspondientes contraseñas deben estar almacenados en
una estructura de la clase HashMap. */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControlAccesoAreaRestringida {
    public static void main(String[] args) {

        Map<String, String> usuarios = new HashMap<>();
        
        usuarios.put("usuario1", "contraseña1");
        usuarios.put("usuario2", "contraseña2");
        usuarios.put("usuario3", "contraseña3");

        Scanner scanner = new Scanner(System.in);

        int intentosRestantes = 3;

        while (intentosRestantes > 0) {
            System.out.print("Su nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();

            System.out.print("Su contraseña: ");
            String contraseña = scanner.nextLine();

            if (usuarios.containsKey(nombreUsuario) && usuarios.get(nombreUsuario).equals(contraseña)) {
                System.out.println("Usted ha accedido al área restringida.");
                break;

            } else {
                intentosRestantes--;

                if (intentosRestantes == 0) {
                    System.out.println("Lo siento; usted no tiene acceso al área restringida.");

                } else {
                    System.out.println("Las credenciales son incorrectas. Tus intentos restantes: " + intentosRestantes);

                }
            }
        }

        scanner.close();

    }
}

// El proceso para crear dicho programa es el siguiente =

/* Primero se crea un "arraylist" donde se introducirán tanto el nombre como la contraseña
 * del usuario, además de ir añadiendo dichos elementos al arraylist usando el método ".put()".
 * 
 * Después, utilizando un bucle "while", se introudce tanto el nombre y contraseñas posibles por
 * teclado, donde a través de sentencias "if" y los métodos ".containsKey()" (que permite detectar si
 * contiene el mismo elemento "String" en el arraylist), ".get()" y ".equals()", permite ir procesando
 * si el usuario se encuentra en el área restringida o no.
 * 
 * Por último, y en caso de que no se encuentre el usuario en el área restringida, se irán restando
 * los intentos posibles (el máximo de intentos es 3) para que, si llega a 0, nos diga por pantalla que
 * no tenemos acceso a dicha área o, si fallamos y nos quedan intentos restantes, nos digan por pantalla
 * que las credenciales son incorrectas y lo intentemos de nuevo.
 */