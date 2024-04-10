# 6º.) Encontrar los errores que hay sobre variables en el siguiente código =

#!/bin/bash

minombre=Alfonso
?miapellido=Sanz
miedad=41
echo "Mi nombre es $minombre"
echo "Mi apellido es $miapellido"
echo 'Mi edad es $miedad

# ---> Variables corregidas <---

minombre=Alfonso
miapellido=Sanz
miedad=41
echo "Mi nombre es $minombre"
echo "Mi apellido es $miapellido"
echo "Mi edad es $miedad"

# En la línea ?miapellido=Sanz, el símbolo ? no es válido como parte del nombre de la variable en Bash.
# Los nombres de las variables en Bash pueden contener letras (mayúsculas y minúsculas), números y guiones
# bajos, pero no pueden comenzar con un número.

# En la línea echo 'Mi edad es $miedad, la comilla simple ('') se está utilizando en lugar de comillas dobles
# ("") para envolver la cadena que se imprime en pantalla. Cuando se usan comillas simples, las variables no
# se expanden y se imprimen literalmente como texto.