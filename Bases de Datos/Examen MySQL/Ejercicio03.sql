/* @author Lucía González Rosas */

/* ---EJERCICIO 3A---

Modifica la tabla empleados, sin borrarla, para añadir la siguiente restricción:
- edad no puede ser menor que 18 (obligatorio)
+ Añade una columna sexo, que puede ser 'm' o 'h' (no obligatorio).

empleados(dni, nombre, edad, fecha_contrato, sexo)

*/
ALTER TABLE empleados ADD(edad varchar(2) NOT NULL);
ALTER TABLE empleados ADD(sexo varchar(1));

/* Prueba: Debe añadir 1 registro (total 3) y 2 errores */
INSERT INTO empleados VALUES ('22222222B','Bárbara',26,'2021-02-13','m');
INSERT INTO empleados VALUES ('33333333C','Carlos',15,'2022-03-12','h');
INSERT INTO empleados VALUES ('77777777G','Gonzalo',48,'2020-07-08','o');
SELECT * FROM empleados;

------------------------------------------------------------------------------------------------------


/* ---EJERCICIO 3B---

Modifica la tabla oficinas, sin borrarla, para añadir la siguiente restricción:
- telefono es obligatorio, y debe ser un número fijo de 9 dígitos, entre 900000000 y 999999999.

oficinas(codigo, direccion, localidad, telefono, num_empleados)

*/
ALTER TABLE oficinas ADD(telefono varchar(9) NOT NULL);

/* Prueba: Debe añadir 1 registro, y 1 error  */
DESCRIBE oficinas;
INSERT INTO oficinas VALUES (003, 'Donatello','Málaga',95333333,20);
INSERT INTO oficinas VALUES (004, 'Rafael','Marbella',9522222,30);
SELECT * FROM empleados;

