/**
 * Juego de aventuras creado con funciones
 * 
 * @author Lucía González
 * @author Eloisa Martínez
 */

public class WolfTale {
    public static void main(String[] args) {

        // Pantalla de inicio
        pantallaPortadaJuego();

        // Primera pantalla
        pantallaInicioJuego();
    }

    /**
     * Función que muestra la portada del juego
     * 
     * @author Lucia González
     */
    public static void pantallaPortadaJuego() {

        System.out.println(" ");
        System.out.println("A Wolf's Midnight Hunt");
        System.out.println();
        System.console().readLine("Pulse ENTER para comenzar el juego.");
    }

    /**
     * Función que muestra el inicio del juego (1ª. pantalla)
     * 
     * @author Lucia González
     */
    public static void pantallaInicioJuego() {

        String pantalla = "Inicio";
        escenario(pantalla);

        System.out.println("");
        System.out.println("Te encuentras en el bosque junto con su cielo nocturno.");
        System.out.println("Eres un astuto lobo que recién se prepara para su cacería nocturna.");
        System.out.println("Atravesando el bosque, te escondes entre los matorrales.");
        System.out.println("Esperando a tu presa pacientemente, escuchas unos soniditos que te llevan a encontrarte con un conejo.");
        System.out.println(" ");
        System.out.println("¿Vas a cazarlo? (S / N)");
        System.out.println(" ");

        String respuesta1 = System.console().readLine();
        char decision1 = respuesta1.charAt(0);

        if (decision1 == 'S') {
            pantallaCazarConejo();
        } else {
            pantallaBuscarOtraPresa(decision1);
        }
    }

    /**
     * Función que se muestra si elige la primera opción
     * 
     * @author Lucia González
     */
    public static void pantallaCazarConejo() {

        String pantalla ="Conejo";
        escenario(pantalla);

        System.out.println(" ");
        System.out.println("Has decidido ir a por el conejo.");
        System.out.println();
        System.out.println("Lo persigues sin descanso hasta alcanzar una cueva, donde yace un oso durmiente.");
        System.out.println(" ");
        System.out.println("¿Lo perseguirás, sabiendo el peligro? (S / N)");
        System.out.println(" ");

        String respuesta2 = System.console().readLine();
        char decision2 = respuesta2.charAt(0);

        if (decision2 == 'S') {
            pantallaPerseguirConejo();
        } else {
            pantallaBuscarOtraPresa(decision2);
        }

    }

    /**
     * Función que se muestra si se decide seguir persiguiendo al conejo
     * 
     * @author Lucia González
     */
    public static void pantallaPerseguirConejo() {

        String pantalla = "CuevaConOso";
        escenario(pantalla);

        System.out.println(" ");
        System.out.println("Decidiste jugarte la vida, persiguiendo al conejo con el oso en la cueva.");
        System.out.println();
        System.out.println("El oso levantándose con ira por todo el ruido acosándole, decide perseguiros.");
        System.out.println("A pesar de que te supera en tamaño y fuerza, consigues divisar una salida lo suficientemente pequeña tanto para tí como para el conejo.");
        System.out.println("Con tu astucia, logras tanto tu presa como tú salir del pifostio montado.");
        System.out.println("Al salir de la cueva, cuando por fin tienes casi atrapado al susodicho conejo, ves como un águila se lo lleva con sus garras.");
        System.out.println("Con algo de desánimo por el esfuerzo y peligro anteriores, buscas otras presas..."); 
        System.out.println("Hasta que logras divisar una granja a lo lejos.");
        System.out.println(" ");
        System.out.println("¿Irás al ganado a por una presa fácil? (S / N)");
        System.out.println(" ");

        String respuesta3 = System.console().readLine();
        char decision3 = respuesta3.charAt(0);

        if (decision3 == 'S') {
            pantallaVisitaGanado();
        } else {
            pantallaBuscarOtraPresa(decision3);
        }
    }

