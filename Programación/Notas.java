public class Notas {

    static String nombres[] = {"Alberto","Bárbara","Carlos","Diana"};

    static int notas[][] = {{5,6,7,8,9},{7,7,8,9,10},{1,2,3,4,5},{6,6,8,8,9}};

    static double promedio[] = new double[nombres.length];
    public static void main(String[] args) {

        crearPromedio();
        buscarNombres();

    }

    public static void crearPromedio() {

        double suma = 0;

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas.length; j++) {
                suma += notas[i][j];

            }

            promedio[i] = (suma / notas[0].length);

            suma = 0;

        }
    }

    public static void buscarNombres() {
        
        System.out.println(" ");
        System.out.println("Inserta el nombre del alumno el cual se quiera saber sus notas y promedio actuales:  ");
        String nombre = System.console().readLine();

        boolean verificacionNombre = false;

        for (int i = 0; i < nombres.length; i++) {
            if (nombre.equalsIgnoreCase(nombres[i])) {
                verificacionNombre = true;

                System.out.println(" ");
                System.out.println("Las notas de " + nombres[i] + " son ");

                for (int j = 0; j < notas[0].length; j++) {
                    System.out.print(notas[i][j] + " ");

                }

                System.out.println("\n");
                System.out.println("El promedio del alumn@ es de " + promedio[i]);
                System.out.println(" ");

            }
        }

        if (verificacionNombre == false) {
            System.out.println("Lo sentimos; no se ha encontrado dicho alumno.");

        }
    }
}