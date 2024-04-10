package Vehiculos;
/** @author Lucía González Rosas */

/* Se creará los métodos para establecer los modelos y las matrículas de los
 * vehículos.
 */

class Vehiculo {
    
    static String modelo;
    static String matricula;
    int numeroRuedas;
    int eslora;
    int numeroAsientos;

    @SuppressWarnings("static-access")
    public Vehiculo(String modelo, String matricula) {

        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getModelo() {

        return modelo;
    }

    public String getMatricula() {

        return matricula;
    }
}