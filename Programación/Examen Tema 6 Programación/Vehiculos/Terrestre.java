package Vehiculos;
/** @author Lucía González Rosas */

/* Se creará los métodos y funciones para dar forma a la clase Terrestre".
 */

public class Terrestre extends Vehiculo {

    static int numeroRuedas = 4;

    @SuppressWarnings("static-access")
    public Terrestre(int numR) {

        super(modelo, matricula);
        this.numeroRuedas = numR;
    }

    public static void imprimir() {

        System.out.println("Modelo: " + modelo + " || Matrícula: " + matricula);
    }
}