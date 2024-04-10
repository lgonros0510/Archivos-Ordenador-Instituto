# 13º.) Realizar un script que reciba un número por parámetro y, si es mayor que 100, muestre el
#        mensaje "Número es mayor que 100". En caso contrario que muestre el mensaje “Número
#        NO es mayor que 100” =

#!/bin/bash

verificar_numero_mayor_que_100() {

    if [ "$1" -gt 100 ]; then
        echo "Número es mayor que 100"

    else
        echo "Número NO es mayor que 100"

    fi

}

verificar_numero_mayor_que_100