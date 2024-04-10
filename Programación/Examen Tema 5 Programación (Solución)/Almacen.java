import java.util.Scanner;

public class Almacen {

    private Camiseta[] articulos = new Camiseta[100];

    public void listarArticulos() {

        System.out.println("Listado de los artículos:");
        System.out.println("Código\tDescripción\tStock (S/M/L)");

        for (Camiseta camiseta : articulos) {
            if (camiseta != null) {
                System.out.println(camiseta.toString());

            }
        }

        System.out.println("El total de las camisetas es " + Camiseta.totalCamisetas);

    }

    public void altaArticulo() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el código del artículo (entre 0 y 99): ");
        int codigo = scanner.nextInt();

        if (articulos[codigo] != null) {
            System.out.println("El código de algún artículo ya está en uso.");
            return;

        }

        scanner.nextLine();

        System.out.print("Introduzca la descripción del artículo: ");
        String descripcion = scanner.nextLine();

        System.out.print("Introduzca el stock para la talla 'S': ");
        int stockS = scanner.nextInt();

        System.out.print("Introduzca el stock para la talla 'M': ");
        int stockM = scanner.nextInt();

        System.out.print("Introduzca el stock para la talla 'L': ");
        int stockL = scanner.nextInt();

        articulos[codigo] = new Camiseta(codigo, descripcion, stockS, stockM, stockL);

    }

    public void bajaArticulo() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el código del artículo a dar de baja: ");
        int codigo = scanner.nextInt();

        if (articulos[codigo] == null) {
            System.out.println("Dicho código no existe dentro del almacén.");
            return;

        }
        Camiseta camiseta = articulos[codigo];
        articulos[codigo] = null;
        Camiseta.totalCamisetas -= camiseta.totalCamisetas;

        System.out.println("El artículo ha sido dado de baja correctamente.");

    }

    public void buscarArticuloPorDescripcion() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca la descripción del artículo a buscar: ");
        String descripcion = scanner.nextLine();

        System.out.println("Los artículos encontrados son:");

        for (Camiseta camiseta : articulos) {
            if (camiseta != null && camiseta.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                System.out.println(camiseta.toString());

            }
        }
    }

    public void modificacionArticulo() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el código del artículo a modificar: ");
        int codigo = scanner.nextInt();

        if (articulos[codigo] == null) {
            System.out.println("Dicho código no existe dentro del almacén.");
            return;

        }

        Camiseta camiseta = articulos[codigo];

        System.out.println("El artículo actual es " + camiseta.toString());
        scanner.nextLine();

        System.out.print("Introduzca su nueva descripción (déjalo en blanco para mantenerla): ");
        String nuevaDescripcion = scanner.nextLine();

        if (!nuevaDescripcion.isEmpty()) {
            camiseta.descripcion = nuevaDescripcion;

        }

        System.out.print("Introduzca su nuevo stock para la talla S (" + camiseta.getStockS() + "): ");
        int nuevoStockS = scanner.nextInt();

        camiseta.actualizarStock("S", nuevoStockS - camiseta.getStockS());

        System.out.print("Introduzca su nuevo stock para la talla M (" + camiseta.getStockM() + "): ");
        int nuevoStockM = scanner.nextInt();

        camiseta.actualizarStock("M", nuevoStockM - camiseta.getStockM());

        System.out.print("Introduzca su nuevo stock para la talla L (" + camiseta.getStockL() + "): ");
        int nuevoStockL = scanner.nextInt();

        camiseta.actualizarStock("L", nuevoStockL - camiseta.getStockL());

        System.out.println("El artículo ha sido modificado correctamente.");

    }

    public void menu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n-->>> MENU DAWSHIRTS <<<--");
            System.out.println("1. Listado de artículos");
            System.out.println("2. Alta de artículo");
            System.out.println("3. Baja de artículo");
            System.out.println("4. Búsqueda de un artículo por descripción");
            System.out.println("5. Modificación de un artículo");
            System.out.println("6. Salir");

            System.out.print("Selecciona una opción (de 1 a 6): ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listarArticulos();
                    break;

                case 2:
                    altaArticulo();
                    break;

                case 3:
                    bajaArticulo();
                    break;

                case 4:
                    buscarArticuloPorDescripcion();
                    break;

                case 5:
                    modificacionArticulo();
                    break;

                case 6:
                    System.out.println("Gracias por su paciencia. Adiós.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Dicha opción no es válida. Por favor, selecciona una opción que sea válida: ");
                    break;

            }
        }
    }

    public static void main(String[] args) {

        Almacen almacen = new Almacen();

        almacen.articulos[0] = new Camiseta(0, "Camiseta roja", 10, 20, 15);
        almacen.articulos[1] = new Camiseta(1, "Camiseta azul", 15, 10, 20);
        almacen.articulos[2] = new Camiseta(2, "Camiseta verde", 5, 5, 5);
        almacen.articulos[3] = new Camiseta(3, "Camiseta amarilla", 0, 0, 0);
        almacen.articulos[4] = new Camiseta(4, "Camiseta negra", 30, 30, 30);

        almacen.menu();

    }
}