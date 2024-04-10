# 12º.) Realizar un script que muestre un mensaje de error si no se han pasado parámetros =

#!/bin/bash

verificar_parametros() {

    if [ $# -eq 0 ]; then
        echo "Error: No se han pasado parámetros."
        echo "Uso: $0 <parametro1> <parametro2> ..."

        return 1

    fi
    
    echo "Los parámetros pasados son:"

    for parametro in "$@"; do
        echo "- $parametro"

    done

}

verificar_parametros "$@"