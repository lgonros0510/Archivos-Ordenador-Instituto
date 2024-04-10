# 21º.) Realizar un script que solicite al usuario dos números por teclado y los sume =

#!/bin/bash

sumar_numeros_usuario() {

    read -p "Introduce el primer número: " num1
    read -p "Introduce el segundo número: " num2

    suma=$((num1 + num2))

    echo "La suma de los números es: $suma"

}

sumar_numeros_usuario