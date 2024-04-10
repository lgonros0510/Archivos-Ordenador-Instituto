// @author Lucía González Rosas

// En este programa crearemos un menú que muestre 6 opciones (una para pedir el radio, otras
// 3 para calcular la circunferencia, el área y el volumen de una esfera y una última para
// salir del programa), las cuales primero se mostrarán por pantalla para, luego, seleccionarlas
// por teclado

package geometria;

import java.util.Scanner;

public class Geometria {
	
	static double radio;
	static int opcion;
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		do { // Bucle 'do-while' que muestra que se hará que 'static int opcion' sea igual al menú
			// y que 'private static void irAOpcion(int opcion)' se base en las distintas opciones
			// de dicho menú mientras 'static int opcion' no sea igual que 5
			
			opcion = menu();
			irAOpcion(opcion);
            
        } while (opcion != 5);
		
		System.out.println("El resultado de la opción elegida es " + opcion); // Se muestra por
		// pantalla el resultado de la opción elegida
		
	}
	
	private static int menu() { 
		System.out.println("0. Radio"); // Se muestra por pantalla la opción del radio
		System.out.println("1. Circunferencia"); // Se muestra por pantalla la opción de la circunferencia
		System.out.println("2. Área"); // Se muestra por pantalla la opción del área
		System.out.println("3. Volumen"); // Se muestra por pantalla la opción del volumen
		System.out.println("4. Todas"); // Se muestra por pantalla la opción para todos los cálculos
		System.out.println("5. Salir"); // Se muestra la opción para salir del programa
		
		System.out.println("Introduzca la opción:"); // Se pide por teclado la opción
		opcion = scanner.nextInt(); // @param 'static int opcion' representa la opción a elegir
		return opcion; // @return representa la devuelta de la opción para hacer un bucle hasta que salga la
		// opción 5 (Salir)
	}

	private static void irAOpcion(int opcion) {
		
		switch (opcion) { // Bucle 'switch' wue muestra que, según del caso 0 al caso 5, se realizará una de
		// entre las 6 opciones del menú
		
        case 0:
        	pedirRadio();
            break;
        case 1:
        	System.out.println("La longitud de la circunferencia es de " + Circunferencia(radio) + " cm");
            break;
        case 2:
        	System.out.println("El área de la esfera es de " + Area(radio) + " cm²");
            break;
        case 3:
        	System.out.println("El volumen de la esfera es de " + Volumen(radio) + " cm³");
        	break;
        case 4:
        	Todas();
        	break;
        case 5:
        	Salir();
        	break;
        default: // En caso de que se escriba una opción diferente a las mostradas por pantalla, se mostrará
        	// un mensaje que nos pide que volvamos a escribir la opción entre las mostradas anteriormente
            System.out.println("Dicha opción no es válida. Introduzca otra, por favor.");
            
        }
	}
	
	// En esta función, se escanéa el radio que afectará a todo el programa y se devuelve

	public static double pedirRadio() {
	
		System.out.println("Introduzca el radio, por favor:");
		radio = scanner.nextDouble();
		return radio;
		
	}
	
	// En esta función, se devuelve el resultado de la operación para sacar la longitud de la circunferencia
	
	public static double Circunferencia(double radio) {
		 return 2 * Math.PI * radio;
		
	}
	
	// En esta función, se devuelve el resultado de la operación para sacar el área de la esfera
	
	public static double Area(double radio) {
		return Math.PI * Math.pow(radio, 2);
		
	}
	
	// En esta función, se devuelve el resultado de la operación para sacar el volumen de la esfera
	
	public static double Volumen(double radio) {
		return (4/3) * Math.PI * Math.pow(radio, 3);
		
	}
	
	// En esta función, se devuelven los resultados de las 3 opciones de cálculo del menú
	
	public static void Todas() {
		System.out.println("La longitud de la circunferencia es de " + Circunferencia(radio) + " cm");
		System.out.println("El área de la esfera es de " + Area(radio) + " cm²");
		System.out.println("El volumen de la esfera es de " + Volumen(radio) + " cm³");
		
	}
	
	// En esta función, mientras no se escriba la opción 5 (Salir), se repetirá el menú; si se escribe
	// dicha opción (que es igual a 5), se saldrá del bucle y se finalizará el programa
	
	public static void Salir() {
		boolean salir = false;
		
		if (opcion == 5) {
			salir = true;
			
		}
		
	}
}

