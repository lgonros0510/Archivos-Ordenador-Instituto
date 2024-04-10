/* @author Lucía González Rosas */

/* ---EJERCICIO 1A--- 

Crea la siguiente tabla, con el tipo de dato que te parezca más apropiado
empleados(dni, nombre, edad, fecha_contrato)

Inserta tu script después de los comentarios
\/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/     */
CREATE TABLE empleados(dni varchar(9) NOT NULL PRIMARY KEY, nombre varchar(7) NOT NULL, edad varchar(2) NOT NULL, fecha_contrato DATE);

/* Prueba: Debe añadir 2 registros */
DESCRIBE empleados;
INSERT INTO empleados VALUES ('11111111A','Alberto',38,'2020-01-14');
INSERT INTO empleados VALUES ('22222222B','Bárbara',26,'2021-02-13');
SELECT * FROM empleados;



-----------------------------------------------------------------------------------------------------

/* ---EJERCICIO 1B---

Crea la siguiente tabla, con el tipo de dato que te parezca más apropiado
oficinas(codigo, direccion, localidad, telefono, num_empleados)

Inserta tu script después de los comentarios
\/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/      */

CREATE TABLE oficinas(codigo INT NOT NULL PRIMARY KEY, nombre varchar(15) NOT NULL, localidad varchar(10) NOT NULL, telefono varchar(9) NOT NULL, num_empleados INT NOT NULL);

/* Prueba: Debe añadir 2 registros */
DESCRIBE oficinas;
INSERT INTO oficinas VALUES (001, 'Miguel Ángel','Coín',952111111,10);
INSERT INTO oficinas VALUES (002, 'Leonardo','Málaga',952222222,50);
SELECT * FROM empleados;
