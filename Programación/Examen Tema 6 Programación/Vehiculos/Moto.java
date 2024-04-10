package Vehiculos;
/** @author Lucía González Rosas */

/* Se creará los métodos y funciones para dar forma a la clase "Moto".
 */

public class Moto extends Terrestre{
    
    private static String color;

    public Moto(String c) {

        super(numeroRuedas);
        Moto.color = c;
    }

    public static void imprimir() {

        System.out.println("Modelo: " + modelo + " || Matrícula: " + matricula + " || Color: " + color);
    }
}