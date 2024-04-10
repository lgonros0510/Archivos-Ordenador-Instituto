/** @author Lucía González Rosas */

/* 6º.) Realiza un programa que escoja al azar 10 cartas de la baraja española
(10 objetos de la clase Carta). Emplea un objeto de la clase ArrayList para
almacenarlas y asegúrate de que no se repite ninguna. */

import java.util.ArrayList;
import java.util.Collections;

class Carta {

    private String palo;
    private String valor;

    public Carta(String palo, String valor) {

        this.palo = palo;
        this.valor = valor;

    }

    public String getPalo() {

        return palo;

    }

    public String getValor() {

        return valor;

    }

    public String toString() {

        return valor + " de " + palo;

    }
}

public class BarajaEspañola {
    public static void main(String[] args) {

        ArrayList<Carta> baraja = new ArrayList<>();

        String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey"};

        for (String palo : palos) {
            for (String valor : valores) {
                baraja.add(new Carta(palo, valor));

            }
        }

        Collections.shuffle(baraja);

        ArrayList<Carta> mano = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Carta carta = baraja.remove(0);
            mano.add(carta);

        }

        System.out.println("Las cartas seleccionadas son");

        for (Carta carta : mano) {
            System.out.println(carta);

        }
    }
}

// El proceso para crear dicho programa es el siguiente =

/* Primero creamos la clase "Carta()", donde le insertaremos los atributos
 * privados "palo" (que puede ser de oros, bastos, copas o espadas) y "valor"
 * (que puede ser as, 2, 3, 4, 5, 6, 7, sota, caballo o rey).
 * 
 * También le vamos a crear otras funciones para que la clase pueda usarse en el
 * "main", como "Carta(String palo, String valor)" (el cual definirá tanto los palos
 * como los valores), los "getters" para conseguir el valor de los palos y los valores
 * de las cartas y el método "toString()" que nos permitirá manejar el resultado que
 * nos saldrá por pantalla.
 * 
 * Ahora con la clase "Carta()" ya construida, se crea la clase principal con su "main"
 * para darle forma al programa. Para ello, se creará primero el ArrayList que contenga
 * la baraja completa y dos arrays comunes que contengan los palos y los valores de cada
 * carta de la baraja.
 * 
 * A continuación, empleando un bucle "for-each" doble, crearemos el bucle por el que se
 * irán introduciendo los palos y los valores de las cartas usando la línea "baraja.add(
 * new Carta(palo, valor));".
 * 
 * Con el bucle ya insertado, se utiliza el método "Collections.shuffle(baraja)" para ir
 * barajando las cartas (funciona como si fuese un método "random", pero menos complejo)
 * y se crea otro ArrayList donde se definirá la mano que nos vaya a tocar (es decir, el
 * montoncito de cartas que nos haya tocado de manera aleatoria después de barajarlas).
 * 
 * Por último, con un bucle "for" común se irá eliminando cartas de la baraja para introducirlas
 * a la mano usando los métodos ".remove()" y ".add()" y un bucle "for-each" donde se mostrará
 * la mano que nos haya tocado por pantalla.
 */