package VehiculosPOO;

abstract class VehiculoAcuatico extends Vehiculo {

    private double eslora;

    public VehiculoAcuatico(String matricula, String modelo, double eslora) {

        super(matricula, modelo);
        this.eslora = eslora;

    }

    public double getEslora() {

        return eslora;

    }

    public void setEslora(double eslora) {

        this.eslora = eslora;

    }

    @Override
    public void imprimir() {

        System.out.println("Matrícula: " + getMatricula() + " || Modelo: " + getModelo() + " || Eslora: " + eslora);

    }
}