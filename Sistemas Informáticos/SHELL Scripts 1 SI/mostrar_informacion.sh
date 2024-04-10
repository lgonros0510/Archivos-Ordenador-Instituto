# 7º.) Realizar un script que muestre el nombre del script, el número de parámetros que se le
#      pasan, una lista con los parámetros recibidos, el identificador del usuario que ejecuta el
#      script, el nombre de usuario, el directorio 'home' del usuario y el directorio actual =

#!/bin/bash

mostrar_informacion() {

    echo "Nombre del script: $0"

    echo "Número de parámetros: $#"

    echo "Lista de parámetros: $@"

    echo "Identificador del usuario: $UID"

    echo "Nombre de usuario: $USER"

    echo "Directorio home del usuario: $HOME"

    echo "Directorio actual: $PWD"

}

mostrar_informacion