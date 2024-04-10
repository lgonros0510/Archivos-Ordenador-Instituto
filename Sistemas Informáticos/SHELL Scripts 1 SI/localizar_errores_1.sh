# 5º.) Encontrar los errores que hay sobre variables en el siguiente código =

#!/bin/bash

minombre=Alfonso
miapellido = Sanz
miedad=41
echo "Mi nombre es $minombre"
echo "Mi apellido es $miapellido"
echo "Mi edad es miedad"

# ---> Variables corregidas <---

minombre=Alfonso
miapellido=Sanz
miedad=41
echo "Mi nombre es $minombre"
echo "Mi apellido es $miapellido"
echo "Mi edad es $miedad"

# ---> Explicación a los errores <---

# En la línea miapellido = Sanz, hay un espacio entre el nombre de la variable (miapellido)
# y el signo de igualdad (=). En Bash, no se deben tener espacios alrededor del signo de
# igualdad cuando se asignan valores a las variables.

# En la línea echo "Mi edad es miedad", miedad está escrita sin el signo de dólar ($). Sin
# el signo de dólar, Bash no interpretará miedad como una variable y simplemente imprimirá
# literalmente "miedad" en lugar de su valor.