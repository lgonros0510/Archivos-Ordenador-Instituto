/** @author Lucía González Rosas */

/* Esta es la primera parte del proyecto de 'Hundir la Flota' de la asignatura de Programación, donde
 * se creará un tablero para introducir posteriormente y de manera aleatoria los barcos, que son de hasta
 * 3 tamaños diferentes, en dicho tablero. También habrá dos modos de juego; uno donde se represente los
 * barcos, la proximidad de estos y el agua con caracteres cualesquiera (Modo Normal); y otro donde se
 * representan de forma numérica (Modo Debug).
 */

import java.awt.Color;
import java.util.Random;

public class HundirLaFlota1 {

    static int[][] matriz = new int[10][10];
    static boolean mostrarMatriz = false; // Indica el modo de juego (true = Modo Debug / false = Modo Normal). Se modifica en el código.

    final static String aguaColor = "\033[36m" + "~ " + "\u001B[0m";
    final static String proximidadColor = "\033[34m" + "· " + "\u001B[0m";
    final static String barcoColor = "\033[31m" + "X " + "\u001B[0m";

    public static void main(String[] args) {

        inicializarTablero();
        generarBarcos();
        dibujarTablero();

    }
    
    static void inicializarTablero() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = 0;

            }
        }
    }

    static void generarBarcos() {
        Random random = new Random();
    
        for (int i = 2; i <= 4; i++) {
            int tamaño = i;
    
            // Esta parte sirve para evitar que los barcos estén pegados entre sí o al borde del tablero.
            boolean barcoGenerado = false;
    
            while (!barcoGenerado) {
                int fila = random.nextInt(8) + 1;
                int columna = random.nextInt(8) + 1;
                int direccion = random.nextInt(2); // La dirección de los barcos (0 = Horizontal, 1 = Vertical).
    
                if (esPosicionValida(fila, columna, tamaño, direccion)) {
                    colocarBarco(fila, columna, tamaño, direccion);
    
                    rodearBarcoConUnos(fila, columna, tamaño, direccion);
    
                    barcoGenerado = true;

                }
            }
        }
    }
    
    static void rodearBarcoConUnos(int fila, int columna, int tamaño, int direccion) {
        // Permite rodear el barco con 1s según la dirección y tamaño del barco.
        // Por ejemplo, si el barco es horizontal, rodear las posiciones superiores e inferiores.
        // Si el barco es vertical, rodear las posiciones a la izquierda y derecha.
    
        if (direccion == 0) { // Barco en horizontal.
            for (int i = fila - 1; i <= fila + 1; i++) {
                for (int j = columna - 1; j <= columna + tamaño; j++) {
                    if (i >= 1 && i <= 8 && j >= 1 && j <= 8) {
                        matriz[i][j] = 1;

                        if (tamaño >= 2 && tamaño <= 4) {
                            colocarBarco(fila, columna, tamaño, direccion);

                        }
                    }
                }
            }

        } else { // Barco en vertical.
            for (int i = fila - 1; i <= fila + tamaño; i++) {
                for (int j = columna - 1; j <= columna + 1; j++) {
                    if (i >= 1 && i <= 8 && j >= 1 && j <= 8) {
                        matriz[i][j] = 1;
                        
                        if (tamaño >= 2 && tamaño <= 4) {
                            colocarBarco(fila, columna, tamaño, direccion);

                        }
                    }
                }
            }
        }
    }

    static boolean esPosicionValida(int fila, int columna, int tamaño, int direccion) {

        if (direccion == 0) { // Barco en horizontal.
            if (columna + tamaño - 1 <= 8) {
                for (int j = columna; j < columna + tamaño; j++) {
                    if (matriz[fila][j] != 0) {
                        return false; // Si un barco está pegado a otro.

                    }
                }

                return true;

            }
        } else { // Barco en vertical.
            if (fila + tamaño - 1 <= 8) {
                for (int i = fila; i < fila + tamaño; i++) {
                    if (matriz[i][columna] != 0) {
                        return false; // Si un barco está pegado a otro.

                    }
                }

                return true;

            }
        }

        return false; // Si el barco está fuera de límites del tablero.
    }

    static void colocarBarco(int fila, int columna, int tamaño, int direccion) {

        if (direccion == 0) { // Barco en horizontal.
            for (int j = columna; j < columna + tamaño; j++) {
                matriz[fila][j] = tamaño;

            }

        } else { // Barco en vertical.
            for (int i = fila; i < fila + tamaño; i++) {
                matriz[i][columna] = tamaño;

            }
        }
    }

    static void dibujarTablero() {

        System.out.print("  1 2 3 4 5 6 7 8 \n");

        for (int i = 1; i <= 8; i++) {
            System.out.print(i + " ");

            for (int j = 1; j <= 8; j++) {
                if (mostrarMatriz) {
                    System.out.print(matriz[i][j] + " ");

                } else {
                    if (matriz[i][j] == 0) {
                        System.out.print(aguaColor);

                    } else if (matriz[i][j] == 1) {
                        System.out.print(proximidadColor);

                    } else {
                        System.out.print(barcoColor);

                    }
                }
            }

            System.out.println();

        }
    }
}
