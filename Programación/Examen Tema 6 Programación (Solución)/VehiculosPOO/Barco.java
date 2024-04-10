package VehiculosPOO;

class Barco extends VehiculoAcuatico {

    private boolean motor;

    public Barco(String matricula, String modelo, double eslora, boolean motor) {

        super(matricula, modelo, eslora);
        this.motor = motor;

    }

    @Override
    public void imprimir() {

        super.imprimir();
        System.out.println("Motor: " + (motor ? "Sí" : "No"));
        
    }
}