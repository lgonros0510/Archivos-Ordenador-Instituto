/** @author Lucía González Rosas */
/* 1º. de DAW ||| 4 de marzo del 2024 */

/* Este examen trata sobre la creación de un programa que permita crear un mini-editor donde nos permita
 * pintar a través de la consola. Se forma un tablero de 11x11 con un puntero ('+') que cambiará de modo
 * (ya sea si queremos pintar, movernos o borrar lo que hayamos pintado) según lo que prefiramos. Para
 * ello, se crearán las funciones "limpiarTablero()" (que permite limpiar lo que hayamos dibujado), "mover()"
 * (nos permite movernos por la pantalla al pulsar W-A-S-D), "imprimirTablero()" (crea el tablero por consola),
 * entre otras funciones que nos permita tener el programa completado.
 */

/* Solamente hay que rellenar las funciones "limpiarTablero()", "imprimirTablero()" y "mover()" con lo que nos
 * permitirá tener el código en condiciones y sin errores. No hay que tocar nada más.
 */

import java.util.Scanner;
public class JavaPaint {


//------------------------------------------------------------------------------------
//                 VARIABLES GLOBALES SUMINISTRADAS (NO TOCAR)
//------------------------------------------------------------------------------------


    static int altoTablero = 11;
    static int anchoTablero = 11;

    static String tablero[][] = new String[anchoTablero][altoTablero];

    static int posicionX = anchoTablero/2;
    static int posicionY = altoTablero/2;

    static final char PUNT_MUEVE = '+';
    static final char PUNT_PINTA = 'V';
    static final char PUNT_BORRA = 'O';

    static char puntero = PUNT_MUEVE;
    static int color=0; //0=Blanco

    static final String COLORES[] = {"\u001B[37m","\u001B[31m","\u001B[32m","\u001B[33m","\u001B[34m"}; //Blanco, rojo, verde, amarillo, azul
    static final String COLOR_RESET = "\u001B[0m";

//------------------------------------------------------------------------------------
//                 MÉTODOS POR HACER
//------------------------------------------------------------------------------------

    public static void limpiarTablero() {

        for (int i = 0; i < anchoTablero; i++) {
            for (int j = 0; j < altoTablero; j++) {
                tablero[i][j] = " ";

            }
        }
    }

    public static void imprimirTablero() {

        System.out.println("┌───────────┐");
        
        for (int j = 0; j < altoTablero; j++) {
            System.out.print("│");

            for (int i = 0; i < anchoTablero; i++) {
                if (posicionX == i && posicionY == j) {
                    if (puntero == PUNT_MUEVE || puntero == PUNT_BORRA) {
                        System.out.print(COLORES[color] + puntero + COLOR_RESET);
                        
                    } else if (puntero == PUNT_PINTA) {
                        System.out.print(COLORES[color] + tablero[i][j] + COLOR_RESET);

                    }

                } else {
                    System.out.print(COLORES[color] + tablero[i][j] + COLOR_RESET);

                }
            }

            System.out.println("│");

        }
        
        System.out.println("└───────────┘");

    }
    
    public static void mover(String direccion) {

        switch (direccion) {
            case "izquierda":
                if (posicionX > 0) {
                    if (puntero == PUNT_PINTA) {
                        tablero[posicionX][posicionY] = COLORES[color] + puntero + COLOR_RESET;

                    } else if (puntero == PUNT_BORRA) {
                        tablero[posicionX][posicionY] = " ";

                    }

                    posicionX--;

                }

                break;

            case "derecha":
                if (posicionX < anchoTablero - 1) {
                    if (puntero == PUNT_PINTA) {
                        tablero[posicionX][posicionY] = COLORES[color] + puntero + COLOR_RESET;

                    } else if (puntero == PUNT_BORRA) {
                        tablero[posicionX][posicionY] = " ";

                    }

                    posicionX++;

                }

                break;

            case "arriba":
                if (posicionY > 0) {
                    if (puntero == PUNT_PINTA) {
                        tablero[posicionX][posicionY] = COLORES[color] + puntero + COLOR_RESET;

                    } else if (puntero == PUNT_BORRA) {
                        tablero[posicionX][posicionY] = " ";

                    }

                    posicionY--;

                }

                break;

            case "abajo":
                if (posicionY < altoTablero - 1) {
                    if (puntero == PUNT_PINTA) {
                        tablero[posicionX][posicionY] = COLORES[color] + puntero + COLOR_RESET;

                    } else if (puntero == PUNT_BORRA) {
                        tablero[posicionX][posicionY] = " ";

                    }

                    posicionY++;

                }

                break;
                
        }
    }

//------------------------------------------------------------------------------------
//                 MÉTODOS SUMINISTRADOS COMPLETOS
//------------------------------------------------------------------------------------

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    char opcion = 'x';
   
    limpiarTablero();

    do {
        imprimirTablero();
        muestraMenu();

        opcion = leerOpcion(sc);

        switch (opcion) {
            case 'a','A':
                mover("izquierda");
                break;

            case 'd','D':
                mover("derecha");
                break;

            case 's','S':
                mover("abajo");
                break;

            case 'w','W':
                mover("arriba");
                break;

            case 'x','X':
                cambiarModo();
                break;

            case 'l','L':
                limpiarTablero();
                break;

            case 'c','C':
                cambiarColor();
                break;

            case 'q','Q':
                break;

            default:

        }  

    } while (opcion != 'q' && opcion !='Q');

    sc.close();

}

    /** 
    * COMPLETO, NO TOCAR!
    */
    public static void muestraMenu(){

        System.out.println("A: Izquierda; D: Derecha; S: Abajo; W: Arriba");
        System.out.println("X: Cambia modo (Mover / Pintar / Borrar)");
        System.out.println("C. Color; L: Limpiar Tablero; Q: Salir");
        
    }

    /** 
    * COMPLETO, NO TOCAR!
    */
    public static char leerOpcion(Scanner sc){

        return sc.next().charAt(0);

    }

    /** 
    * COMPLETO, NO TOCAR!
    */
    public static void cambiarModo() {

        switch (puntero) {
            case PUNT_MUEVE:
                puntero = PUNT_PINTA;
                break;

            case PUNT_PINTA:
                puntero = PUNT_BORRA;
                break;

            case PUNT_BORRA:
                puntero = PUNT_MUEVE;
                break;

        }
    }
    
    /** 
     * COMPLETO, NO TOCAR!
     */
    public static void cambiarColor() {

        color = (color+1) % COLORES.length;

    }   
}