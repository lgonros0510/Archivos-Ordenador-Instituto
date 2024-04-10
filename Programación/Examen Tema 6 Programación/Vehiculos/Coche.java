package Vehiculos;
/** @author Lucía González Rosas */

/* Se creará los métodos y funciones para dar forma a la clase "Coche".
 */

public class Coche extends Terrestre{
    
    private static boolean aireAcondicionado;

    public Coche(boolean airAcon) {

        super(numeroRuedas);
        Coche.aireAcondicionado = airAcon;
    }
    
    public static void imprimir() {

        System.out.println("Modelo: " + modelo + " || Matrícula: " + matricula + " || Aire acondicionado: " + aireAcondicionado);
    }
}