    /**
     * Función que se muestra si se decidie ir a la granja
     * 
     * @author Lucia González
     */
    public static void pantallaVisitaGanado() {

        String pantalla = "Ganado";
        escenario(pantalla);

        System.out.println(" ");
        System.out.println("Está ya amaneciendo, y decidiste no arriesgarte más en la naturaleza y visitar la granja en busca de comida.");
        System.out.println("Tu estómago ruge de impaciencia al ver tantas ovejas tan pacíficas e indefensas delante tuya.");
        System.out.println(" ");
        System.out.println("¿Esperarás a que anochezca para cazar una? (S / N)");
        System.out.println(" ");

        String respuesta4 = System.console().readLine();
        char decision4 = respuesta4.charAt(0);

        if (decision4 == 'S') {
            pantallaEsperarNoche();
        } else {
            pantallaNoIrGranja(decision4);
        }
    }

    /**
     * Función que se muestra si se decide buscar otra presa
     * 
     * @author Eloisa Martínez
     */
    public static void pantallaBuscarOtraPresa(int opcion) {
        System.out.println();
        System.out.println("La idea de cazar al conejo, no te gusta, pero tienes mucha hambre.");
        System.out.println("Tienes que conseguir comida.");
        System.out.println();
        System.out.println("¿Qué decides hacer?");
        System.out.println();

        System.out.println("1. Ir en busca de ayuda para tener más posibilidades y comer antes.");
        System.out.println("2. Salir a cazar por tu cuenta para comer más cantidad, aunque tardes más.");
        System.out.println();
        System.out.print("Introduce la opción elegida (1 o 2): ");
        opcion = Integer.parseInt(System.console().readLine());

        if (opcion == 1) {
            pantallaCazarConAyuda(opcion);
        } else {
            pantallaCazarSolo(opcion);
        }
    }

    /**
     * Función que se muestra si se decide buscar otra presa
     * 
     * @author Eloisa Martínez
     */
    public static void pantallaNoIrGranja(int opcion) {

        System.out.println();
        System.out.println("La idea de cazar una oveja del rebaño, no te gusta.");
        System.out.println("No quieres arriesgarte a ser cazado por un granjero, pero tienes mucha hambre.");
        System.out.println("Tienes que conseguir comida.");
        System.out.println();
        System.out.println("¿Qué decides hacer?");
        System.out.println();

        System.out.println("1. Ir en busca de ayuda para tener más posibilidades y comer antes.");
        System.out.println("2. Salir a cazar por tu cuenta para comer más cantidad, aunque tardes más.");
        System.out.println();
        System.out.print("Introduce la opción elegida (1 o 2): ");
        opcion = Integer.parseInt(System.console().readLine());

        if (opcion == 1) {
            pantallaCazarConAyuda(opcion);
        } else {
            pantallaCazarSolo(opcion);
        }
    }
    
    /**
     * Función que se muestra si se decide cazar con ayuda
     * 
     * @author Eloisa Martínez
     */
    public static void pantallaCazarConAyuda(int opcion) {

        System.out.println();
        System.out.println("Has decidio pedir ayuda a otro lobo.");
        System.out.println();
        System.out.println("Los dos salís a buscar vuestra presa. Al cabo de un rato, un inocente ciervo se cruza en vuestro camino.");
        System.out.println("Ambos queréis atraparlo, pero lo mejor es decidir quién de los dos lo hace.");
        System.out.println("Para ello tendréis que elegir un número del 1 al 10.");
        System.out.println();
        System.out.println("Si la suma de ambos números es par, cazarás tú. Si es impar, lo hará tu compañero.");
        System.out.println();
        System.out.print("Elige un número del 1 al 10: ");

        int numero1 = Integer.parseInt(System.console().readLine());
        int numero2 = (int) (Math.random() * 10) + 1;

        System.out.println("El número que ha elegido tu compañero es: " + numero2);
        if (((numero1 + numero2) % 2) == 0) {
            System.out.println();
            System.out.println("La suma es par. PREPÁRATE PARA CAZAR.");
            System.out.println();
            System.console().readLine("Pulsa ENTER cuando estés preparado.");
            pantallaCazarCiervo(opcion);

        } else {
            System.out.println();
            System.out.println("La suma es impar. Sale a cazar tu compañero.");
            System.out.println();
            System.console().readLine("Pulsa ENTER para saber si ha cazado al ciervo o no.");
            pantallaNoCazar(opcion);
        }
    }

