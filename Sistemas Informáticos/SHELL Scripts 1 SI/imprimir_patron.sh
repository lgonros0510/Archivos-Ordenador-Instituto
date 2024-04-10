# 19º. Realizar un script utilizando el bucle for que muestre el siguiente patrón =

# 1
# 22
# 333
# 4444
# 55555

#!/bin/bash

imprimir_patron() {

    for ((i = 1; i <= "$1"; i++)); do
        for ((j = 1; j <= i; j++)); do
            echo -n "$i"

        done

        echo ""

    done

}

imprimir_patron 5