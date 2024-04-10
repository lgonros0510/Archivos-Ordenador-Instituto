/*
Consultas multitabla (Composición interna)
Las consultas se deben resolver con INNER JOIN y NATURAL JOIN.
*/

-- 1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
SELECT nombre_cliente, nombre_contacto, apellido_contacto
FROM cliente
INNER JOIN empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado;

-- 2. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.
SELECT nombre_cliente, nombre_contacto, apellido_contacto
FROM cliente
LEFT JOIN pago ON codigo_cliente = pago.codigo_cliente
INNER JOIN empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
WHERE pago.codigo_cliente IS NULL;

-- 3. Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
SELECT nombre_cliente, nombre_contacto, apellido_contacto, oficina.ciudad
FROM cliente
LEFT JOIN pago ON cliente.codigo_cliente = pago.codigo_cliente
INNER JOIN empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
INNER JOIN oficina ON empleado.codigo_oficina = oficina.codigo_oficina
WHERE pago.codigo_cliente IS NULL;

-- 4. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
SELECT nombre_cliente, nombre_contacto, apellido_contacto, oficina.ciudad
FROM cliente
INNER JOIN empleado ON cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
INNER JOIN oficina ON empleado.codigo_oficina = oficina.codigo_oficina;

-- 5. Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefes.
SELECT e1.nombre, e2.nombre AS jefe_directo, e3.nombre AS jefe_del_jefe
FROM empleado e1
LEFT JOIN empleado e2 ON e1.codigo_jefe = e2.codigo_empleado
LEFT JOIN empleado e3 ON e2.codigo_jefe = e3.codigo_empleado;

-- 6. Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
SELECT nombre_cliente, GROUP_CONCAT(DISTINCT producto.gama) AS gamas_compradas
FROM cliente
INNER JOIN pedido ON cliente.codigo_cliente = pedido.codigo_cliente
INNER JOIN detalle_pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
INNER JOIN producto ON detalle_pedido.codigo_producto = producto.codigo_producto
GROUP BY cliente.nombre_cliente;

/*
Consultas multitabla (Composición externa)
Resuelva todas las consultas utilizando las cláusulas LEFT JOIN, RIGHT JOIN, NATURAL LEFT JOIN y NATURAL RIGHT JOIN.
*/

-- 7. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
SELECT nombre_cliente
FROM cliente
LEFT JOIN pago ON cliente.codigo_cliente = pago.codigo_cliente
WHERE pago.codigo_cliente IS NULL;

-- 8. Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.
SELECT nombre_cliente
FROM cliente
LEFT JOIN pago ON cliente.codigo_cliente = pago.codigo_cliente
LEFT JOIN pedido ON cliente.codigo_cliente = pedido.codigo_cliente
WHERE pago.codigo_cliente IS NULL AND pedido.codigo_pedido IS NULL;

-- 9. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
SELECT nombre, apellido1, apellido2
FROM empleado
LEFT JOIN cliente ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
WHERE cliente.codigo_cliente IS NULL;

-- 10. Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.
SELECT nombre, apellido1, apellido2
FROM empleado
LEFT JOIN oficina ON empleado.codigo_oficina = oficina.codigo_oficina
LEFT JOIN cliente ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
WHERE oficina.codigo_oficina IS NULL OR cliente.codigo_cliente IS NULL;

-- 11. Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto.
SELECT nombre, descripcion, dimensiones
FROM producto
LEFT JOIN detalle_pedido ON producto.codigo_producto = detalle_pedido.codigo_producto
WHERE detalle_pedido.codigo_pedido IS NULL;

-- 12. Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.
SELECT nombre_cliente
FROM cliente
LEFT JOIN pedido ON cliente.codigo_cliente = pedido.codigo_cliente
LEFT JOIN pago ON cliente.codigo_cliente = pago.codigo_cliente
WHERE pedido.codigo_pedido IS NOT NULL AND pago.codigo_cliente IS NULL;

/*
 Consultas resumen
*/

-- 13. ¿Cuántos empleados hay en la compañía?
SELECT COUNT(*) AS cantidad_empleados
FROM empleado;

-- 14. ¿Cuántos clientes tiene cada país?
SELECT pais, COUNT(*) AS cantidad_clientes
FROM cliente
GROUP BY pais;

-- 15. ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
SELECT estado, COUNT(*) AS cantidad_pedidos
FROM pedido
GROUP BY estado
ORDER BY cantidad_pedidos DESC;

-- 16. ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?
SELECT COUNT(*) AS cantidad_clientes_madrid
FROM cliente
WHERE ciudad = 'Madrid';

-- 17. Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.
SELECT nombre, COUNT(cliente.codigo_cliente) AS cantidad_clientes_atendidos
FROM empleado
LEFT JOIN cliente ON empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
GROUP BY empleado.nombre;

-- 18. Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar el nombre y los apellidos de cada cliente.
SELECT nombre_cliente, MIN(pago.fecha_pago) AS primer_pago, MAX(pago.fecha_pago) AS ultimo_pago
FROM cliente
LEFT JOIN pago ON cliente.codigo_cliente = pago.codigo_cliente
GROUP BY cliente.nombre_cliente;

-- 19. Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos.
SELECT pedido.codigo_pedido, SUM(detalle_pedido.cantidad * producto.precio) AS total_pedido
FROM pedido
LEFT JOIN detalle_pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
LEFT JOIN producto ON detalle_pedido.codigo_producto = producto.codigo_producto
GROUP BY pedido.codigo_pedido;

-- 20. La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el total facturado. La base imponible se calcula sumando el coste del producto por el número de unidades vendidas de la tabla detalle_pedido. El IVA es el 21 % de la base imponible, y el total la suma de los dos campos anteriores.
SELECT SUM(cantidad * precio_unidad) AS base_imponible
FROM detalle_pedido;

SELECT 0.21 * SUM(cantidad * precio_unidad) AS iva
FROM detalle_pedido;

SELECT SUM(cantidad * precio_unidad) + 0.21 * SUM(cantidad * precio_unidad) AS total_facturado
FROM detalle_pedido;