    /**
     * Función que se muestra si decide cazar solo
     * 
     * @author Eloisa Martínez
     */
    public static void pantallaCazarSolo(int opcion) {

        String caraMoneda = "";

        System.out.println();
        System.out.println("Tu ocpión ha sido salir a cazar solo.");
        System.out.println();
        System.out.println("Al cabo de un buen rato, un inocente ciervo se cruza en tu camino, pero este se mete por un laberinto.");
                
        System.out.println("Este laberinto tiene dos caminos. No sabes cuál elegir.");
        System.out.println("Para solucionarlo, decides lanzar una moneda que encuentras en el suelo.");
        System.out.println("Si sale cara, irás por el camino de la derecha. Si sale cruz, irás por el de la izquierda.");
        System.out.println();
        System.console().readLine("Pulsa ENTER para lanzar la moneda.");

        int moneda = (int) (Math.random() * 2) + 1;

        switch (moneda) {
            case 1:
                caraMoneda = "Cara";
                System.out.println();
                System.out.println("Ha salido " + caraMoneda + ". Irás por el camino de la derecha.");
                System.out.println();
                System.console().readLine("Pulsa ENTER para saber si has conseguido cazar al ciervo o no.");
                pantallaCazarCiervo(opcion);
                break;
            case 2:
                caraMoneda = "Cruz";
                System.out.println();
                System.out.println("Ha salido " + caraMoneda + ". Irás por el camino de la izquierda.");
                System.out.println();
                System.console().readLine("Pulsa ENTER para saber si has conseguido cazar al ciervo o no.");
                pantallaNoCazar(opcion);
            default:
                break;
        }
    }

    /**
     * Función que se muestra si sale par o camino de la derecha
     * 
     * @author Eloisa Martínez
     */
    public static void pantallaCazarCiervo(int opcion) {

        System.out.println();
        System.out.println("¡ENHORABUENA!. Has conseguido cazar al ciervo, y no pasarás hambre hoy.");
    }

    /**
     * Función que se muestra si sale impar o camino de la izquierda
     * 
     * @author Eloisa Martínez
     */
    public static void pantallaNoCazar(int opcion) {

        System.out.println();
        System.out.println("LO SIENTO, el ciervo se escapó, así que no comerás hoy.");
    }

    /**
     * Función que se muestra si se decide ir a la granja
     * 
     * @author Lucia González
     */
    public static void pantallaEsperarNoche() {

        String pantalla = "EsperaNoche";
        escenario(pantalla);

        System.out.println(" ");
        System.out.println("A pesar del hambre, decidiste tener más cerebro que estómago y esperaste hasta la noche.");
        System.out.println("Momento en que tanto las ovejas, como los humanos, duermen.");
        System.out.println();
        System.out.println("Al caer la noche, achecas a tu presa y, en un segundo, logras cazar a tu presa nocturna.");
        System.out.println("Sales de la granja triunfante aún con tu trofeo entre los caninos, volviendo a tu cueva para poder disfrutar mejor de dicho manjar.");
        pantallaFinCaceria();

    }

    /**
     * Función que se muestra si decide cazar de día
     * 
     * @author Eloisa Martínez
     */
    public static void pantallaCazarDeDia(int opcion) {

        System.out.println();
        System.out.println("La paciencia es la madre de todas las ciencias.");
        System.out.println("Siento decirte, que al no tenerla...");
        System.out.println("¡HAS SIDO CAZADO!");
    }

