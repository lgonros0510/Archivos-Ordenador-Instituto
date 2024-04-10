# 11º.) Realizar un script que reciba un número por parámetro y, si es mayor que 100, muestre el
#       mensaje: "El número es mayor que 100" =

#!/bin/bash

verificar_numero() {

    if [ $# -ne 1 ]; then
        echo "Error: Debes pasar un número como argumento."
        echo "Uso: $0 <numero>"

        return 1

    fi
    
    numero=$1
    
    if [ $numero -gt 100 ]; then
        echo "El número es mayor que 100."

    else
        echo "El número no es mayor que 100."

    fi

}

verificar_numero "$2"