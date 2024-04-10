-- Lucía González Rosas
-- 1º. de DAW || 8 de marzo del 2024

-- =================================

-- 1º). Inserta un nuevo departamento "Ventas" con los campos necesarios =

INSERT INTO departamento VALUES(8, 'Ventas', 50000, 16500);

-- 2º.) Añade un nuevo empleado con NIF '98765432J', llamado Laura Martínez García, al departamento de Recursos Humanos =

INSERT INTO empleado VALUES(14, '98765432J', 'Laura', 'Martínez', 'García', 3);

-- 3º.) Actualiza el Presupuesto del departamento "I+D" incrementándolo en un 25% =

UPDATE departamento SET presupuesto = presupuesto + ((presupuesto / 100) * 75) WHERE nombre = 'I+D';

-- 4º.) Incrementa en un 20% el presupuesto de aquellos departamentos cuyos gastos superan el 75% de su presupuesto =

UPDATE departamento SET presupuesto = presupuesto + ((presupuesto / 100) * 20) WHERE gastos > ((presupuesto / 100) * 75);

-- 5º.) Elimina todos los departamentos que no tienen empleados =

DELETE FROM departamento WHERE id = 6;

-- 6º.) Elimina todos los empleados que no tienen un departamento asociado =

DELETE FROM empleado WHERE id_departamento = NULL;

-- 7º.) Elimina el departamento Desarrollo. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese posible borrarlo?

DELETE FROM departamento WHERE nombre = 'Desarrollo';

-- No es posible eliminar el departamento Desarrollo debido a que ya existen empleados asociados a dicho departamento. Si se quisiera realizar dicho
-- cambio, se debería de eliminar primero esos empleados (es decir, dejar al departamento Desarrollo sin empleados) para que funcionen los cambios.

-- 8º.) Actualiza el código del departamento Recursos Humanos y asígnale el valor 30. ¿Es posible actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?

UPDATE departamento SET id = 30 WHERE nombre = 'Recursos Humanos';

-- No es posible actualizar dicho valor debido a que el 'id' del departamento se considera como una clave primaria y auto-incrementada, lo que impide
-- realizar cambio alguno. Si se quisiera realizar dicho cambio, se debería eliminar dicho departamento y volverlo a crear para introducir, en su creación,
-- dicho valor.

-- 9º.) Hoy celebramos San Juan. Suma 1000€ a cada departamento, por cada empleado que tenga que contenga "Juan" en su nombre =

UPDATE departamento SET presupuesto = presupuesto + 1000 WHERE empleado.nombre = 'Juan%';

-- 10º.) En una sola transacción, mueve todos los empleados del departamento de nombre "Sistemas" al departamento "Desarrollo", luego elimina el departamento "Sistemas" =
BEGIN;
START TRANSACTION;
SELECT * FROM empleado WHERE id_departamento = 2;
JOIN INTO departamento WHERE id = 1,
END;
DELETE FROM departamento WHERE id = 2;