# 9º.) Realizar un script que solicite al usuario por teclado su peso y su estatura y muestre la
#      siguiente salida por pantalla (respetando los saltos de línea y las tabulaciones) =

#!/bin/bash

peso_y_altura() {

    echo -n "Por favor, introduce tu peso en kg: "
    read peso
    
    echo -n "Ahora, introduce tu estatura en metros: "
    read estatura
        

    echo -e "Tu peso actual es de \t\t$peso kg."
    echo -e "Tu estatura actual es de \t$estatura metros."

}

peso_y_altura