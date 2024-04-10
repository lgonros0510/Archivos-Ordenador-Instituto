package VehiculosPOO;

class Avion extends VehiculoAereo {

    private int tiempoMaximoVuelo;

    public Avion(String matricula, String modelo, int numAsientos, int tiempoMaximoVuelo) {

        super(matricula, modelo, numAsientos);
        this.tiempoMaximoVuelo = tiempoMaximoVuelo;

    }

    @Override
    public void imprimir() {

        super.imprimir();
        System.out.println("Tiempo máximo de vuelo: " + tiempoMaximoVuelo + " horas");

    }
}