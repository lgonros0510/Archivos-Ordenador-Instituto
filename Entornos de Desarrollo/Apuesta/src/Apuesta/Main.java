/** @author Lucía González Rosas */

package Apuesta;

public class Main {

    /* Contiene las variables que sirven para apostar y para almacenar, suministrar y
    * mostrar el dinero que tengamos en la cuenta.
    * También contiene la función "operativa_Apuesta" para su funcionamiento.
    */
    public static void main(String[] args) {
        Apuesta laApuesta;
        int mi_dinero;

        operativa_Apuesta();
    }

    /* Contiene las operaciones necesarias para realizar las apuestas, mostrar si existen
    * fallos al realizarlas o cobrarlas y mostrar por pantalla la catidad que tengamos al
    * finalizar las apuestas.
    */
    public static void operativa_Apuesta() {
        Apuesta laApuesta;
        int mi_dinero;
        laApuesta = new Apuesta(1000, 4, 2);
        try {
            System.out.println("Apostando...");
            laApuesta.apostar(25);
        } catch (Exception e) {
            System.out.println("Fallo al realizar la Apuesta");
        }
        try {
            System.out.println("Intento cobrar apuesta segun el resultado del partido");
            laApuesta.cobrar_apuesta(2, 3);
        } catch (Exception e) {
            System.out.println("Fallo al cobrar la apuesta");
        }
        mi_dinero = laApuesta.getDinero_disp();
        System.out.println("El dinero que tengo tras las apuestas es " + mi_dinero);
    }
}
