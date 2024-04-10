package VehiculosPOO;

abstract class VehiculoTerrestre extends Vehiculo {

    private int numRuedas;

    public VehiculoTerrestre(String matricula, String modelo, int numRuedas) {

        super(matricula, modelo);
        this.numRuedas = numRuedas;

    }

    public int getNumRuedas() {

        return numRuedas;

    }

    public void setNumRuedas(int numRuedas) {

        this.numRuedas = numRuedas;

    }

    @Override
    public void imprimir() {

        System.out.println("Matrícula: " + getMatricula() + " || Modelo: " + getModelo() + " || Número de ruedas: " + numRuedas);

    }
}