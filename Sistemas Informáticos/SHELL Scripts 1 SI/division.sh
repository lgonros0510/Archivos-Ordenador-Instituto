# 3º.) Realizar un script que defina dos variables, 'a=20' y 'b=5'. Muestra el resultado de la división
#      de 'a' entre 'b' por pantalla =

#!/bin/bash

division() {

    a=20
    b=5

    echo "El resultado de la división de $a entre $b es $((a / b))"

}

division