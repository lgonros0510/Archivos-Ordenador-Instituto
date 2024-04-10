# 10º.) Realizar un script que sume dos números que se pasan como argumento a línea de
#       comandos, y si no son pasados se devolverá error y se mostrará un mensaje indicando la
#       forma de ejecutar el script =

#!/bin/bash

sumar_numeros() {

    if [ $# -ne 2 ]; then
        echo "Error: Debes pasar exactamente dos números como argumentos."
        echo "Uso: $0 <numero1> <numero2>"

        return 1

    fi
    
    num1=$1
    num2=$2
    
    resultado=$(($num1 + $num2))
    
    echo "La suma de $num1 y $num2 es: $resultado"

}

sumar_numeros "$@"