# 16º.) Realizar un script para averiguar el número más grande a partir de tres números pasados
#       por parámetro. Mostrar un error si no se proporcionan los parámetros suficientes =

#!/bin/bash

numero_mas_grande() {

    if [ "$#" -lt 3 ]; then
        echo "Error: No se proporcionaron suficientes parámetros"

    else
        max="$1"

        for num in "$@"; do
            if [ "$num" -gt "$max" ]; then
                max="$num"

            fi

        done

        echo "El número más grande es: $max"

    fi

}

numero_mas_grande "$@"