# 4º.) Modificar el script anterior para que la división se almacene en una variable llamada
#      'resultado' y que se imprima su valor en pantalla =

#!/bin/bash

division_con_variable() {

    a=20
    b=5

    resultado=$((a / b))

    echo "El resultado de la división de $a entre $b es $resultado"

}

division_con_variable