/** @author Lucía González Rosas */

package dawcontrol;

import java.util.ArrayList;

public class DawControl {

  // Variables globales: lista de departamentos y departamento activo (por defecto el 0)
  private static Departamento departamentoActivo;
  private static ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

  public static void main(String[] args) {

    // Creamos varios departamentos
    departamentos.add(new Departamento("Diseño"));
    departamentos.add(new Departamento("Ventas"));

    departamentoActivo = departamentos.get(0);

    // Creamos varios empleados en cada departamento
    Empleado e1 = new Empleado("Jacinto Alarcón", "11111111A", 654321111);
    Empleado e2 = new Empleado("Margarita Bueno", "22222222B", 654321222);
    Empleado e3 = new Empleado("José Castillo", "33333333C", 654321333);
    Empleado e4 = new Empleado("María Durán", "44444444D", 654321444);
    Empleado e5 = new Empleado("Julián Esteve", "55555555E", 654321555);
    Empleado e6 = new Empleado("Magdalena Fuertes", "66666666F", 654321666);
    Empleado e7 = new Empleado("Jorge González", "77777777G", 654321777);
    Empleado e8 = new Empleado("Mila Hurtado", "88888888H", 654321888);

    // Añadimos empleados a los departamentos
    departamentos.get(0).añadirEmpleado(e1);
    departamentos.get(0).añadirEmpleado(e2);
    departamentos.get(0).añadirEmpleado(e3);
    departamentos.get(0).añadirEmpleado(e4);
    departamentos.get(1).añadirEmpleado(e5);
    departamentos.get(1).añadirEmpleado(e6);
    departamentos.get(1).añadirEmpleado(e7);
    departamentos.get(1).añadirEmpleado(e8);

    // Creamos varios ordenadores
    Ordenador o1 = new Ordenador("PC01", "Windows", 4, 1);
    Ordenador o2 = new Ordenador("PC02", "Windows", 4, 2);
    Ordenador o3 = new Ordenador("PC03", "Windows", 8, 4);
    Ordenador o4 = new Ordenador("PC04", "Linux", 4, 2);
    Ordenador o5 = new Ordenador("PC05", "Linux", 4, 1);
    Ordenador o6 = new Ordenador("PC06", "Windows", 4, 2);
    Ordenador o7 = new Ordenador("PC07", "Linux", 16, 6);
    Ordenador o8 = new Ordenador("PC08", "Linux", 16, 4);
    Ordenador o9 = new Ordenador("PC09", "Linux", 2, 1);
    Ordenador o10 = new Ordenador("PC10", "Windows", 4, 2);
    Ordenador o11 = new Ordenador("PC11", "Windows", 4, 2);
    Ordenador o12 = new Ordenador("PC12", "Windows", 4, 2);

    // Añadimos ordenadores a los departamentos
    departamentos.get(0).añadirOrdenador(o1);
    departamentos.get(0).añadirOrdenador(o2);
    departamentos.get(0).añadirOrdenador(o3);
    departamentos.get(0).añadirOrdenador(o4);
    departamentos.get(0).añadirOrdenador(o5);
    departamentos.get(0).añadirOrdenador(o6);
    departamentos.get(1).añadirOrdenador(o7);
    departamentos.get(1).añadirOrdenador(o8);
    departamentos.get(1).añadirOrdenador(o9);
    departamentos.get(1).añadirOrdenador(o10);
    departamentos.get(1).añadirOrdenador(o11);
    departamentos.get(1).añadirOrdenador(o12);

    // Asignamos los ordenadores a empleados. No se pasan objetos, sino orden en la
    // lista del departamento.
    departamentos.get(0).asignarOrdenador(1, 1);
    departamentos.get(0).asignarOrdenador(2, 2);
    departamentos.get(0).asignarOrdenador(3, 3);
    departamentos.get(0).asignarOrdenador(4, 4);
    departamentos.get(1).asignarOrdenador(1, 1);
    departamentos.get(1).asignarOrdenador(2, 2);
    departamentos.get(1).asignarOrdenador(3, 3);
    departamentos.get(1).asignarOrdenador(4, 4);

    // Los ordenadores que no se han asignado quedan libres (estado = Estado.LIBRE)

    // Arranca el menú
    menuPrincipal();
  }

