package VehiculosPOO;

abstract class VehiculoAereo extends Vehiculo {

    private int numAsientos;

    public VehiculoAereo(String matricula, String modelo, int numAsientos) {

        super(matricula, modelo);
        this.numAsientos = numAsientos;

    }

    public int getNumAsientos() {

        return numAsientos;

    }

    public void setNumAsientos(int numAsientos) {

        this.numAsientos = numAsientos;

    }

    @Override
    public void imprimir() {

        System.out.println("Matrícula: " + getMatricula() + " || Modelo: " + getModelo() + " || Número de asientos: " + numAsientos);

    }
}