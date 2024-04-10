-- Tarea voluntaria hecha por Lucía González Rosas

-- |==============================================|

-- 1º.) Insertar una nueva oficina en Almería =

INSERT INTO oficina (codigo_oficina, ciudad, pais, codigo_postal, telefono, linea_direccion1)
VALUES ('ALM', 'Almería', 'España', '04001', '+34 123456789', 'Calle Alameda 123');

-- 2º.) Insertar un empleado para la oficina de Almería que sea representante de ventas =

INSERT INTO empleado (codigo_empleado, nombre, apellido1, extension, email, codigo_oficina, puesto)
VALUES (1000, 'Juan', 'Perez', 'x1234', 'juan@example.com', 'ALM', 'Representante de Ventas');

-- 3º.) Insertar un cliente que tenga como representante de ventas el empleado que hemos creado en el paso anterior =

INSERT INTO cliente (codigo_cliente, nombre_cliente, telefono, fax, linea_direccion1, ciudad, codigo_empleado_rep_ventas)
VALUES (5000, 'Cliente Ejemplo', '+34 987654321', '+34 987654322', 'Calle Ejemplo 456', 'Almería', 1000);

-- 4º.) Insertar un pedido para el cliente que acabamos de crear, que contenga al menos dos productos diferentes =

INSERT INTO pedido (codigo_pedido, fecha_pedido, fecha_esperada, estado, codigo_cliente)
VALUES (10000, '2024-02-20', '2024-02-25', 'En proceso', 5000);

INSERT INTO detalle_pedido (codigo_pedido, codigo_producto, cantidad, precio_unidad, numero_linea)
VALUES (10000, 'S10_1678', 2, 45.00, 1),
       (10000, 'S18_1374', 3, 60.00, 2);

-- 5º.) Actualizar el código del cliente que hemos creado en el paso anterior y averiguar si hubo cambios en las tablas relacionadas =

UPDATE cliente SET codigo_cliente = 6000 WHERE codigo_cliente = 5000;
-- Dato: Se actualizarán automáticamente las tablas relacionadas ya que se utiliza la clave primaria para hacer referencia al cliente.

-- 6º.) Borrar el cliente y averiguar si hubo cambios en las tablas relacionadas =

DELETE FROM cliente WHERE codigo_cliente = 6000;
-- Dato: Se eliminarán automáticamente las filas relacionadas en las tablas de detalle_pedido y pago debido a las claves foráneas con ON DELETE CASCADE.

-- 7º.) Eliminar los clientes que no hayan realizado ningún pedido =

DELETE FROM cliente WHERE codigo_cliente NOT IN (SELECT DISTINCT codigo_cliente FROM pedido);

-- 8º.) Incrementar en un 20% el precio de los productos que no tengan pedidos =

UPDATE producto SET precio_venta = precio_venta * 1.20 WHERE codigo_producto NOT IN (SELECT DISTINCT codigo_producto FROM detalle_pedido);

-- 9º.) Borrar los pagos del cliente con menor límite de crédito =

DELETE FROM pago WHERE codigo_cliente = (SELECT codigo_cliente FROM cliente ORDER BY limite_credito ASC LIMIT 1);

-- 10º.) Establecer a 0 el límite de crédito del cliente que menos unidades pedidas tenga del producto 11679 =

UPDATE cliente
SET limite_credito = 0
WHERE codigo_cliente = (
    SELECT codigo_cliente
    FROM (
        SELECT c.codigo_cliente, SUM(dp.cantidad) as total_unidades
        FROM cliente c
        JOIN pedido p ON c.codigo_cliente = p.codigo_cliente
        JOIN detalle_pedido dp ON p.codigo_pedido = dp.codigo_pedido
        WHERE dp.codigo_producto = '11679'
        GROUP BY c.codigo_cliente
        ORDER BY total_unidades ASC
        LIMIT 1
    ) AS subquery
);

-- 11º.) Modificar la tabla detalle_pedido para insertar un campo numérico llamado iva =

ALTER TABLE detalle_pedido ADD COLUMN iva NUMERIC(5,2);

START TRANSACTION;
UPDATE detalle_pedido
SET iva = 18
WHERE codigo_pedido IN (
    SELECT codigo_pedido
    FROM pedido
    WHERE fecha_pedido >= '2009-01-01'
);

UPDATE detalle_pedido
SET iva = 21
WHERE iva IS NULL;
COMMIT;

