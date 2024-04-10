# 22º.) Realizar un script que muestre la tabla de multiplicar de un número pasado por parámetro =

#!/bin/bash

tabla_multiplicar() {

    read -p "Introduce un número para mostrar su tabla de multiplicar: " num

    for ((i = 1; i <= 10; i++)); do
        echo "$num x $i = $((num * i))"

    done

}

tabla_multiplicar