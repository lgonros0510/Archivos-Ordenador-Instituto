/**
 * Programa que muestra la lista de personas de un equipo de desarrollo.
 * Versión 1. Sólo nombres con array unidimensional.
 * Examen UD 4. 1 DAW Programación.
 * 
 * @author Lucía González Rosas
 */

public class EquipoDesarrollo1 {

  // Lista de personas. Se han eliminado acentos para simplificar. 
  // 1 Espacio vacío, el equipo tendrá un máximo de 10 personas.
  // Se han eliminado acentos para simplificar.
  static String lista[] = {"Jorge","Eloisa","Sergio","Jose Antonio",
                           "Angel","Adrian","Pablo","Jose Luis","Guillermo",""};  
                           
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
      
      opcion = leerOpcion();
      switch(opcion) {
        case 1:
          imprimeLista(); //Imprime toda la lista de personas (id, nombre). No imprime líneas vacías.
          break;
        case 2:
          inserta(); //Inserta nombre en la primera posición libre, si hay disponible
          break;
        case 3:
          busca(); //Dada una cadena, imprime una lista de todas las personas que contengan esa cadena en nombre (ignorando mayusculas), después las que lo contengan en apellido.
          break;
        case 4:
          borra(); //Pide un ID y borra los datos de la persona con dicho ID (inserta cadenas vacías en nombre y apellido)
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
   * 1 Jorge
   * 2 Eloisa
   * ...
   * Usa función nombre(id).
  */
  private static void imprimeLista() {
    
    for (int i = 0; i < lista.length; i++) {
      System.out.println((i + 1) + " " + (nombre(i)));
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
      if (nombre(9) == "") {
        System.out.println("Introduzca el nombre que falta: ");
        lista[9] = System.console().readLine();
      }
    }

    if  (nombre(9) != "") {
      System.out.println("Este array ya está completamente lleno.");
    }
  }


  /** Función busca (opción 3 del menú)
   * Se pregunta al usuario la cadena a buscar.
   * Se imprimen todos los ids (el índice en el array + 1) y nombres 
   * que contengan la cadena buscada, en cualquier posición e ignorando mayúsculas.
   * La longitud del array puede variar.
   * Usa función nombre(id).
   */ 
  private static void busca() {
    
    System.out.println("Introduzca la posición de la persona a localizar: ");
    String persona = System.console().readLine();

    for (int i = 0; i < lista.length; i++) {
      if (nombre(9) == persona) {
        System.out.println("La posición de la persona buscada es " + lista[i]);
            
      }
    }
  }


  /** Función borra (opción 4 del menú)
   * Borra el registro con id (el índice en el array + 1) que ingrese el usuario,
   * insertando en su lugar cadena vacía "".
   */
  private static void borra() {
    
    System.out.println("introduzca el índice y la persona a borrar: ");
    String personaBorrada = System.console().readLine();

    for (int i = 0; i < lista.length; i++) {
      if (nombre(0) == personaBorrada) {
        lista[0] = "";
      }

      if (nombre(1) == personaBorrada) {
        lista[1] = "";
      }

      if (nombre(2) == personaBorrada) {
        lista[2] = "";
      }

      if (nombre(3) == personaBorrada) {
        lista[3] = "";
      }

      if (nombre(4) == personaBorrada) {
        lista[4] = "";
      }

      if (nombre(5) == personaBorrada) {
        lista[5] = "";
      }

      if (nombre(6) == personaBorrada) {
        lista[6] = "";
      }

      if (nombre(7) == personaBorrada) {
        lista[7] = "";
      }

      if (nombre(8) == personaBorrada) {
        lista[8] = "";
      }

      if (nombre(9) == personaBorrada) {
        lista[9] = "";
      }
    }
  }
  

  /** Función nombre (auxiliar de otras funciones).
   * @return Devuelve el nombre que corresponde al indice proporcionado.
  */
  private static String nombre(int indice) {
    return lista[indice];
  }


  /** Función leerOpción (auxiliar del menú).
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