#1. Crea un script que pida por teclado el nombre de un usuario y a continuación muestre las
#líneas donde aparece ese usuario en los ficheros /etc/passwd y en los ficheros /etc/group.

#!/bin/bash

echo "Introduzca el nombre de usuario:"
read username

echo "Resultado de la búsqueda en /etc/passwd:"
grep "$username" /etc/passwd

echo "Resultado de la búsqueda en /etc/group:"
grep "$username" /etc/group

#2. Crea un script que deba recibir un parámetro. Habrá que comprobar que se recibe un
#parámetro, si no se recibe se devolverá como código de salida un 1. Si recibe un parámetro,
#habrá que buscar por el sistema de archivos si es un fichero que existe y mostrar por pantalla
#los resultados.

#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Debe de proporcionar un parámetro."
    exit 1
fi

file=$1

if [ -e "$file" ]; then
    echo "El archivo $file existe."
else
    echo "El archivo $file no existe."
fi

#3. Realiza el script anterior, pero esta vez en vez de por parámetros deberá pedir el nombre
#por la línea de comandos. Si no se escribe nada devolverá código de salida 1.

#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Debe de proporcionar el nombre de un archivo."
    exit 1
fi

file=$1

if [ -e "$file" ]; then
    echo "El archivo $file existe."
else
    echo "El archivo $file no existe."
fi

#4. Crea un script con un menú que realice 3 tareas diferentes: muestre la fecha y hora del
#sistema, muestre el contenido del fichero personal del usuario en formato largo, muestre el
#primer usuario y los 10 últimos dados de alta en el sistema.

#!/bin/bash

while true; do
    echo "Seleccione una opción:"
    echo "1. Mostrar fecha y hora del sistema."
    echo "2. Mostrar contenido del archivo personal."
    echo "3. Mostrar primer y últimos 10 usuarios del sistema."
    echo "4. Salir"

    read -p "Opción elegida: " option

    case $option in
        1)
            date
            ;;
        2)
            cat /path/to/archivo_personal
            ;;
        3)
            echo "Primer usuario:"
            head -n1 /etc/passwd
            echo "Últimos 10 usuarios:"
            tail -n10 /etc/passwd
            ;;
        4)
            echo "Saliendo del bash..."
            exit 0
            ;;
        *)
            echo "La opción no es válida. Inténtalo de nuevo."
            ;;
    esac
done

#5. Crea un script que pida por teclado el nombre de un fichero, deberá comprobar que no es
#un fichero que exista, si no existe, crearlo, añadirle permiso de ejecución, añadirle como
#primera línea lo siguiente:
##!/bin/bash
#y después abrir ese fichero con nano.

#!/bin/bash

echo "Introduzca el nombre del fichero:"
read filename

if [ -e "$filename" ]; then
    echo "El fichero $filename ya existe."
else
    echo "#!/bin/bash" > "$filename"
    chmod +x "$filename"
    echo "El fichero creado: $filename"
fi

nano "$filename"
