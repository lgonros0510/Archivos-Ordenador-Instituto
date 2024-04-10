/** @author Lucía González Rosas */

/* En este programa se creará un juego completo de "Tres en Raya" ("Tic-Tac-Toe"). Dicho juego tendrá como
 * base un tablero de 3x3 donde, estando 2 jugadores en el juego (aquí los llamo yo "Jugador X" y "Jugador O"),
 * cada uno tendrá que ir escribiendo unas coordenadas cuando le toque para ir rellenando el tablero (por ejemplo,
 * en las coordenadas (1,2) se colocará una X por el "Jugador X") hasta que se obtenga una línea de tres símbolos
 * iguales, ya sea en vertical, horizontal o diagonal. Se determinará también si hay un ganador claro o un empate
 * sin un ganador en específico.
 */

public class TresEnRaya {

    private static char[][] tablero = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char jugadorActual = 'X';

    public static void main(String[] args) {

        jugarTresEnRaya();

    }

    private static void jugarTresEnRaya() {

        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            mostrarTablero();
            realizarMovimiento();

            juegoEnCurso = !haTerminado();

            cambiarJugador();

        }

        mostrarTablero();
        determinarGanador();

    }

    private static void mostrarTablero() {

        System.out.println("  0 1 2");

        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");

            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);

                if (j < 2) {
                    System.out.print("|");

                }
            }

            System.out.println();

            if (i < 2) {
                System.out.println("  -----");

            }
        }

        System.out.println();

    }

    private static void realizarMovimiento() {

        int fila, columna;

        do {
            System.out.println("Jugador " + jugadorActual + ", ingresa la fila y columna a rellenar (ejemplo: 1 2): ");

            fila = Integer.parseInt(System.console().readLine());
            columna = Integer.parseInt(System.console().readLine());

        } while (!esMovimientoValido(fila, columna));

        tablero[fila][columna] = jugadorActual;
        
    }

    private static boolean esMovimientoValido(int fila, int columna) {

        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || tablero[fila][columna] != ' ') {
            System.out.println("Dicho movimiento no es válido. Inténtalo de nuevo, por favor.");

            return false;

        }

        return true;

    }

    private static boolean haTerminado() {

        return haGanado() || tableroLleno();

    }

    private static boolean haGanado() {

        return revisarFilas() || revisarColumnas() || revisarDiagonales();

    }

    private static boolean revisarFilas() {

        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {

                return true;

            }
        }

        return false;

    }

    private static boolean revisarColumnas() {

        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugadorActual && tablero[1][j] == jugadorActual && tablero[2][j] == jugadorActual) {
                return true;

            }
        }

        return false;

    }

    private static boolean revisarDiagonales() {

        return (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) ||
                (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual);

    }

    private static boolean tableroLleno() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;

                }
            }
        }

        return true;

    }

    private static void determinarGanador() {

        if (haGanado()) {
            System.out.println("¡El jugador " + jugadorActual + " ha ganado la partida!");

        } else {
            System.out.println("¡Empate! El juego ha terminado sin un ganador en específico.");

        }
    }

    private static void cambiarJugador() {

        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';

    }
}