package Vehiculos;
/** @author Lucía González Rosas */

/* Se creará los métodos y funciones para dar forma a la clase "Submarino".
 */

public class Submarino extends Acuatico{
    
    private static int profundidadMaxima;

    public Submarino(int profM) {

        super(eslora);
        Submarino.profundidadMaxima = profM;
    }

    public static void imprimir() {

        System.out.println("Modelo: " + modelo + " || Matrícula: " + matricula + " || Profundidad máxima: " + profundidadMaxima);
    }
}