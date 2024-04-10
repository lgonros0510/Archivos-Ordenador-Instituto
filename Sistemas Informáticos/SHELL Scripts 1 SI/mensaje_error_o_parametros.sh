# 14º.) Realizar un script que muestre un mensaje de error si no se han pasado parámetros y si se
#       le han pasado parámetros que los muestre por pantalla =

#!/bin/bash

mensaje_error_o_parametros() {

    if [ "$#" -eq 0 ]; then
        echo "Error: No se han pasado parámetros"

    else
        echo "Parámetros recibidos: $@"

    fi

}

mensaje_error_o_parametros "$@"