/* @author Lucía González Rosas */

/* En este programa crearemos una especie de cajero automático donde,
 * dependiendo de la opción que elijamos, se realizará una acción u otra,
 * como depositar o retirar dinero, cambiar el idioma, etc.
*/

public class Cajero2 {

   static String operacion1 = "";
   static String operacion2 = "";
   static String operacion3 = "";
   static String operacion4 = "";
   static String operacion5 = "";

  /* Esta función forma la estructura interna del menú, junto con sus 
   * sentencias generales para todas las demás funciones.
  */
   public static void main(String[] args) { 

       int saldo = 1000;
       int nuevoSaldo = 1000;
       String idioma = "es";
       String operacion = "";
       int opcion;

       do {

           imprimirMenu(idioma);
           opcion = leerOpcion(idioma);

           switch (opcion) {
               case 1:
                   operacion = "Depósito";
                   nuevoSaldo = Depositar(saldo, idioma);
                   break;

               case 2:
                   operacion = "Retiro";
                   nuevoSaldo = retirar(saldo, idioma);
                   break;

               case 3:
                   imprimirSaldo(saldo, idioma);
                   break;

               case 4:
                   operacion = "Bizum";
                   nuevoSaldo = enviarBizum(saldo, idioma);
                   break;

               case 5:
                   ultimasOperaciones(idioma);
                   break;

               case 6:
                   idioma = (idioma == "es" ? "en" : "es");

           }

           if (nuevoSaldo != saldo) {
               grabarOperacion(operacion, nuevoSaldo - saldo);

           }

           saldo = nuevoSaldo;

       } while (opcion != 7);
   }

   /* En esta función se imprime el menú por pantalla según el idioma que
    * elijamos en la opción '6'
    * 
    * @param idioma: Ya sea en inglés (en) o en español (es), determina el
    * texto que se muestra por pantalla al usuario.
   */
   public static void imprimirMenu(String idioma) { 

       if (idioma == "es") {
           System.out.println();
           System.out.println("    M E N Ú ");
           System.out.println("-----------------");
           System.out.println("1 -> Depositar");
           System.out.println("2 -> Retirar");
           System.out.println("3 -> Enviar Bizum");
           System.out.println("4 -> Consultar saldo");
           System.out.println("5 -> Ultimas operaciones");
           System.out.println("6 -> Change to English");
           System.out.println("7 -> Salir");
          
       } else if (idioma == "en") {
           System.out.println();
           System.out.println("1 -> Deposit");
           System.out.println("2 -> Withdraw");
           System.out.println("3 -> Send Bizum");
           System.out.println("4 -> Check Balance");
           System.out.println("5 -> Latests operations");
           System.out.println("6 -> Cambiar a español");
           System.out.println("7 -> Exit");

       }
   }

   /* En esta función se leen las opciones que el usuario elija por
    * teclado del menú. No discrimina otras opciones diferentes a las
    * indicadas.
    *
    * Trata las excepciones al leer los enteros.
    *
    * @param idioma: Ya sea en inglés (en) o en español (es), determina el
    * texto que se muestra por pantalla al usuario.
    *
    * @return opcion: La función devuelve un entero junto con la opción
    * elegida.
    */
   public static int leerOpcion(String idioma) { 
       int opcion = 0;

       try {
           System.out.println("Elija una opción:");
           opcion = Integer.parseInt(System.console().readLine());

       } catch (Exception e) {
           System.out.println("Debe introducir un número.");

       }

       return opcion;

   }
   
   /* En esta función se creará el códice necesario para realizar la
    * acción de la opción '2' (Retirar saldo) si se elige dicha opción.
    * 
    * Trata las excepciones al leer los enteros.
    *
    * @param saldo: Se trata de nuestro saldo inicial, que irá cambiando
    * según cómo avanza el programa.
    *
    * @param idioma: Ya sea en inglés (en) o en español (es), determina el
    * texto que se muestra por pantalla al usuario.
    *
    * @return saldo: La función devuelve el saldo que hay después de dicha
    * acción.
    */
   public static int retirar(int saldo, String idioma) { 
       boolean datoValido = false;
       int retirar = 0;

       do {

           try {
               System.out.println("Introduzca la cantidad que quiera retirar:");
               retirar = Integer.parseInt(System.console().readLine());
               datoValido = true;


           } catch (Exception e) {
               System.out.println("El valor introducido es erróneo.");

           }

       } while (!datoValido);

       if (retirar < saldo && retirar < 600) {
           saldo = saldo - retirar;

       }

       imprimirSaldo(saldo, idioma);
       return saldo;

   }

