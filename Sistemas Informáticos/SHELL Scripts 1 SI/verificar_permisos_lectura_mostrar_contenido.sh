# 26º.) Realiza un script que comprueba si el fichero pasado por parámetro tiene permisos de
#       lectura, en cuyo caso mostrará su contenido.

#!/bin/bash

verificar_permisos_lectura_mostrar_contenido() {

    if [ -r "$1" ]; then
        echo "Contenido de $1:"

        cat "$1"

    else
        echo "Error: $1 no tiene permisos de lectura"

    fi

}

verificar_permisos_lectura_mostrar_contenido