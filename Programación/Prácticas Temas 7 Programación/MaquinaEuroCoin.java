/** @author Lucía González Rosas */

/* 5º.) La máquina Eurocoin genera una moneda de curso legal cada vez que se pulsa
un botón siguiendo la siguiente pauta: o bien coincide el valor con la moneda
anteriormente generada - 1 céntimo, 2 céntimos, 5 céntimos, 10 céntimos, 25
céntimos, 50 céntimos, 1 euro o 2 euros - o bien coincide la posición – cara o
cruz. Simula, mediante un programa, la generación de 6 monedas aleatorias
siguiendo la pauta correcta. Cada moneda generada debe ser una instancia de
la clase Moneda y la secuencia se debe ir almacenando en una lista. */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Moneda {

    int valor;
    String posicion;

    Moneda(int valor, String posicion) {

        this.valor = valor;
        this.posicion = posicion;

    }

    public String toString() {

        return "Valor: " + valor + ", Posición: " + posicion;

    }
}

class Eurocoin {

    private Moneda monedaAnterior;
    private String[] posiciones = {"cara", "cruz"};
    private int[] valores = {1, 2, 5, 10, 25, 50, 100, 200};

    public Moneda generarMoneda() {

        int valor;
        String posicion;

        if (monedaAnterior == null) {
            valor = valores[new Random().nextInt(valores.length)];
            posicion = posiciones[new Random().nextInt(posiciones.length)];

        } else {
            int valorIndex = -1;

            for (int i = 0; i < valores.length; i++) {
                if (valores[i] == monedaAnterior.valor) {
                    valorIndex = i;
                    break;

                }
            }
            if (valorIndex == valores.length - 1) {
                valor = valores[new Random().nextInt(valores.length)];
                posicion = posiciones[new Random().nextInt(posiciones.length)];

            } else {
                valor = valores[valorIndex + 1];
                posicion = monedaAnterior.posicion;

            }
        }

        monedaAnterior = new Moneda(valor, posicion);
        return monedaAnterior;

    }
}

public class MaquinaEuroCoin {
    public static void main(String[] args) {

        Eurocoin eurocoin = new Eurocoin();
        List<Moneda> secuenciaMonedas = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            secuenciaMonedas.add(eurocoin.generarMoneda());

        }

        for (Moneda moneda : secuenciaMonedas) {
            System.out.println(moneda);

        }
    }
}

// El proceso para crear dicho programa es el siguiente =

/* Primero se crearán dos clases, las cuales se llaman "Moneda" y "EuroCoin": la
 * primera creará los elementos de la moneda; y la segunda irá formando tanto la
 * aleatoriedad de dichas monedas como si salen de acar o de cruz (todo eso se sumará
 * en el arraylist formado en la clase pública, la cual contiene el "main" principal).
 * 
 * Después, y para terminar, se forma el "arraylist" de las monedas y, a través de bucles
 * "for", se generarán tanto las monedas como la carilla por la que salen de la máquina.
 */