-- 12º.) Modificar la tabla detalle_pedido para incorporar un campo numérico llamado total_linea =

ALTER TABLE detalle_pedido ADD COLUMN total_linea NUMERIC(15,2);

UPDATE detalle_pedido
SET total_linea = precio_unidad * cantidad * (1 + (iva / 100));

-- 13º.) Borrar el cliente que menor límite de crédito tenga. ¿Es posible borrarlo solo con una consulta? ¿Por qué?

-- Respuesta: No es posible borrarlo solo con una consulta debido a la integridad referencial.
-- Si tiene registros relacionados en otras tablas (por ejemplo, en detalle_pedido o pago),
-- primero debes eliminar esos registros o actualizarlos para no hacer referencia al cliente
-- que se quiere borrar.

-- 14º.) Insertar una oficina con sede en Granada y tres empleados que sean representantes de ventas =

INSERT INTO oficina (codigo_oficina, ciudad, pais, codigo_postal, telefono, linea_direccion1)
VALUES ('GRA', 'Granada', 'España', '18001', '+34 987654321', 'Calle Gran Vía 789');

INSERT INTO empleado (codigo_empleado, nombre, apellido1, extension, email, codigo_oficina, puesto)
VALUES (1001, 'Ana', 'Garcia', 'x5678', 'ana@example.com', 'GRA', 'Representante de Ventas'),
       (1002, 'Pedro', 'Martinez', 'x9012', 'pedro@example.com', 'GRA', 'Representante de Ventas'),
       (1003, 'Maria', 'Lopez', 'x3456', 'maria@example.com', 'GRA', 'Representante de Ventas');

-- 15º.) Insertar tres clientes que tengan como representantes de ventas los empleados que hemos creado en el paso anterior =

INSERT INTO cliente (codigo_cliente, nombre_cliente, telefono, fax, linea_direccion1, ciudad, codigo_empleado_rep_ventas)
VALUES (6001, 'Cliente 1', '+34 111222333', '+34 111222334', 'Calle Cliente 123', 'Granada', 1001),
       (6002, 'Cliente 2', '+34 222333444', '+34 222333445', 'Calle Cliente 456', 'Granada', 1002),
       (6003, 'Cliente 3', '+34 333444555', '+34 333444556', 'Calle Cliente 789', 'Granada', 1003);

-- 16º.) Realizar una transacción que inserte un pedido para cada uno de los clientes, cada pedido debe incluir dos productos =

START TRANSACTION;

INSERT INTO pedido (codigo_pedido, fecha_pedido, fecha_esperada, estado, codigo_cliente)
VALUES (10001, '2024-02-20', '2024-02-25', 'En proceso', 6001),
       (10002, '2024-02-20', '2024-02-25', 'En proceso', 6002),
       (10003, '2024-02-20', '2024-02-25', 'En proceso', 6003);

INSERT INTO detalle_pedido (codigo_pedido, codigo_producto, cantidad, precio_unidad, numero_linea)
VALUES (10001, 'S10_1678', 2, 45.00, 1),
       (10001, 'S18_1374', 3, 60.00, 2),
       (10002, 'S18_1749', 1, 50.00, 1),
       (10002, 'S700_2824', 4, 75.00, 2),
       (10003, 'S10_1678', 3, 45.00, 1),
       (10003, 'S700_2824', 2, 75.00, 2);

COMMIT;

-- 17º.) Borrar uno de los clientes y comprobar si hubo cambios en las tablas relacionadas =

DELETE FROM cliente WHERE codigo_cliente = 6002;

-- Dato: Si no hubo cambios, modificar las tablas necesarias estableciendo la clave foránea con
-- la cláusula ON DELETE CASCADE. Por ejemplo:

ALTER TABLE detalle_pedido DROP FOREIGN KEY fk_pedido_cliente;
ALTER TABLE detalle_pedido ADD CONSTRAINT fk_pedido_cliente FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo_cliente) ON DELETE CASCADE;

-- 18º.) Realizar una transacción que realice los pagos de los pedidos que han realizado los clientes del ejercicio anterior =

START TRANSACTION;

INSERT INTO pago (codigo_cliente, forma_pago, id_transaccion, fecha_pago, total)
SELECT codigo_cliente, 'Tarjeta', CONCAT('TRANS-', codigo_pedido), CURDATE(), SUM(precio_unidad * cantidad)
FROM detalle_pedido
WHERE codigo_pedido IN (10001, 10003)
GROUP BY codigo_cliente;

COMMIT;