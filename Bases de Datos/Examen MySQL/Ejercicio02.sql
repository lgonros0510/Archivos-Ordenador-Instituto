/* @author Lucía González Rosas */

/* ---EJERCICIO 2A---

Borra la tabla empleados, y créala de nuevo, con las siguientes restricciones:
- dni es PRIMARY KEY
- fecha_contrato por defecto es "2021-01-01"
- los demás son campos obligatorios 
empleados(dni, nombre, edad, fecha_contrato)

Inserta tu script después de los comentarios
\/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/     */
DROP TABLE empleados;

CREATE TABLE empleados(dni varchar(9) NOT NULL PRIMARY KEY, nombre varchar(7) NOT NULL, edad varchar(2) NOT NULL, fecha_empleados DATE NOT NULL DEFAULT '2021-01-01');

/* Prueba: Debe añadir 2 registros, y 4 errores  */
DESCRIBE empleados;
INSERT INTO empleados VALUES ('11111111A','Alberto',38,'2020-09-14');
INSERT INTO empleados VALUES (NULL,'Bárbara',26,'2021-02-13');
INSERT INTO empleados VALUES ('33333333C',NULL,35,'2022-03-12');
INSERT INTO empleados VALUES ('44444444D','Daniela',NULL,'2023-04-11');
INSERT INTO empleados VALUES ('55555555E','Enrique',56,NULL);
INSERT INTO empleados(dni, nombre, edad) VALUES ('66666666F','Fernanda',20);
SELECT * FROM empleados;


--------------------------------------------------------------------------------------------------

/* ---EJERCICIO 2B---

Borra la tabla oficinas, y créala de nuevo, con las siguientes restricciones:
- dni es PRIMARY KEY
- los demás son campos opcionales
- localidad es única
- num_empleados no puede ser 0

oficinas(codigo, direccion, localidad, telefono, num_empleados)

Inserta tu script después de los comentarios
\/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/     */
DROP TABLE oficinas;

CREATE TABLE oficinas(codigo INT NOT NULL PRIMARY KEY, nombre varchar(15) NOT NULL, localidad varchar(10) NOT NULL UNIQUE, telefono varchar(9) NOT NULL, num_empleados INT NOT NULL);

/* Prueba: Debe añadir 2 registros, y 2 errores  */
DESCRIBE oficinas;
INSERT INTO oficinas VALUES (001, 'Miguel Ángel','Coín',952111111,10);
INSERT INTO oficinas VALUES (002, 'Leonardo','Málaga',952222222,50);
INSERT INTO oficinas VALUES (003, 'Donatello','Málaga',95333333,20);
INSERT INTO oficinas VALUES (004, 'Rafael','Marbella',952444444,0);
SELECT * FROM empleados;


