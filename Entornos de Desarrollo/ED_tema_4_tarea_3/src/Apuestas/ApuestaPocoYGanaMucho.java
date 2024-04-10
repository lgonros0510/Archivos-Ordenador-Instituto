/** @author Lucía González Rosas */

/** En esta parte del programa se creará la compilación necesaria para crear
  * la clase "ApuestaPocoYGanaMucho", la cual insertará los datos del sorteo y
  * del participante, además de formar la estructura de la apuesta y determinar
  * si existe un ganador o no.
  *
  * Dicha clase buscará una apuesta pòr su nombre.
  */

package Apuestas;

import java.util.Scanner;
import java.util.Random;

public class ApuestaPocoYGanaMucho {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido a 'apuestapocoyganamucho.com!'");

        System.out.println("Por favor, ingresa tus datos para registrarte: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("NIF: ");
        String nif = scanner.nextLine();
        
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        
        scanner.nextLine(); 
        
        System.out.print("Número de tarjeta bancaria: ");
        String numeroTarjeta = scanner.nextLine();
        
        System.out.print("Nick: ");
        String nick = scanner.nextLine();
        
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        

        Participante participante = new Participante(nombre, nif, telefono, email, edad, numeroTarjeta, nick, password);
        
        if (!participante.validarRegistro()) {
            System.out.println("El registro ha fallado. Por favor, inténtalo de nuevo con datos válidos: ");
            return;
            
        }

        System.out.println("¡Registro exitoso!");

        System.out.println("Por favor, selecciona el sorteo al que desea apostar:");
        System.out.print("Nombre del sorteo: ");
        String nombreSorteo = scanner.nextLine();

        System.out.print("Cantidad a apostar: ");
        double cantidadApostar = scanner.nextDouble();

        if (cantidadApostar > participante.getSaldo()) {
            
            System.out.println("Tu saldo es insuficiente. No se puede realizar la apuesta.");
            return;
            
        }

        Random rand = new Random();
        int[] numerosApostados = new int[3];
        
        for (int i = 0; i < 3; i++) {
            numerosApostados[i] = rand.nextInt(10);
            
        }

        Apuesta apuesta = new Apuesta(participante, nombreSorteo, cantidadApostar, numerosApostados);
        System.out.println("¡La apuesta ha sido realizada con éxito!");
        
        Sorteo sorteo = new Sorteo(nombreSorteo, "Todo o nada", "08-03-2024");

        int[] numerosSorteo = sorteo.generarNumerosAleatorios();
        boolean haGanado = sorteo.comprobarGanador(apuesta, numerosSorteo);
        

        if (haGanado) {
            System.out.println("¡Felicidades, has ganado!");

            double premio = apuesta.calcularPremio(numerosSorteo);
    
            System.out.println("Tu premio es de " + premio + "€.");
            participante.aumentarSaldo(premio);

        } else {
            System.out.println("Lo siento, no has ganado esta vez.");

        }
    }
}