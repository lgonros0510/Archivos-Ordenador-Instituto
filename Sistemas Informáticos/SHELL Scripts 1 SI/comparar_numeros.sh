# 15º.) Realizar un script que reciba dos números por parámetro y muestre un mensaje indicando
#       si ambos números son iguales, si el primer número es mayor o si el segundo número es
#       mayor =

#!/bin/bash

comparar_numeros() {

    if [ "$1" -eq "$2" ]; then
        echo "Ambos números son iguales"

    elif [ "$1" -gt "$2" ]; then
        echo "El primer número es mayor"

    else
        echo "El segundo número es mayor"

    fi

}

comparar_numeros "$2" "$3"