/* @author Lucía González Rosas */

/* ---EJERCICIO 5A---
Modifica la tabla empleados, sin borrarla:
+ Añade una columna oficina, que se refiere a un registro de la tabla oficinas (FK).
+ Añade una columna departamento, que se refiere a un registro de la tabla departamentos (FK).
+ Modifica la columna superior, para que se refiera a otro registro de la tabla empleados (FK).
empleados(dni, nombre, edad, fecha_contrato, movil)
*/
ALTER TABLE empleados ADD(oficina varchar(2) NOT NULL FOREIGN KEY REFERENCES oficinas(codigo), departamento varchar(2) NOT NULL FOREIGN KEY REFERENCES departamentos(nombre));

ALTER TABLE empleados ADD(superior varchar(9) NOT NULL FOREIGN KEY empleados(nombre));

/* ---EJERCICIO 5B---
Añade una tabla que almacene la distancia que hay entre dos oficinas (hasta 999km).
Inserta 2 registros, y otros 2 que fallen por restricciones diferentes.
*/

CREATE TABLE distancia(dist_oficinas varchar(9) NOT NULL);


  
