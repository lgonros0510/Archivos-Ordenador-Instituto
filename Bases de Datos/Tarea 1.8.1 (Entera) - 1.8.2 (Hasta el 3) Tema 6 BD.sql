-- --->>> EJERCICIOS TEMA 6 MYSQL (PROCEDIMIENTOS) <<<---

-- --->>> Lucía González Rosas <<<---
-- --->>> 1º. de DAW || 3 de abril del 2024 <<<---

-- ============================ TAREA 1.8.1 ============================

-- 1º.) Escribe un procedimiento que no tenga ningún parámetro de entrada ni de salida y que muestre el texto ¡Hola mundo! =

DELIMITER $$

CREATE PROCEDURE SaludarMundo()
BEGIN
SELECT '¡Hola mundo!' AS Mensaje;
END
$$

DELIMITER ;

CALL SaludarMundo(Mensaje);

-- 2º.) Escribe un procedimiento que reciba un número real de entrada y muestre un mensaje indicando si el número es positivo, negativo o cero =

DELIMITER $$

CREATE PROCEDURE DeterminarSigno(IN numero REAL)
BEGIN
IF numero > 0 THEN
SELECT 'El número introducido es positivo.';
ELSEIF numero < 0 THEN
SELECT 'El número introducido es negativo.';
ELSE
SELECT 'El número introducido es igual a cero.';
END IF;
END
$$

DELIMITER ;

CALL DeterminarSigno(5);

-- 3º.) Modifique el procedimiento diseñado en el ejercicio anterior para que tenga un parámetro de entrada, con el valor un número real, y un parámetro de
--      salida, con una cadena de caracteres indicando si el número es positivo, negativo o cero =
     
DELIMITER $$

CREATE PROCEDURE DeterminarSigno_2(IN numero REAL, OUT que_es VARCHAR(50))
BEGIN
IF numero > 0 THEN
SELECT 'El número introducido es positivo.' AS que_es;
ELSEIF numero < 0 THEN
SELECT 'El número introducido es negativo.' AS que_es;
ELSE
SELECT 'El número introducido es igual a cero.' AS que_es;
END IF;
END
$$

DELIMITER ;

CALL DeterminarSigno_2(9, que_es);

-- 4º.) Escribe un procedimiento que reciba un número real de entrada, que representa el valor de la nota de un alumno, y muestre un mensaje indicando qué
--      nota ha obtenido teniendo en cuenta las siguientes condiciones:

-- [0,5) = Insuficiente
-- [5,6) = Aprobado
-- [6, 7) = Bien
-- [7, 9) = Notable
-- [9, 10] = Sobresaliente

-- +  Nota: En cualquier otro caso la nota no será válida.

DELIMITER $$

CREATE PROCEDURE NotaAlumno(IN nota REAL, OUT resultado VARCHAR(20))
BEGIN
CASE 
WHEN nota >= 0 AND nota < 5 THEN SELECT 'Insuficiente' AS resultado;
WHEN nota >= 5 AND nota < 6 THEN SELECT 'Aprobado' AS resultado;
WHEN nota >= 6 AND nota < 7 THEN SELECT 'Bien' AS resultado;
WHEN nota >= 7 AND nota < 9 THEN SELECT 'Notable' AS resultado;
WHEN nota >= 9 AND nota <= 10 THEN SELECT 'Sobresaliente' AS resultado;
ELSE SELECT 'Dicha nota no es válida.' AS resultado;
END CASE;
END
$$

DELIMITER ;

CALL NotaAlumno(8.5, resultado);

-- 5º.) Modifique el procedimiento diseñado en el ejercicio anterior para que tenga un parámetro de entrada, con el valor de la nota en formato numérico y
--      un parámetro de salida, con una cadena de texto indicando la nota correspondiente =

DELIMITER $$

CREATE PROCEDURE ObtenerDiaIF(IN diaSemana INT, OUT nombreDia VARCHAR(20))
BEGIN
IF diaSemana = 1 THEN
SELECT 'Lunes' AS nombreDia;
ELSEIF diaSemana = 2 THEN
SELECT 'Martes' AS nombreDia;
ELSEIF diaSemana = 3 THEN
SELECT 'Miércoles' AS nombreDia;
ELSEIF diaSemana = 4 THEN
SELECT 'Jueves' AS nombreDia;
ELSEIF diaSemana = 5 THEN
SELECT 'Viernes' AS nombreDia;
ELSEIF diaSemana = 6 THEN
SELECT 'Sábado' AS nombreDia;
ELSEIF diaSemana = 7 THEN
SELECT 'Domingo' AS nombreDia;
ELSE
SET nombreDia = 'Dicho día no es válido.';
END IF;
END
$$

DELIMITER ;

CALL ObtenerDiaIF(5, nombreDia);

-- 6º.) Resuelva el procedimiento diseñado en el ejercicio anterior haciendo uso de la estructura de control CASE =

DELIMITER $$

CREATE PROCEDURE ObtenerDiaCASE(IN diaSemana INT, OUT nombreDia VARCHAR(20))
BEGIN
CASE diaSemana
WHEN 1 THEN SELECT 'Lunes' AS nombreDia;
WHEN 2 THEN SELECT 'Martes' AS nombreDia;
WHEN 3 THEN SELECT 'Miércoles' AS nombreDia;
WHEN 4 THEN SELECT 'Jueves' AS nombreDia;
WHEN 5 THEN SELECT 'Viernes' AS nombreDia;
WHEN 6 THEN SELECT 'Sábado' AS nombreDia;
WHEN 7 THEN SELECT 'Domingo' AS nombreDia;
ELSE SELECT 'Dicho día no es válido.' AS nombreDia;
END CASE;
END
$$

