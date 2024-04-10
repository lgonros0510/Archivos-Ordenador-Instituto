/* @author Lucía González Rosas */

/* ---EJERCICIO 4A---

Modifica la tabla empleados, sin borrarla:
- elimina la columna sexo, no es relevante.
+ Añade una columna móvil, que debe tener 9 números entre el 600000000 y 799999999, pero no es obligatoria.
+ Añade una columna superior, con el mismo tipo que el dni.
empleados(dni, nombre, edad, fecha_contrato, movil, superior)
*/
DELETE FROM empleados(sexo);

ALTER TABLE empleados ADD(movil varchar(9));

ALTER TABLE empleados ADD(superior varchar(9) NOT NULL);

/* Prueba: Debe añadir 1 registro (total 3) y 2 errores */
INSERT INTO empleados VALUES ('22222222B','Bárbara',26,'2021-02-13',666666666, 11111111A);
INSERT INTO empleados VALUES ('33333333C','Carlos',15,'2022-03-12',666666667, 11111111A);
INSERT INTO empleados VALUES ('77777777G','Gonzalo',48,'2020-07-08',555555555, 11111111A);
SELECT * FROM empleados;


-----------------------------------------------------------------------------------------------------


/* ---EJERCICIO 4B---
Añade una tabla departamentos:
departamentos (nombre, sede, presupuesto, director)
Con las siguientes restricciones: 
- nombre es PRIMARY KEY.
- sede se refiere a una oficina.
- presupuesto no es obligatorio, pero no puede alcanzar 1 millón (2 decimales).
- director (o directora) se refiere a un registro de la tabla empleados.

*/
CREATE TABLE departamentos(nombre varchar(15) NOT NULL PRIMARY KEY, sede varchar(2) NOT NULL REFERENCES oficinas, presupuesto FLOAT(5,2) WHERE, director varchar(15) NOT NULL REFERENCES empleados(nombre));

/* Prueba: Debe añadir 2 registros y 3 errores */
DESCRIBE departamentos;
INSERT INTO departamentos VALUES ('Dirección', 1, 600000.00, '11111111A');
INSERT INTO departamentos VALUES ('Informática', 2, 1000.00, '22222222B');
INSERT INTO departamentos VALUES ('Ventas', 1, 15000000.00, '11111111A');
INSERT INTO departamentos VALUES ('Marketing', 45, 200000.00, '11111111A');
INSERT INTO departamentos VALUES ('Marketing', 2, 200000.00, '99999999I');
SELECT * FROM empleados;

