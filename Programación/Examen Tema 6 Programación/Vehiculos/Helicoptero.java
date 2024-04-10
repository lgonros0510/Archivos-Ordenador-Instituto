package Vehiculos;
public class Helicoptero extends Aereo{
    
    private static int numeroHelices;

    public Helicoptero(int numH) {

        super(numeroAsientos);
        Helicoptero.numeroHelices = numH;
    }

    public static void imprimir() {

        System.out.println("Modelo: " + modelo + " || Matrícula: " + matricula + " || Número de hélices: " + numeroHelices);
    }
}