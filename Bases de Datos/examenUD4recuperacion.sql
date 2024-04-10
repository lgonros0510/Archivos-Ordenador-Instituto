-- Consultas sobre una tabla
-- ---------------------------------------------------------

-- 1. Devuelve todos los datos de los dos pedidos de mayor valor.
SELECT * FROM pedido WHERE total LIMIT 2 = (SELECT MAX(total) FROM pedido);

-- 2. Devuelve un listado con los identificadores de los clientes que han realizado algún pedido. Tenga en cuenta que no debe mostrar identificadores que estén repetidos.
SELECT id_cliente FROM pedido HAVING COUNT(id_cliente);

-- 3. Devuelve un listado con el nombre y los apellidos de los comerciales que tienen una comisión entre 0.05 y 0.11.
SELECT nombre, apellido1, apellido2 FROM comercial WHERE comisión > 0.05 AND comisión < 0.11;

-- 4. Devuelve un listado de los nombres de los clientes que no empiezan por A. El listado deberá estar ordenado alfabéticamente.
SELECT nombre FROM cliente ORDER BY cliente WHERE nombre != '%A%';


-- Consultas multitabla (composición interna con INNER JOIN)
-- ---------------------------------------------------------

-- 5. Devuelve un listado que muestre todos los pedidos en los que ha participado un comercial. El resultado debe mostrar todos los datos de los pedidos y de los comerciales. El listado debe mostrar los datos de los comerciales ordenados alfabéticamente.
SELECT * FROM pedido p
INNER JOIN comercial ON pedido.id_cliente = comercial.id
ORDER BY comercial;

-- 6. Devuelve el nombre de todos los clientes que han realizado algún pedido con el comercial 'Daniel Sáez Vega'.
SELECT nombre FROM cliente
INNER JOIN comercial ON cliente.id = comercial.id
WHERE comercial.nombre, comercial.apellido1, comercial.apellido2 AS nombre_comercial = 'Daniel Sáez Vega';

-- Consultas multitabla (Composición externa con LEFT JOIN y RIGHT JOIN)
-- ---------------------------------------------------------

-- 7. Devuelve un listado con todos los clientes junto con los datos de los pedidos que han realizado. Este listado también debe incluir los clientes que no han realizado ningún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los clientes.
SELECT * FROM cliente
LEFT JOIN pedido ON cliente.id = pedido.id
ORDER BY cliente.apellido1, cliente.apellido2, cliente.nombre AS orden_nuevo_cliente
WHERE pedido.id_cliente IS IN AND pedido.id_cliente IS NOT IN;

-- 8. Devuelve un listado con los clientes que no han realizado ningún pedido.
SELECT * FROM cliente
INNER JOIN pedido ON cliente.id = pedido.id
WHERE pedido.id_cliente != 9 AND pedido.id_cliente != 10;

-- ---------------------------------------------------------

-- 9. Calcula la cantidad total que suman todos los pedidos que aparecen en la tabla pedido.
SELECT SUM(total) FROM pedido;

-- 10. Devuelve el número total de pedidos que se han realizado cada año.
-- No sé cómo circula esto...


-- Subconsultas
-- ---------------------------------------------------------

-- 12. Devuelve un listado con todos los pedidos que ha realizado Adela Salas Díaz. (Usando operadores básicos de comparación, sin utilizar INNER JOIN).
SELECT * FROM pedido WHERE id_cliente = 2;

-- 13. Devuelve el pedido más caro que existe en la tabla pedido (Usando ALL / ANY, sin hacer uso de MAX, ORDER BY ni LIMIT).
SELECT * FROM pedido WHERE total >= ALL (SELECT total FROM pedido); 

-- 14. Devuelve un listado de los clientes que no han realizado ningún pedido. (Utilizando IN o NOT IN).
SELECT * FROM pedido WHERE id_cliente IS NOT IN;

-- 15. Devuelve un listado de los clientes que no han realizado ningún pedido. (Utilizando EXISTS o NOT EXISTS).
SELECT * FROM pedido WHERE id_cliente NOT EXISTS;


-- Examen realizado por Lucía González Rosas
-- 1º. de DAW
-- 15 de marzo del 2024