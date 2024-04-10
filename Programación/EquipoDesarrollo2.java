/**
 * Programa que muestra la lista de personas de un equipo de desarrollo.
 * Versión 2. Nombres y apellidos con array bidimensional.
 * Examen UD 4. 1 DAW Programación.
 * 
 * @author Lucía González Rosas
 */

public class EquipoDesarrollo2 {

  // Lista de personas. Se han eliminado acentos para simplificar. 
  // 1 Espacio vacío, el equipo tendrá un máximo de 10 personas.
  // Se han eliminado acentos para simplificar.
  static String lista[][] = { { "Eloy", "Agudo" }, 
                              { "Ana", "Castillo" },
                              { "Jaime", "Diaz" },
                              { "Enrique", "Garcia" },
                              { "Lucia", "Gonzalez" },
                              { "Fernando", "Lara" },
                              { "Daniel", "Leiva" },
                              {"Manuel", "Lopez"},
                              {"Ana", "Lopez"},
                              {"",""}};                          

  public static void main (String[] args) {
    
    int opcion;

    //Menú con opciones 1 a 4. 5 para salir.
    do {
      System.out.println("---EQUIPO DE DESARROLLO -- \n");
      System.out.println("1. Imprimir lista");
      System.out.println("2. Insertar persona");
      System.out.println("3. Buscar persona");
      System.out.println("4. Borrar persona");
      System.out.println("5. Salir\n");                  
      
      opcion=leerOpcion();
      switch(opcion) {
        case 1:
          imprimeLista(); //Imprime toda la lista de personas (id, nombre, apellido). No imprime líneas vacías.
          break;
        case 2:
          inserta(); //Inserta nombre y apellido en la primera posición libre, si hay disponible
          break;
        case 3:
          busca(); //Dada una cadena, imprime una lista de todas las personas que contengan esa cadena en nombre (ignorando mayusculas), después las que lo contengan en apellido.
          break;
        case 4:
          borra(); //Pide un índice y borra los datos de la persona en dicho índice (inserta cadenas vacías en nombre y apellido)
          break;
        case 5:
          break;
        default:
          System.out.println("Opción no válida (Pulse ENTER)"); 
          System.console().readLine();
      }
    } while (opcion != 5);
  }


  /** Función imprimeLista (opción 1 del menú) 
   * Recorre la lista e imprime todos los nombres no vacíos
   * con el id delante (el primero es 1). Ejemplo:
   * 1 Eloy Agudo
   * 2 Ana Castillo
   * ...
   * Usa función nombre(id).
  */
  private static void imprimeLista() {
    for (int i = 0; i < lista.length; i++) {
      for (int j = 0; j < lista.length; j++) {
        System.out.println((i + 1) + " " + nombre(i) + " " + apellido(j));

      }
    }
  }

  /** Función inserta (opción 2 del menú) 
   *  Busca el primer hueco disponible en la lista (nombre vacío).
   *  Si lo hay, el usuario introduce un nuevo nombre que se inserta en ese lugar.
   *  Si no lo hay, se advierte al usuario que se ha alcanzado el límite de personas en el equipo.
   *  La longitud del array puede variar.
   *  Usa función nombre(id).
   */ 
  private static void inserta() {
    for (int i = 0; i < lista.length; i++) {
      for (int j = 0; j < lista.length; j++) {
        if (nombre(9) == "" && apellido(9) == "") {
          System.out.println("Introduzca el nombre y el apellido que falta: ");
          lista[0][9] = System.console().readLine();
          lista[1][9] = System.console().readLine();
        }
      }
    }

    if  (nombre(9) != "") {
      System.out.println("Este array ya está completamente lleno.");
    }

    if  (apellido(9) != "") {
      System.out.println("Este array ya está completamente lleno.");
    }
  }


  /** Función busca (opción 3 del menú)
   * Se pregunta al usuario la cadena a buscar.
   * Se imprimen todos los ids (el índice en el array + 1), nombres y apellidos:
   * Primero los registros cuyos nombres contengan la cadena buscada, en cualquier posición e ignorando mayúsculas.
   * Después los registros cuyos apellidos contengan la cadena buscada, en cualquier posición e ignorando mayúsculas.
   * La longitud del array puede variar.
   * Usa funciones nombre(id) y apellido[id].
   */ 
  private static void busca() {

    System.out.println("Introduzca la posición de la persona a localizar: ");
    String nombrePersona = System.console().readLine();
    String apellidoPersona = System.console().readLine();

    for (int i = 0; i < lista.length; i++) {
      for (int j = 0; j < lista.length; j++) {
        if (nombre(9) == nombrePersona && apellido(9) == apellidoPersona) {
          System.out.println("La posición de la persona buscada es " + lista[i][j]);
        }
      }
    }
  }

  /** Función borra (opción 4 del menú)
   * Borra el registro con id (el índice en el array + 1) que ingrese el usuario,
   * insertando en el lugar de nombre y apellido una cadena vacía "".
   */
  private static void borra() {
    System.out.println("introduzca el índice y la persona a borrar: ");
    String personaBorrada = System.console().readLine();

    for (int i = 0; i < lista.length; i++) {
      if (nombre(0) == personaBorrada && apellido(0) == personaBorrada) {
        lista[0][0] = "";
      }

      if (nombre(1) == personaBorrada && apellido(1) == personaBorrada) {
        lista[1][1] = "";
      }

      if (nombre(2) == personaBorrada && apellido(2) == personaBorrada) {
        lista[2][2] = "";
      }

      if (nombre(3) == personaBorrada && apellido(3) == personaBorrada) {
        lista[3][3] = "";
      }

      if (nombre(4) == personaBorrada && apellido(4) == personaBorrada) {
        lista[4][4] = "";
      }

      if (nombre(5) == personaBorrada && apellido(5) == personaBorrada) {
        lista[5][5] = "";
      }

      if (nombre(6) == personaBorrada && apellido(6) == personaBorrada) {
        lista[6][6] = "";
      }

      if (nombre(7) == personaBorrada && apellido(7) == personaBorrada) {
        lista[7][7] = "";
      }

      if (nombre(8) == personaBorrada && apellido(8) == personaBorrada) {
        lista[8][8] = "";
      }

      if (nombre(9) == personaBorrada && apellido(9) == personaBorrada) {
        lista[9][9] = "";
      }
    }
  }
  

  /** Función nombre (auxiliar de otras funciones).
   * @return Devuelve el nombre que corresponde al indice proporcionado.
  */
  private static String nombre(int id) {
    return lista[id];
  }


  /** Función apellido (auxiliar de otras funciones).
   * @return Devuelve el apellido que corresponde al indice proporcionado.
  */
  private static String apellido(int id) {
    return lista[id];
  }


  /** Función leerOpción 
   * @return Devuelve la opción leída por teclado, o 99 si no es número.
   * Completa, NO TOCAR
  */
  private static int leerOpcion() {
    try {
      return Integer.parseInt(System.console().readLine());
    } catch (Exception e) {
      return 99;
    }
  }
}