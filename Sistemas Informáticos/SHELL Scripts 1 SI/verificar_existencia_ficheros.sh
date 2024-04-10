# 18º.) Realizar un script que indique si los ficheros pasados por parámetro existen o no existen =

#!/bin/bash

verificar_existencia_ficheros() {

    for file in "$@"; do
        if [ -e "$file" ]; then
            echo "$file existe"

        else
            echo "$file no existe"

        fi

    done

}

verificar_existencia_ficheros "$@"