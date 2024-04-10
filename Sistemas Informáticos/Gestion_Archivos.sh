#!/bin/bash

while true; do
    echo "Selecciona una opción (1-4):"
    echo "1º.) Ver la ruta actual del archivo o directorio"
    echo "2º.) Ver el contenido del archivo o directorio"
    echo "3º.) Ver los permisos del archivo o directorio"
    echo "4º.) Salir del menú"
    read -p "Ingresa su opción, por favor: " opcion

    case $opcion in
        1)
            pwd
            ;;
        2)
            read -p "Introduzca la ruta del archivo o directorio: " ruta
            ls -l "$ruta"
            ;;
        3)
            read -p "Introduzca la ruta del archivo o directorio: " ruta
            ls -ld "$ruta" | cut -d" " -f1
            ;;
        4)
            echo "Saliendo del menú..."
            exit 0
            ;;
        *)
            echo "Dicha opción no es válida. Inténtalo de nuevo, por favor: "
            ;;
    esac
done