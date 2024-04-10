# 28. Realizar un script que imprima el siguiente menú:

# 1 - Sumar
# 2 - Restar
# 3 - Dividir
# 4 – Multiplicar
# 0 - Salir

# Después de mostrar el menú, se pedirá que se elija una opción. Si la opción elegida no está
# entre el 1 y el 4, se mostrará un mensaje de error. En caso de que la opción sea válida, se
# pedirán dos números por teclado y en función de la operación elegida, se devolverá el
# resultado por pantalla.

# Cada operación será implementada haciendo uso de funciones.
# Si la opción elegida no es válida, se volverá a mostrar el menú.
# El programa terminará, cuando se pulse 0.

#!/bin/bash

mostrar_menu_operaciones() {

    while true; do
        echo "1 - Sumar"
        echo "2 - Restar"
        echo "3 - Dividir"
        echo "4 - Multiplicar"
        echo "0 - Salir"

        read -p "Seleccione una opción: " opcion

        case $opcion in
            1)
                sumar_numeros_usuario
                ;;

            2)
                echo "Operación Restar"

                read -p "Introduce el primer número: " num1
                read -p "Introduce el segundo número: " num2
                
                resta=$((num1 - num2))
                
                echo "La suma de los números es: $resta"
                ;;

            3)
                echo "Operación Dividir"
                
                read -p "Introduce el primer número: " num1
                read -p "Introduce el segundo número: " num2
                
                division=$((num1 / num2))
                
                echo "La suma de los números es: $division"
                ;;

            4)
                echo "Operación Multiplicar"
                
                read -p "Introduce el primer número: " num1
                read -p "Introduce el segundo número: " num2
                
                multiplicacion=$((num1 * num2))
                
                echo "La suma de los números es: $multiplicacion"
                ;;

            0)
                echo "Saliendo..."
                exit 0
                ;;

            *)
                echo "Opción no válida, por favor seleccione una opción del menú."
                ;;
                
        esac

    done

}

mostrar_menu_operaciones