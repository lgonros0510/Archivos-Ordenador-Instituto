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

-- 1º.) Inserta un nuevo fabricante indicando su código y su nombre =
INSERT INTO fabricante VALUES(10, 'Acer');

-- 2º.) Inserta un nuevo fabricante indicando solamente su nombre =
INSERT INTO fabricante (nombre) VALUES ('Dell');

-- 3º.) Inserta un nuevo producto asociado a uno de los nuevos fabricantes. La sentencia de inserción debe incluir: código, nombre, precio y código_fabricante =
INSERT INTO producto VALUES(12, 'Teclado inalámbrico', 30.50, 10);

-- 4º.) Inserta un nuevo producto asociado a uno de los nuevos fabricantes. La sentencia de inserción debe incluir: nombre, precio y código_fabricante =
INSERT INTO producto (nombre, precio, id_fabricante) VALUES ('Ratón óptico', 15.99, 11);

-- 5º.) Crea una nueva tabla con el nombre fabricante_productos que tenga las siguientes columnas: nombre_fabricante, nombre_producto y precio. Una vez creada la tabla inserta todos los registros de la base de datos tienda en esta tabla haciendo uso de única operación de inserción =
CREATE TABLE fabricante_productos (
  nombre_fabricante VARCHAR(100),
  nombre_producto VARCHAR(100),
  precio DOUBLE
);

INSERT INTO fabricante_productos (nombre_fabricante, nombre_producto, precio)
SELECT fabricante.nombre, producto.nombre, producto.precio
FROM fabricante
JOIN producto ON fabricante.id = producto.id_fabricante;

-- 6º.) Crea una vista con el nombre vista_fabricante_productos que tenga las siguientes columnas: nombre_fabricante, nombre_producto y precio =
CREATE VIEW vista_fabricante_productos AS
SELECT fabricante.nombre AS nombre_fabricante, producto.nombre AS nombre_producto, producto.precio
FROM fabricante
JOIN producto ON fabricante.id = producto.id_fabricante;

-- 7º.) Elimina el fabricante Asus. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese posible borrarlo?
-- >> No es posible eliminar el fabricante Asus ya que hay productos asociados a él. Para poder eliminarlo, primero tendrías que eliminar los productos asociados.

-- 8º.) Elimina el fabricante Xiaomi. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese posible borrarlo?
-- >> No es posible eliminar el fabricante Xiaomi ya que hay productos asociados a él. Para poder eliminarlo, primero tendrías que eliminar los productos asociados.

-- 9º.) Actualiza el código del fabricante Lenovo y asígnale el valor 20. ¿Es posible actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
-- >> No es posible actualizar el código del fabricante Lenovo ya que es una clave primaria y está referenciada por la tabla producto. Para actualizarlo, primero tendrías que eliminar o actualizar las referencias en la tabla producto.

-- 10º.) Actualiza el código del fabricante Huawei y asígnale el valor 30. ¿Es posible actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
-- >> No es posible actualizar el código del fabricante Huawei por la misma razón que Lenovo. Deberías eliminar o actualizar las referencias en la tabla producto.

-- 11º.) Actualiza el precio de todos los productos sumándole 5 € al precio actual =
UPDATE producto SET precio = precio + 5;

-- 12º.) Elimina todas las impresoras que tienen un precio menor de 200 € =
DELETE FROM producto WHERE nombre LIKE 'Impresora%' AND precio < 200;