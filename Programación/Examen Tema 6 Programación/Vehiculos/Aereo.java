package Vehiculos;
public class Aereo extends Vehiculo {
    
    static int numeroAsientos = 30;

    @SuppressWarnings("static-access")
    public Aereo(int numA) {

        super(modelo, matricula);
        this.numeroAsientos = numA;
    }

    public static void imprimir() {

        System.out.println("Modelo: " + modelo + " || Matrícula: " + matricula);
    }
}