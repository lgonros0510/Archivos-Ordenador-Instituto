package VehiculosPOO;

class Submarino extends VehiculoAcuatico {

    private int profundidadMaxima;

    public Submarino(String matricula, String modelo, double eslora, int profundidadMaxima) {

        super(matricula, modelo, eslora);
        this.profundidadMaxima = profundidadMaxima;

    }

    @Override
    public void imprimir() {

        super.imprimir();
        System.out.println("Profundidad máxima: " + profundidadMaxima + " metros");

    }
}