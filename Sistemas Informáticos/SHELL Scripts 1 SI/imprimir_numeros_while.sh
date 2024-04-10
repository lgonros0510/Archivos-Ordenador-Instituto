# 23º.) Realizar un script que imprimas los números 5,4,3,2,1 usando un bucle while =

#!/bin/bash

imprimir_numeros_while() {

    num=5

    while [ "$num" -ge 1 ]; do
        echo "$num"

        num=$((num - 1))

    done

}

imprimir_numeros_while