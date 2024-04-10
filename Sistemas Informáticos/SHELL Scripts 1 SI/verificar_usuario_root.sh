# 27º.) Realizar un script que solo pueda ser ejecutado por el usuario root. En caso contrario
#       devolverá una salida de error y mostrará un mensaje de error indicando que no somos
#       root.

#!/bin/bash

verificar_usuario_root() {

    if [ "$(id -u)" -eq 0 ]; then
        echo "Usuario es root"

    else
        echo "Error: No eres root"

        exit 1

    fi

}

verificar_usuario_root