  // -------------------------------------------------------------
  // MENÚ PRINCIPAL
  // -------------------------------------------------------------
  public static void menuPrincipal() {
    int opcion;
    do {
      System.out.println("\n\n");
      System.out.println("DEPARTAMENTO: " + departamentoActivo);
      System.out.println();
      System.out.println("1. Cambiar de departamento");
      System.out.println("2. Opciones empleados");
      System.out.println("3. Opciones ordenadores");
      System.out.println("4. Asignar ordenador");
      System.out.println("0. Salir");
      System.out.println();

      opcion = leerOpcion();
      switch (opcion) {
        case 1:
          cambiarDepartamento();
          break;
        case 2:
          menuEmpleados();
          break;
        case 3:
          menuOrdenadores();
          break;
        case 4:
          asignarOrdenador();
          break;
        default:
          System.out.println("Opción no válida");
      }
    } while (opcion != 0);
  }


  // -------------------------------------------------------------
  // SUBMENU Empleados
  // -------------------------------------------------------------
  public static void menuEmpleados() {
    int opcion;
    do {
      System.out.println("\n");
      System.out.println("DEPARTAMENTO: " + departamentoActivo);
      System.out.println();
      System.out.println("1. Lista de empleados");
      System.out.println("2. Crear empleado");
      System.out.println("3. Eliminar empleado");
      System.out.println("0. Salir");
      System.out.println();

      opcion = leerOpcion();
      switch (opcion) {
        case 1:
          departamentoActivo.imprimirListaEmpleados();
          break;
        case 2:
          crearEmpleado();
          break;
        case 3:
          eliminarEmpleado();
          break;
        default:
          System.out.println("Opción no válida");
      }
    } while (opcion != 0);
  }


  // -------------------------------------------------------------
  // SUBMENU Ordenadores
  // -------------------------------------------------------------
  public static void menuOrdenadores() {
    int opcion;
    do {

      System.out.println("DEPARTAMENTO: " + departamentoActivo);
      System.out.println();
      System.out.println("1. Lista de ordenadores");
      System.out.println("2. Crear ordenador");
      System.out.println("3. Dar de baja ordenador");
      System.out.println("4. Eliminar todos los ordenadores de baja");
      System.out.println("0. Salir");
      System.out.println();

      opcion = leerOpcion();
      switch (opcion) {
        case 1:
          departamentoActivo.imprimirListaOrdenadores();
          break;
        case 2:
          crearOrdenador();
          break;
        case 3:
          bajaOrdenador();
          break;
        case 4:
          departamentoActivo.eliminarOrdenadoresBaja();
          break;
        default:
          System.out.println("Opción no válida");
      }
    } while (opcion != 0);
  }

  // --------------------------------------------------------------------
  // Lee opción numérica del teclado
  // --------------------------------------------------------------------
  public static int leerOpcion() {
    int opcion = 0;
    try {
      opcion = Integer.parseInt(System.console().readLine());
    } catch (Exception e) {
      System.out.println("ERROR: Introduzca un número, por favor.");
    }
    return opcion;
  }


  // --------------------------------------------------------------------
  // Función que permite cambiar el departamento activo
  // --------------------------------------------------------------------
  public static void cambiarDepartamento() {
    for (int i = 1; i <= departamentos.size(); i++) {
      System.out.println(i + ". " + departamentos.get(i - 1).getNombre() + ": "
          + departamentos.get(i - 1).totalEmpleados() + " empleados, " + departamentos.get(i - 1).totalOrdenadores()
          + " ordenadores");
    }
    System.out.println();
    System.out.print("Elija departamento: ");
    int opcion = leerOpcion();
    if (opcion >= 1 && opcion <= departamentos.size()) {
      departamentoActivo = departamentos.get(opcion - 1);
    }
  }