DELIMITER ;

CALL ObtenerDiaCASE(8, nombreDia);

-- 7º.) Escribe un procedimiento que reciba como parámetro de entrada un valor numérico que represente un día de la semana y que devuelva una cadena de
--      caracteres con el nombre del día de la semana correspondiente. Por ejemplo, para el valor de entrada 1 debería devolver la cadena lunes. Resuelva
--      el procedimiento haciendo uso de la estructura de control IF =

DELIMITER $$

CREATE PROCEDURE ObtenerDiaIF_2(IN diaSemana INT, OUT nombreDia VARCHAR(20))
BEGIN
IF diaSemana = 1 THEN
SELECT 'Lunes' AS nombreDia;
ELSEIF diaSemana = 2 THEN
SELECT 'Martes' AS nombreDia;
ELSEIF diaSemana = 3 THEN
SELECT 'Miércoles' AS nombreDia;
ELSEIF diaSemana = 4 THEN
SELECT 'Jueves' AS nombreDia;
ELSEIF diaSemana = 5 THEN
SELECT 'Viernes' AS nombreDia;
ELSEIF diaSemana = 6 THEN
SELECT 'Sábado' AS nombreDia;
ELSEIF diaSemana = 7 THEN
SELECT 'Domingo' AS nombreDia;
ELSE
SELECT 'Dicho día no es válido.' AS nombreDia;
END IF;
END
$$

DELIMITER ;

CALL ObtenerDiaIF_2(8, nombreDia);

-- 8º.) Resuelva el procedimiento diseñado en el ejercicio anterior haciendo uso de la estructura de control CASE =

DELIMITER $$

CREATE PROCEDURE ObtenerDiaCASE_2(IN diaSemana INT, OUT nombreDia VARCHAR(20))
BEGIN
CASE diaSemana
WHEN 1 THEN SELECT 'Lunes' AS nombreDia;
WHEN 2 THEN SELECT 'Martes' AS nombreDia;
WHEN 3 THEN SELECT 'Miércoles' AS nombreDia;
WHEN 4 THEN SELECT 'Jueves' AS nombreDia;
WHEN 5 THEN SELECT 'Viernes' AS nombreDia;
WHEN 6 THEN SELECT 'Sábado' AS nombreDia;
WHEN 7 THEN SELECT 'Domingo' AS nombreDia;
ELSE SELECT 'Dicho día no es válido.' AS nombreDia;
END CASE;
END
$$

DELIMITER ;

CALL ObtenerDiaCASE_2(2, nombreDia);

-- ============================ TAREA 1.8.2 ============================

-- 1º.) Escribe un procedimiento que reciba el nombre de un país como parámetro de entrada y realice una consulta sobre la tabla cliente para obtener
--      todos los clientes que existen en la tabla de ese país =

DELIMITER $$
CREATE PROCEDURE ObtenerClientes(IN pais_param VARCHAR(50))
BEGIN
SELECT * FROM cliente WHERE pais = pais_param;
END
$$

DELIMITER ;

CALL ObtenerClientes(pais_param);

-- 2º.) Escribe un procedimiento que reciba como parámetro de entrada una forma de pago, que será una cadena de caracteres (Ejemplo: PayPal, Transferencia,
--      etc). Y devuelva como salida el pago de máximo valor realizado para esa forma de pago. Deberá hacer uso de la tabla pago de la base de datos
--      jardineria =

DELIMITER $$
CREATE PROCEDURE ObtenerPagoMaximo(IN forma_pago_param VARCHAR(40), OUT pago_maximo NUMERIC(15,2))
BEGIN
SELECT MAX(total) INTO pago_maximo FROM pago WHERE forma_pago = forma_pago_param;
END
$$

DELIMITER ;

CALL ObtenerPagoMaximo(forma_pago_param, pago_maximo);

-- 3º.) Escribe un procedimiento que reciba como parámetro de entrada una forma de pago, que será una cadena de caracteres (Ejemplo: PayPal, Transferencia,
--      etc). Y devuelva como salida los siguientes valores teniendo en cuenta la forma de pago seleccionada como parámetro de entrada:

-- El pago de máximo valor.
-- El pago de mínimo valor.
-- El valor medio de los pagos realizados.
-- La suma de todos los pagos.
-- El número de pagos realizados para esa forma de pago.

-- Nota: Deberá hacer uso de la tabla pago de la base de datos jardineria.

DELIMITER $$
CREATE PROCEDURE ObtenerInformacionPago(IN forma_pago_param VARCHAR(40), OUT pago_maximo NUMERIC(15,2), OUT pago_minimo NUMERIC(15,2),
OUT valor_medio NUMERIC(15,2), OUT suma_total NUMERIC(15,2), OUT numero_pagos INT)
BEGIN
SELECT MAX(total), MIN(total), AVG(total), SUM(total), COUNT(*) INTO pago_maximo, pago_minimo, valor_medio, suma_total, numero_pagos
FROM pago WHERE forma_pago = forma_pago_param;
END
$$

DELIMITER ;

CALL ObtenerInformacionPago(forma_pago_param, pago_maximo, pago_minimo, valor_medio, suma_total, numero_pagos);