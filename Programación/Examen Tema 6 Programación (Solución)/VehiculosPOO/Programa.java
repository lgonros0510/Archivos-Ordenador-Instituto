package VehiculosPOO;

public class Programa {
    public static void main(String[] args) {

        Coche coche = new Coche("1234ABC", "Toyota", 4, true);
        Moto moto = new Moto("5678DEF", "Honda", 2, "Rojo");
        Barco barco = new Barco("ABCDE", "Yate", 20.5, true);
        Submarino submarino = new Submarino("FGHIJ", "Sub", 30.2, 500);
        Avion avion = new Avion("ABCD1234", "Boeing", 300, 10);
        Helicoptero helicoptero = new Helicoptero("EFGH5678", "Apache", 6, 4);

        coche.imprimir();
        moto.imprimir();
        barco.imprimir();
        submarino.imprimir();
        avion.imprimir();
        helicoptero.imprimir();

    }
}