   /* En esta función se creará el códice necesario para realizar la
    * acción de la opción '1' (Depositar saldo) si se elige dicha opción.
    *
    * Trata las excepciones al leer los enteros.
    * 
    * @param saldo: Se trata de nuestro saldo inicial, que irá cambiando
    * según cómo avanza el programa.
    * 
    * @param idioma: Ya sea en inglés (en) o en español (es), determina el
    * texto que se muestra por pantalla al usuario.
    *
    * @return saldo: La función devuelve el saldo que hay después de dicha
    * acción.
    */
   public static int Depositar(int saldo, String idioma) { 
       int cantidadADepositar = 0;

       do {

           try {
               System.out.print("Introduzca la cantidad que va a depositar: ");
               cantidadADepositar = Integer.parseInt(System.console().readLine());

               if (cantidadADepositar % 10 == 0) {

                   if (cantidadADepositar <= 3000) {
                       saldo = saldo + cantidadADepositar;

                   } else {
                       System.out.println("No es posible depositar una cantidad mayor a 3000€");

                   }

               } else {
                   System.out.println("No es posible depositar billetes que no sean múltiplos de 10");

               }

           } catch (Exception e) {
               System.out.println("Los valores introducidos no son válidos.");

           }

       } while (cantidadADepositar % 10 != 0);

       imprimirSaldo(saldo, idioma);
       return saldo;

   }

   /* En esta función se creará el códice necesario para realizar la
    * acción de la opción '4' (Consultar saldo) si se elige dicha opción.
    *
    * @param saldo: Se trata de nuestro saldo inicial, que irá cambiando
    * según cómo avanza el programa.
    *
    * @param idioma: Ya sea en inglés (en) o en español (es), determina el
    * texto que se muestra por pantalla al usuario.
    */
   public static void imprimirSaldo(int saldo, String idioma) { 

       System.out.println("--------------------");
       System.out.println("Saldo actual: " + saldo + " €");
       System.out.println("--------------------");
       System.console().readLine("Pulse “Enter” para volver…");
       System.out.println("");

   }

   /* En esta función se muestra y se crea el texto que nos pide pulsar
    * el botón de 'ENTER' para volver al menú según el idioma establecido.
    *
    * @param idioma: Ya sea en inglés (en) o en español (es), determina el
    * texto que se muestra por pantalla al usuario.
    */
   public static void pressEnter(String idioma) { 

       if (idioma == "es") {
           System.out.println("Pulse ENTER para volver");

       } else if (idioma == "en") {
           System.out.println("Press ENTER to continue");

       }
   }

   /* En esta función se creará el códice necesario para realizar la
    * acción de la opción '3' (Enviar Bizum) si se elige dicha opción.
    *
    * Trata las excepciones al leer los enteros.
    *
    * @param saldo: Se trata de nuestro saldo inicial, que irá cambiando
    * según cómo avanza el programa.
    *
    * @param idioma: Ya sea en inglés (en) o en español (es), determina el
    * texto que se muestra por pantalla al usuario.
    *
    * @return saldo - cantidadAEnviar: Devuelve el valor obtenido al
    * restarle nuestro saldo al que se enviará por Bizum.
    *
    * @return saldo: La función devuelve el saldo que hay después de dicha
    * acción.
    */
   public static int enviarBizum(int saldo, String idioma) { 

       System.out.println("Introduce el número que quieres enviar el dinero");

       try {

           int numTelefono = Integer.parseInt(System.console().readLine());
           
           if ((numTelefono >= 600000000 && numTelefono < 800000000) || (numTelefono >= 900000000 && numTelefono < 1000000000)) {
               System.out.println("Introduce la cantidad a enviar");
               int cantidadAEnviar = Integer.parseInt(System.console().readLine());

               if (cantidadAEnviar > saldo) {
                   System.out.println("ERROR: No tienes ese saldo en la cuenta");

               } else {

                   if (cantidadAEnviar > 200) {
                       System.out.println("ERROR: No puedes enviar más de 200€");

                   } else {
                       System.out.println("---- Operación realizada con éxito ----");

                       imprimirSaldo(saldo - cantidadAEnviar, idioma);
                       return saldo - cantidadAEnviar;

                   }
               }

           } else {
               System.out.println("No has introducido un teléfono válido");

           }

       } catch (Exception e) {
           System.out.println("ERROR: Valor introducido no válido, inténtalo de nuevo");

       }

       return saldo;
   }

   /* En esta función se grabarán las distintas acciones y sus resultados
    * en una serie de líneas que, posteriormente, formarán parte de la
    * última opción.
    *
    * @param operacion: Describe la opción elegida por pantalla.
    *
    * @param cantidad: Describe la cantidad de saldo actual en dicha
    * opción.
    */
   public static void grabarOperacion(String operacion, int cantidad) { 
       operacion5 = operacion4;
       operacion4 = operacion3;
       operacion3 = operacion2;
       operacion2 = operacion1;
       operacion1 = String.format("%-20s%20.2f", operacion, (double) cantidad);

   }

   /* En esta función se creará el códice necesario para realizar la
    * acción de la opción '5' (Últimas operaciones) si se elige dicha
    * opción.
    *
    * @param idioma: Ya sea en inglés (en) o en español (es), determina el
    * texto que se muestra por pantalla al usuario.
    */
   public static void ultimasOperaciones(String idioma) { 
       int saldo = 0;
       System.out.println("1. " + operacion1);
       System.out.println("2. " + operacion2);
       System.out.println("3. " + operacion3);
       System.out.println("4. " + operacion4);
       System.out.println("5. " + operacion5);
       System.out.println("--------------------");

       imprimirSaldo(saldo, idioma);

   }
}




