package Vehiculos;
public class Acuatico extends Vehiculo {
    
    static int eslora = 250;

    @SuppressWarnings("static-access")
    public Acuatico(int esl) {

        super(modelo, matricula);
        this.eslora = esl;
    }

    public static void imprimir() {

        System.out.println("Modelo: " + modelo + " || Matrícula: " + matricula);
    }
}