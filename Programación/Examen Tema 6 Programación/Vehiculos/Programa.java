package Vehiculos;

public class Programa {
    public static void main(String[] args) {
        
        Terrestre bicicleta = new Terrestre(4);
        Acuatico sonarBuceador = new Acuatico(3);
        Aereo coheteCasero = new Aereo(0);

        Coche ferrari = new Coche(true);
        Moto mk700 = new Moto("Combinado de fresón");
        Barco grandLine = new Barco(false);
        Submarino oppenhimer = new Submarino(2000);
        Avion boeing500 = new Avion(5);
        Helicoptero bladestPlan = new Helicoptero(3);

        Vehiculo[] vehiculos = {bicicleta, sonarBuceador, coheteCasero, ferrari, mk700, grandLine, oppenhimer, boeing500, bladestPlan};

        listarVehiculos(vehiculos);

    }

    private static void listarVehiculos(Vehiculo[] vehiculos) {

        introducirModelos();
        introducirMatriculas();
        
        System.out.println("Listado actual de los vehículos: ");
        Terrestre.imprimir();
        Acuatico.imprimir();
        Aereo.imprimir();
        Coche.imprimir();
        Moto.imprimir();
        Barco.imprimir();
        Submarino.imprimir();
        Avion.imprimir();
        Helicoptero.imprimir();
    }

    private static void introducirModelos() {

        System.out.println("Modelo del vehículo terrestre: ");
        Terrestre.modelo = System.console().readLine();
        System.out.println("Modelo del vehículo acuático: ");
        Acuatico.modelo = System.console().readLine();
        System.out.println("Modelo del vehículo aéreo: ");
        Aereo.modelo = System.console().readLine();
        System.out.println("Modelo del coche: ");
        Coche.modelo = System.console().readLine();
        System.out.println("Modelo de la moto: ");
        Moto.modelo = System.console().readLine();
        System.out.println("Modelo del barco: ");
        Barco.modelo = System.console().readLine();
        System.out.println("Modelo del submarino: ");
        Submarino.modelo = System.console().readLine();
        System.out.println("Modelo del avión: ");
        Avion.modelo = System.console().readLine();
        System.out.println("Modelo del helicóptero: ");
        Helicoptero.modelo = System.console().readLine();
    }

    private static void introducirMatriculas() {

        System.out.println("Matrícula del vehículo terrestre: ");
        Terrestre.matricula = System.console().readLine();
        System.out.println("Matrícula del vehículo acuático: ");
        Acuatico.matricula = System.console().readLine();
        System.out.println("Matrícula del vehículo aéreo: ");
        Aereo.matricula = System.console().readLine();
        System.out.println("Matrícula del coche: ");
        Coche.matricula = System.console().readLine();
        System.out.println("Matrícula de la moto: ");
        Moto.matricula = System.console().readLine();
        System.out.println("Matrícula del barco: ");
        Barco.matricula = System.console().readLine();
        System.out.println("Matrícula del submarino: ");
        Submarino.matricula = System.console().readLine();
        System.out.println("Matrícula del avión: ");
        Avion.matricula = System.console().readLine();
        System.out.println("Matrícula del helicóptero: ");
        Helicoptero.matricula = System.console().readLine();
    }
}