  // --------------------------------------------------------------------
  // Función que permite asignar un ordenador a un empleado
  // Imprime lista de empleados y se elige el número de empleado
  // Imprime lista de ordenadores y se elige el número de ordenador
  // Se pasan ambos números como parámetro al método asignarOrdenador del departamento
  // --------------------------------------------------------------------
  public static void asignarOrdenador() {
    departamentoActivo.imprimirListaEmpleados();
    System.out.print("Elija número de empleado: ");
    int numEmpleado = leerOpcion();
    if (numEmpleado >= 1 && numEmpleado <= departamentoActivo.totalEmpleados()) {
      departamentoActivo.imprimirListaOrdenadores();
      System.out.print("Elija número de ordenador: ");
      int numOrdenador = leerOpcion();
      if (numOrdenador >= 1 && numOrdenador <= departamentoActivo.totalOrdenadores()) {
        departamentoActivo.asignarOrdenador(numEmpleado, numOrdenador);
      }
    } else {
      System.out.println("Opción no válida.");
    }
  }


  // ----------------------------------------------------------------------------------
  // Función que pide los datos para crear un nuevo empleado en el departamento activo
  // ----------------------------------------------------------------------------------
  public static void crearEmpleado() {
    try {
      String nombre = System.console().readLine("Introduzca nombre: ");
      String dni = System.console().readLine("Introduzca DNI: ");
      int telefono = Integer.parseInt(System.console().readLine("Introduzca teléfono: "));
      Empleado nuevoEmpleado = new Empleado(nombre, dni, telefono);
      departamentoActivo.añadirEmpleado(nuevoEmpleado);
      System.out.println("Empleado creado");
    } catch (Exception e) {
      System.out.println("Debe ser un número");
    }
  }


  // ----------------------------------------------------------------------------------
  // Función que elimina un empleado de la lista
  // ----------------------------------------------------------------------------------
  public static void eliminarEmpleado() {
    departamentoActivo.imprimirListaEmpleados();
    System.out.print("Elija número de empleado: ");
    int numEmpleado = leerOpcion();
    if (numEmpleado >= 1 && numEmpleado <= departamentoActivo.totalEmpleados()) {
      departamentoActivo.añadirEmpleado(numEmpleado);
      System.out.println("Empleado eliminado");
    } else {
      System.out.println("Opción no válida");
    }
  }


  // ----------------------------------------------------------------------------------
  // Función que pide los datos para crear un nuevo ordenador en el departamento activo
  // ----------------------------------------------------------------------------------  
  public static void crearOrdenador() {
    try {
      String host = System.console().readLine("Introduzca host: ");
      String so = System.console().readLine("Introduzca Sistema Operativo: ");
      int ram = Integer.parseInt(System.console().readLine("Introduzca RAM (GB): "));
      int disco = Integer.parseInt(System.console().readLine("Introduzca Disco Duro (TB): "));
      Ordenador nuevoOrdenador = new Ordenador(host, so, ram, disco);
      departamentoActivo.añadirOrdenador(nuevoOrdenador);
      System.out.println("Ordenador creado");
    } catch (Exception e) {
      System.out.println("Debe ser un número");
    }
  }


  // ----------------------------------------------------------------------------------
  // Función que da de baja un ordenador en la lista del departamento
  // No lo elimina, sólo le cambia el estado a BAJA
  // ----------------------------------------------------------------------------------
  public static void bajaOrdenador() {
    departamentoActivo.imprimirListaOrdenadores();
    System.out.print("Elija número de ordenador: ");
    int numOrdenador = leerOpcion();
    if (numOrdenador >= 1 && numOrdenador <= departamentoActivo.totalOrdenadores()) {
      departamentoActivo.bajaOrdenador(numOrdenador);
      System.out.println("Ordenador dado de baja");
    } else {
      System.out.println("Opción no válida");
    }
  }

}