    /**
     * Función que muestra FIN
     * 
     * @author Lucia González
     */
    public static void pantallaFinCaceria() {

        String pantalla = "Final";
        escenario(pantalla);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    public static void escenario(String pantalla) {

        switch (pantalla) {
            case "Inicio":
                System.out.println("                                       ##                          ");
                System.out.println("                                     #####                         ");                       
                System.out.println("                                     ######                        ");                       
                System.out.println("                                    #########                      ");                     
                System.out.println("                                 #############                     ");           
                System.out.println("                                  #############                    ");                   
                System.out.println("                                     ##########                    ");                  
                System.out.println("                             ###################                   ");                
                System.out.println("                           ####################                    ");                  
                System.out.println("                         ######################                    ");                  
                System.out.println("                        #######################                    ");                  
                System.out.println("                       #######################                     ");               
                System.out.println("                     #############  #########                      ");                   
                System.out.println("                  ###############    #### ###                      ");                    
                System.out.println("                ######   ########    ###  ###                      ");                   
                System.out.println("               ###       ##  ###     ###  ##                       ");
                System.out.println("                        ##  ###       ##  ##                       ");
                System.out.println("                        ## ###        ##  ##                       ");                    
                System.out.println("                        ##  ##       ###  ##                       ");                    
                System.out.println("       ########         ### *#*       ##   #                       ");                    
                System.out.println("        ################################## ###                     ");                  
                System.out.println("        #######################################                    ");
                System.out.println("           ########################################                ");                
                System.out.println("               ########################################            ");             
                System.out.println("                   #     ####    ###########  *     *#             ");
                break;

            case "Conejo":
                System.out.println("                                    @@  @@@         ");  
                System.out.println("                                      @@@@ @@@@     ");
                System.out.println("                                      @@@@@@@@@     ");
                System.out.println("                                      @@@@@@@@      ");
                System.out.println("                                       @@@@@@       ");
                System.out.println("                                       @@@@@@@@@    ");
                System.out.println("                                      @@@@@@@@@@@@  ");
                System.out.println("                 @@@@@@@@@@@@@@@@@   @@@@@@@@@@@@@@ ");
                System.out.println("             @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("          @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("         @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
                System.out.println(" @@@@  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     ");
                System.out.println(" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@      ");
                System.out.println(" @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       ");
                System.out.println("  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@        ");
                System.out.println("   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@          ");
                System.out.println("  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@            ");
                System.out.println("  @@@@@@@@@@@@@@@@@@@@@@@@@    @@@@@@@@@            ");
                System.out.println("  @@@@   @@@@@@@@@@@           @@@@  @@@@           ");
                System.out.println("  @@@@    @@@@@@@@@@@@@@        @@@@@@@@@@          ");
                System.out.println("  @@@@@@@       @@@@@@@@@          @@@@@@@@@@       ");
                System.out.println("  @@@@@@@@                               @@@@@@     ");
                break;

            case "CuevaConOso":
                System.out.println(".......................................................*%%##################%*.......................................................");
                System.out.println("...............................................%#####################################%...............................................");
                System.out.println("..........................................#################################################..........................................");
                System.out.println(".....................................*##########################################################.....................................");
                System.out.println("..................................%###############################################################%..................................");
                System.out.println("...............................##################################.###################################%...............................");
                System.out.println("............................%###################################%.%#######......########################%............................");
                System.out.println("..........................##################################%###...#####..........#########################..........................");
                System.out.println("........................#############################..%###%.###...###%............##########################........................");
                System.out.println("......................#########################.%###....###..##....##+..............###########################......................");
                System.out.println("....................######################.%##%..##@....@##..%#....#%................############################....................");
                System.out.println("..................%#######################..##+..%#......#%...@....#.................####%.#######################%..................");
                System.out.println(".................########################%..%#....#......#............................###..#####.@##################.................");
                System.out.println("...............%####################...%#....#....:.....%#####%=......................###..%###....##################%...............");
                System.out.println("..............######################....#....%.....%#############.....................%#%...##.....%###################..............");
                System.out.println(".............##################..##:.........=#####################....................#=...##......####################.............");
                System.out.println("...........####################..@#........%#########################-.................#....@.......######################...........");
                System.out.println("..........@###################%...#....%################################...............%.............#....################@..........");
                System.out.println(".........@#################%##....%..#####################################.............:...................@###############@.........");
                System.out.println("........%################...##.......########################################...............................################%........");
                System.out.println("........###############@....#%......#########################################................................################........");
                System.out.println(".......###############%.....%.......##########################################................................################.......");
                System.out.println("......################......%.......##########################################................................#################......");
                System.out.println(".....#################......#.......##########################################.................................#################.....");
                System.out.println(".....#################......:.......%##########################################.................................################.....");
                System.out.println("....###############=@%.............##################################....%#.....................................#################....");
                System.out.println("...################..%...........#############%.###########....#######...........................................################*...");
                System.out.println("...################..*..........##############.....######%.......######*.........................................#################...");
                System.out.println("..*################..............####...#####-.....#####*...........#####=........................................################*..");
                System.out.println("..#################...............####...####......#####..............%%##........................................#################..");
                System.out.println("..#################################################################################################################################..");
                System.out.println(".@#################################################################################################################################%.");
                System.out.println(".###################################################################################################################################.");
                System.out.println(".###################################################################################################################################.");
                break;
                
            case "EscaparOso":
                System.out.println("                                                                                                      @@@@@@@@                                                       ");
                System.out.println("                                                                                                        @@@@@@@@@@@@@@@                                              ");
                System.out.println("                                                                                                          @@@@@@@@@@@@@@                                             ");
                System.out.println("                                                                                                #@@@@@@@@@@@@@@@@@@@@@@@@                                            ");
                System.out.println("                                                               @@@@@@@@@@@@@                   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                                      ");
                System.out.println("                                                        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@#    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                                     ");
                System.out.println("             @@@@@@                              @@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       @@                                        ");
                System.out.println("              .@@@@@@@@@@@@@           @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                                              ");
                System.out.println("                @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  @@@@@@@@@@@@@@@  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@         @@@                                           ");
                System.out.println("                  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  @@@@@@@@@@@@@@@@@@   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                                                         ");
                System.out.println("                    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    @@@@@@@@@@@@@@@@@@@@  #@@@@@@@@@@@@@@@@@@@@@@@@@@@@                                                           ");
                System.out.println("                       @@@@@@@@@@@@@@@@@@@@@@@@@       @@@@@@@@@@@@@@@@@@@@   @@@@@@@ @@@@@@@@@@@@@@@@@@                                                             ");
                System.out.println("                           @@@@@@@@@@@@@@@@@           @@@@@@@@@@@@@@@@@@@   @@@@@@  @@@@@@@@@@@@@@@@@                                                               ");
                System.out.println("                                                        @@@@@@@@@@@@@@@@           @@@@@@@@@@@@@@@@@                                                                 ");
                System.out.println("                                                         @@@@@@@@@@@              @@@@@@@@@@@@@@                                                                     ");
                System.out.println("                                                           @@@@@@                @@@@@@@@@@@                                                                         ");
                System.out.println("                                                            @@@@@               @@@@@@@@@    @@@@@@                                                                  ");
                System.out.println("                                                             @@@@@              @@@@@@     @@@@@@@@@@                                                                ");
                System.out.println("                                                                @@@          @@@@@@@             @@@@@                                                               ");
                System.out.println("                                                                  @@        @@@@@@               @@@@                                                                ");
                System.out.println("                                                                  @@@@     @@@@@             @@@@                                                                    ");
                System.out.println("                                                                    @@@   @@@@         @@@@@@                                                                        ");
                System.out.println("                                                                         @@@                                                                                         ");
                System.out.println("                                                                        @@                                                                                           ");
                System.out.println("                                                                      @@@                                                                                            ");
                System.out.println("                                                                      @@*                                                                                            ");
                System.out.println("                                                                      @@@                                                                                            ");
                break;

            case "Ganado":
                System.out.println("======================================================================######====================================================================\n" + //
                        "=======================================================================#####====================================================================\n" + //
                        "===============================================================######========######=============================================================\n" + //
                        "================================================================######======######==============================================================\n" + //
                        "===================================================#######=======###==========###===============================================================\n" + //
                        "===========================================================####=====#=#====#=#=====####==##*+===================================================\n" + //
                        "==========================================================*####======#=####=#======#####========================================================\n" + //
                        "==================================================================#*==##===#===#================================================================\n" + //
                        "==================================================================*==########==#================================================================\n" + //
                        "==========================================================#####===##############===#####========================================================\n" + //
                        "===========================================================####==################==####=========================================================\n" + //
                        "=================================#####==========================##################==============================================================\n" + //
                        "============================###############*===================####################==========#==================================================\n" + //
                        "=========================####=============+###=========#=======##=#################=======+#####======#########=================================\n" + //
                        "=======================###===================###=======#=======##=#################=====###==####==###=========###*=============================\n" + //
                        "======================##=============#===========######========##=#################==###==####=####===============###===========================\n" + //
                        "=====================##============#===========###==#==####====##=###################+=########*=###================##==========================\n" + //
                        "====================*========================###==######==####=##=#########*#######====##########==###==========================================\n" + //
                        "===================#########===============###==############==###=#########=#######====####=#=#==##==###=========#=======###====================\n" + //
                        "================###===========#==========###==###################==#=######=#######====###=##=########=##=====*=============##==================\n" + //
                        "==============##========================##==#####====####################===#######====###=##=##=#####========================##================\n" + //
                        "=============#=========================##=######=#####=############################====#####===+######==========================#===============\n" + //
                        "============#=========================##=######=######=#############=========######====###############==========================================\n" + //
                        "=====================================###=#######==##*=##############=###=###=######====######*#####=##===========================#==============\n" + //
                        "====================================###=############################=###=###=######====############=##==========================================\n" + //
                        "===================================+##=####====#####################=###=###=######====###############=====###============##====###=============\n" + //
                        "===========#+======================##=###=##=##=#############=======================================================================##==========\n" + //
                        "======##=============================+###=##=###*#########=###############################################===========#================#=========\n" + //
                        "====##===========##==================+####==+#==#########=#################################################=========####==####=========#========\n" + //
                        "===#===========####==###==#==========+###################=#################################################=========#####=####==========#=======\n" + //
                        "===============#############==#======+####################=#################################################====##===########===================\n" + //
                        "=================##########==######==+##################=#=##################################################==#############==#####=============\n" + //
                        "=========#####=#####=##==######==#===+##################=#=+#################################################===#######===#########=============\n" + //
                        "=========####==###===###=########====+##################=#=#+=======================================================############================\n" + //
                        "============######===##===#=###======+####################=#####=============+#######*===============+######====##############=+================\n" + //
                        "==========##=####=##=##==##==========+###=#######=########=#######===#=====####=###=#=##============########====######+=##==#######=============\n" + //
                        "==========#########=###=###=##=======+###=###=###=*#######=####===#==#===##===#=###=#===#*=========#==*++###=====####===#=########===========#==\n" + //
                        "==========###===###==##==#####=======+###=###=###=+#######=####=====##==#=====#=###=#=====#=====###======###============#=====================#=\n" + //
                        "==============+############*=========*###=###=####+#######=####======#========#=###=#============#==###########################*================\n" + //
                        "======##########======#####=#####+#######=###=####*#######=####======#========#=###=#============#===#=#===#==####======###############=========\n" + //
                        "===#####=========#####==###=##=##########=################=####======#========#=###=#============#=#########====#=======######=======######=====\n" + //
                        "=#============#####=#####=#=####=#########################=============###################+================#==*####====###==##=#============##==\n" + //
                        "===========#####=*##=#=#=###################+=====#############*=**=================#=====#====#===############*=======#=###===##=====######====\n" + //
                        "========#######=##=#===######=########=########==#=====#====###########################################===#=====#==#########======########+#====\n" + //
                        "=====##########=##==#####=###====#########===####################==================================####################=======*######======#====\n" + //
                        "==############################################==######################################################################################==#####===");
                break;

            case "EsperaNoche":
                System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::::::::::::::::::::::+:::::@@@*:::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::@@@@@@@:::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::::::::@:::::::::::::@@@@@@@@@::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::@@@@@@@::::::::@@@@@@@@@@:::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::::::::@:::::::::@@@@@@@@@@@@:::::@@@:::::::::::::::::::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::::::::::::::::@@@@@@@@@@@@@::#@@@@@@@:@@@::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::@@@@@@@@@@@@@@:@@@@@@@@@@@@@@:::::::::::::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@:::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@+@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::@:::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@@@:@@@@@@+@@@@@:@@@@:::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@:@@@::::::::::::::::::@:::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::::::::-::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::@::::::@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::::::@::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::@@@@@@::@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::::::::@@:::::::::::::::::\n" + //
                        "::::::::::::::::::::::::@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::::::@::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::@@@@@@@@@@@@@@@@@%::@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@#::::::::::::@@@@@@::::::::::::\n" + //
                        "::::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@@@::@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::\n" + //
                        "::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::\n" + //
                        "::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::\n" + //
                        "::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::\n" + //
                        "::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::\n" + //
                        "::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::\n" + //
                        "::::::::::::::@@@@@@@@@@@@@@:@@@@@@@@@@@@:@@@@@:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::@@@@@@@@@@@@@@@@@@@@@@@:::::::::::::::::::::::::::::\n" + //
                        ":::::::::::::::::::::::::::::@::::::::::::::::::::::::::@@@@@@@@@@@:::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::@:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::@:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" + //
                        "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                break;

                case "Final":
                    System.out.println(" _______  __  .__   __.\n" + //
                            "|   ____||  | |  \\ |  |\n" + //
                            "|  |__   |  | |   \\|  |\n" + //
                            "|   __|  |  | |  . `  |\n" + //
                            "|  |     |  | |  |\\   |\n" + //
                            "|__|     |__| |__| \\__|");
                    break;
        }

    }
}