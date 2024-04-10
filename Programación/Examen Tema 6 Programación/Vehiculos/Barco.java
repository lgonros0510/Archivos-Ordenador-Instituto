package Vehiculos;
/** @author Lucía González Rosas */

/* Se creará los métodos y funciones para dar forma a la clase "Barco".
 */

public class Barco extends Acuatico {
    
    private static boolean motor;

    public Barco(boolean m) {

        super(eslora);
        Barco.motor = m;
    }

    public static void imprimir() {

        System.out.println("Modelo: " + modelo + " || Matrícula: " + matricula + " || Motor: " + motor);
    }
}