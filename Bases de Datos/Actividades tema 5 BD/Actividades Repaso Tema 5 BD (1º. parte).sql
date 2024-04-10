SET AUTOCOMMIT = 1;
SELECT @@AUTOCOMMIT;

DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda CHARACTER SET utf8mb4;
USE tienda;

CREATE TABLE fabricante (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

CREATE TABLE producto (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  precio DOUBLE NOT NULL,
  id_fabricante INT UNSIGNED NOT NULL,
  FOREIGN KEY (id_fabricante) REFERENCES fabricante(id)
);

INSERT INTO fabricante VALUES(1, 'Asus');
INSERT INTO fabricante VALUES(2, 'Lenovo');
INSERT INTO fabricante VALUES(3, 'Hewlett-Packard');
INSERT INTO fabricante VALUES(4, 'Samsung');
INSERT INTO fabricante VALUES(5, 'Seagate');
INSERT INTO fabricante VALUES(6, 'Crucial');
INSERT INTO fabricante VALUES(7, 'Gigabyte');
INSERT INTO fabricante VALUES(8, 'Huawei');
INSERT INTO fabricante VALUES(9, 'Xiaomi');

INSERT INTO producto VALUES(1, 'Disco duro SATA3 1TB', 86.99, 5);
INSERT INTO producto VALUES(2, 'Memoria RAM DDR4 8GB', 120, 6);
INSERT INTO producto VALUES(3, 'Disco SSD 1 TB', 150.99, 4);
INSERT INTO producto VALUES(4, 'GeForce GTX 1050Ti', 185, 7);
INSERT INTO producto VALUES(5, 'GeForce GTX 1080 Xtreme', 755, 6);
INSERT INTO producto VALUES(6, 'Monitor 24 LED Full HD', 202, 1);
INSERT INTO producto VALUES(7, 'Monitor 27 LED Full HD', 245.99, 1);
INSERT INTO producto VALUES(8, 'Portátil Yoga 520', 559, 2);
INSERT INTO producto VALUES(9, 'Portátil Ideapd 320', 444, 2);
INSERT INTO producto VALUES(10, 'Impresora HP Deskjet 3720', 59.99, 3);
INSERT INTO producto VALUES(11, 'Impresora HP Laserjet Pro M26nw', 180, 3);


-- >> Realiza las siguientes operaciones sobre la base de datos tienda =

-- 1º.) Crea una nueva tabla llamada 'destino_producto' donde tenga de datos el id del producto, el provincia de destino, la fecha y la hora de su llegada al cliente y el nombre del cliente =
CREATE TABLE destino_producto (
nombre_cliente VARCHAR(100) PRIMARY KEY,
provincia_destino VARCHAR(100) NOT NULL,
fecha_llegada DATE,
hora_llegada TIME,
id_producto INT UNSIGNED NOT NULL,
FOREIGN KEY (id_producto) REFERENCES producto(id)
);

-- 2º.) Inserta 3 nuevos destinos para la tabla 'destino_producto' =
INSERT INTO destino_producto VALUES('Xavier', 'Alicante', '02-10-24', '12:55:00', 7);
INSERT INTO destino_producto VALUES('Lukka', 'París', '07-03-24', '20:30:00', 9);
INSERT INTO destino_producto VALUES('Aurora', 'Río de Janerio', '24-06-24', '09:17:30', 2);

-- 3º.) Elimina los destinos donde el id del producto sea menor que 5 =
DELETE FROM destino_producto WHERE id_producto < 5;

-- 4º.) Actualiza los productos como 'WebCam Apple 2.06' donde estos contengan como id del fabricante el 6 =
UPDATE producto SET nombre = 'WebCam Apple 2.06' WHERE id_fabricante = 6;

-- 5º.) Forma una transacción donde insertes en los destinos de los productos otros 2 destinos distintos y los vuelvas permanentes usando 'COMMIT'. Termina consultando si se ha producido correctamente los cambios =
START TRANSACTION;
INSERT INTO destino_producto VALUES('Arnold', 'Orlando', '17-12-24', '22:15:10', 3);
INSERT INTO destino_producto VALUES('Marine', 'Tokio', '13-01-24', '10:00:00', 5);
COMMIT;
SELECT * FROM destino_producto;

-- 6º.) Intenta hacer un 'ROLLBACK'. ¿Qué ocurrirá después si se vuelve a realizar un 'SELECT * FROM destino_producto'?
ROLLBACK;
-- Lo que ocurrirá después es que se verá por pantalla todos los cambios realizados antes del ejercicio 5, dando como resultado la vista de los 3 destinos que insertamos en el ejercicio 2.

-- 7º.) Elimina los productos que tengan los ids iguales a 2, 5 y 7. Consulta la tabla después de eliminarlos =
DELETE FROM producto WHERE id = 2 AND id = 5 AND id = 7;
SELECT * FROM producto;

-- 8º.) Cierra la base de datos actual =
DROP DATABASE tienda;