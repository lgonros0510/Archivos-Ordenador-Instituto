# 24º.) Realizar un script al que se le pasa como parámetro un fichero y dice si existe, no existe o
#       es un directorio.

#!/bin/bash

verificar_fichero() {

    if [ -e "$1" ]; then
        if [ -f "$1" ]; then
            echo "$1 es un fichero"

        elif [ -d "$1" ]; then
            echo "$1 es un directorio"

        else
            echo "$1 es otro tipo de archivo"

        fi

    else
        echo "$1 no existe"

    fi

}

verificar_fichero "$2"