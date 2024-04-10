package Vehiculos;
/** @author Lucía González Rosas */

/* Se creará los métodos y funciones para dar forma a la clase "Avion".
 */

public class Avion extends Aereo{
    
    private static int tiempoMaxVuelo;

    public Avion(int tMaxVuelo) {

        super(numeroAsientos);
        Avion.tiempoMaxVuelo = tMaxVuelo;
    }

    public static void imprimir() {

        System.out.println("Modelo: " + modelo + " || Matrícula: " + matricula + " || Tiempo máximo de vuelo: " + tiempoMaxVuelo);
    }
}