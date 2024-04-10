# 25º.) Realizar un script que compruebe si los ficheros pasados por parámetro existen. Si existen,
#       se muestra el nombre del fichero, si no existen, se muestra un mensaje de error.

#!/bin/bash

verificar_existencia_ficheros_con_mensaje() {

    for file in "$@"; do
        if [ -e "$file" ]; then
            echo "$file existe"

        else
            echo "Error: $file no existe"

        fi

    done

}

verificar_existencia_ficheros_con_mensaje "$@"