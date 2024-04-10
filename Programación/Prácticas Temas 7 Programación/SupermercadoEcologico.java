/** @author Lucía González Rosas */

/* 8º.) Un supermercado de productos ecológicos nos ha pedido hacer un programa
para vender su mercancía. En esta primera versión del programa se tendrán
en cuenta los productos que se indican en la tabla junto con su precio. Los
productos se venden en bote, brick, etc. Cuando se realiza la compra, hay que
indicar el producto y el número de unidades que se compran, por ejemplo
“guisantes” si se quiere comprar un bote de guisantes y la cantidad, por
ejemplo “3” si se quieren comprar 3 botes. La compra se termina con la palabra
“fin. Suponemos que el usuario no va a intentar comprar un producto que
no existe. Utiliza un diccionario para almacenar los nombres y precios de los
productos y una o varias listas para almacenar la compra que realiza el usuario.
A continuación se muestra una tabla con los productos disponibles y sus
respectivos precios:

avena garbanzos tomate jengibre quinoa guisantes
2,21  2,39      1,59   3,13     4,50   1,60

Ejemplo:
Producto: tomate
Cantidad: 1
Producto: quinoa
Cantidad: 2
Producto: avena
Cantidad: 1
Producto: tomate
Cantidad: 2
Producto: fin
Producto Precio Cantidad Subtotal
---------------------------------
tomate   1,59   1        1,59
quinoa   4,50   2        9,00
avena    2,21   1        2,21
tomate   1,59   2        3,18
---------------------------------
TOTAL: 15,98 */

import java.util.*;

public class SupermercadoEcologico {
    public static void main(String[] args) {

        Map<String, Double> productos = new HashMap<>();

        productos.put("avena", 2.21);
        productos.put("garbanzos", 2.39);
        productos.put("tomate", 1.59);
        productos.put("jengibre", 3.13);
        productos.put("quinoa", 4.50);
        productos.put("guisantes", 1.60);
        
        List<String[]> compra = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Producto: ");
            String producto = scanner.nextLine();

            if (producto.equals("fin")) {
                break;

            }

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            
            if (productos.containsKey(producto)) {
                double precioUnitario = productos.get(producto);
                double subtotal = precioUnitario * cantidad;

                compra.add(new String[]{producto, Double.toString(precioUnitario), Integer.toString(cantidad), Double.toString(subtotal)});

            }
        }
        
        System.out.println("Producto   Precio   Cantidad   Subtotal");
        System.out.println("---------------------------------------");

        double total = 0;

        for (String[] item : compra) {
            System.out.printf("%-10s %-8s %-10s %-8s\n", item[0], item[1], item[2], item[3]);

            total += Double.parseDouble(item[3]);

        }

        System.out.println("---------------------------------------");
        System.out.printf("TOTAL: %.2f\n", total);
        
        scanner.close();

    }
}

// El proceso para crear dicho programa es el siguiente =

/* Primero se creará un "Map" con los atributos "String" y "Double" que contenga los
 * productos junto con sus precios que están disponibles en el supermercado (siendo
 * estos avena, garbanzos, tomates, jengibre, quinoa y guisantes) e iremos introduciendo,
 * a base de utilizar el método ".put()", dichos productos y precios disponibles.
 * 
 * Después, crearemos un ArrayList que formará parte de la lista de la compra. Dicha lista
 * se irá rellenando gracias a un bucle "while" (que irá pidiendo el nombre de los productos
 * hasta que escribamos por teclado "fin"), además de que iremos insertando también la cantidad
 * de cada producto insertado en la lista. El precio unitario se recogerá del "Map" creado
 * anteriormente utilizando la sentencia "if" y el método ".containsKey()" junto con el método
 * ".get()" y el subtotal se obtendrá multiplicando dicho precio unitario por la cantidad que
 * hayamos insertado en el producto.
 * 
 * Por último, utilizando "sysouts" para mostrar la lista de la compra por pantalla y un bucle
 * "for-each", se mostrará la lista completa con los productos, sus precios unitarios, la cantidad
 * de cada uno y el subtotal de cada uno. Además, el total final se calculará por medio de un
 * método "Double.parseDouble()", que se irá sumando a medida que se incluyan productos y sus
 * cantidades correspondientes por teclado.
 */