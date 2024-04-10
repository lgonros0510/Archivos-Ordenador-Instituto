CREATE DATABASE IF NOT EXISTS pruebas;
USE pruebas;

CREATE TABLE tblUsuarios (
   idx INT PRIMARY KEY AUTO_INCREMENT,
   usuario VARCHAR(20),
   nombre VARCHAR(20),
   sexo VARCHAR(1),
   nivel TINYINT,
   email VARCHAR(50),
   telefono VARCHAR(20),
   marca VARCHAR(20),
   compañia VARCHAR(20),
   saldo FLOAT,
   activo BOOLEAN
);

INSERT INTO tblUsuarios 
VALUES 
('1','BRE2271','BRENDA','M','2','brenda@live.com','655-330-5736','SAMSUNG','IUSACELL','100','1'),
('2','OSC4677','OSCAR','H','3','oscar@gmail.com','655-143-4181','LG','TELCEL','0','1'),
('3','JOS7086','JOSE','H','3','francisco@gmail.com','655-143-3922','NOKIA','MOVISTAR','150','1'),
('4','LUI6115','LUIS','H','0','enrique@outlook.com','655-137-1279','SAMSUNG','TELCEL','50','1'),
('5','LUI7072','LUIS','H','1','luis@hotmail.com','655-100-8260','NOKIA','IUSACELL','50','0'),
('6','DAN2832','DANIEL','H','0','daniel@outlook.com','655-145-2586','SONY','UNEFON','100','1'),
('7','JAQ5351','JAQUELINE','M','0','jaqueline@outlook.com','655-330-5514','BLACKBERRY','AXEL','0','1'),
('8','ROM6520','ROMAN','H','2','roman@gmail.com','655-330-3263','LG','IUSACELL','50','1'),
('9','BLA9739','BLAS','H','0','blas@hotmail.com','655-330-3871','LG','UNEFON','100','1'),
('10','JES4752','JESSICA','M','1','jessica@hotmail.com','655-143-6861','SAMSUNG','TELCEL','500','1'),
('11','DIA6570','DIANA','M','1','diana@live.com','655-143-3952','SONY','UNEFON','100','0'),
('12','RIC8283','RICARDO','H','2','ricardo@hotmail.com','655-145-6049','MOTOROLA','IUSACELL','150','1'),
('13','VAL6882','VALENTINA','M','0','valentina@live.com','655-137-4253','BLACKBERRY','AT&T','50','0'),
('14','BRE8106','BRENDA','M','3','brenda2@gmail.com','655-100-1351','MOTOROLA','NEXTEL','150','1'),
('15','LUC4982','LUCIA','M','3','lucia@gmail.com','655-145-4992','BLACKBERRY','IUSACELL','0','1'),
('16','JUA2337','JUAN','H','0','juan@outlook.com','655-100-6517','SAMSUNG','AXEL','0','0'),
('17','ELP2984','ELPIDIO','H','1','elpidio@outlook.com','655-145-9938','MOTOROLA','MOVISTAR','500','1'),
('18','JES9640','JESSICA','M','3','jessica2@live.com','655-330-5143','SONY','IUSACELL','200','1'),
('19','LET4015','LETICIA','M','2','leticia@yahoo.com','655-143-4019','BLACKBERRY','UNEFON','100','1'),
('20','LUI1076','LUIS','H','3','luis2@live.com','655-100-5085','SONY','UNEFON','150','1'),
('21','HUG5441','HUGO','H','2','hugo@live.com','655-137-3935','MOTOROLA','AT&T','500','1');

-- |===========================================1º. BLOQUE===========================================|

-- 1º.) Lista los nombres de los usuarios =
SELECT nombre FROM tblUsuarios;

-- 2º.) Calcula el saldo máximo de los usuarios de sexo “Mujer” =
SELECT MAX(saldo) FROM tblUsuarios WHERE sexo = 'M';

-- 3º.) Lista el nombre y el teléfono de los usuarios con un teléfono NOKIA, BLACKBERRY o SONY =
SELECT nombre, telefono FROM tblUsuarios WHERE marca IN('NOKIA', 'BLACKBERRY', 'SONY');

-- 4º.) Cuenta el número de usuarios sin saldo o inactivos =
SELECT COUNT(*) FROM tblUsuarios WHERE NOT activo OR saldo <= 0;

-- 5º.) Lista el "login" de los usuarios con nivel 1, 2 o 3 =
SELECT usuario FROM tblUsuarios WHERE nivel IN(1, 2, 3);

-- 6º.) Lista los números de teléfono con un saldo menor o igual a 300 =
SELECT telefono FROM tblUsuarios WHERE saldo <= 300;

-- 7º.) Calcula la suma de los saldos de los usuarios de la compañia telefónica NEXTEL =
SELECT SUM(saldo) FROM tblUsuarios WHERE compañia = 'NEXTEL';

-- 8º.) Cuenta el número de usuarios por su compañía telefónica =
SELECT compañia, COUNT(*) FROM tblUsuarios GROUP BY compañia;

-- 9º.) Cuenta el número de usuarios por su nivel =
SELECT nivel, COUNT(*) FROM tblUsuarios GROUP BY nivel;

-- 10º.) Lista el "login" de los usuarios con nivel 2 =
SELECT usuario FROM tblUsuarios WHERE nivel = 2;

-- 11º.) Muestra el email de los usuarios que usan "gmail" =
SELECT email FROM tblUsuarios WHERE email LIKE '%gmail.com';

-- 12º.) Lista el nombre y el teléfono de los usuarios con un teléfono LG, SAMSUNG o MOTOROLA =
SELECT nombre, telefono FROM tblUsuarios WHERE marca IN('LG', 'SAMSUNG', 'MOTOROLA');

-- |===========================================2º. BLOQUE===========================================|

-- 1º.) Lista el nombre y el teléfono de los usuarios con un teléfono que no sea de la marca LG o SAMSUNG =
SELECT nombre, telefono FROM tblUsuarios WHERE marca NOT IN('LG', 'SAMSUNG');

-- 2º.) Lista el "login" y el teléfono de los usuarios con la compañia telefónica IUSACELL =
SELECT usuario, telefono FROM tblUsuarios WHERE compañia = 'IUSACELL';

-- 3º.) Lista el "login" y el teléfono de los usuarios con la compañia telefónica que no sea TELCEL =
SELECT usuario, telefono FROM tblUsuarios WHERE compañia <> "TELCEL";

-- 4º.) Calcula el saldo promedio de los usuarios que tienen un teléfono marca NOKIA =
SELECT AVG(saldo) FROM tblUsuarios WHERE marca = 'NOKIA';

-- 5º.) Lista el "login" y el teléfono de los usuarios con la compañia telefónica IUSACELL o AXEL =
SELECT usuario, telefono FROM tblUsuarios WHERE compañia IN('IUSACELL', 'AXEL');

-- 6º.) Muestra el email de los usuarios que no usan "yahoo" =
SELECT email FROM tblUsuarios WHERE email NOT LIKE '%yahoo.com';

-- 7º.) Lista el "login" y el teléfono de los usuarios con la compañia telefónica que no sea TELCEL o IUSACELL =
SELECT usuario, telefono FROM tblUsuarios WHERE compañia NOT IN('TELCEL', 'IUSACELL');

-- 8º.) Lista el "login" y el teléfono de los usuarios con la compañia telefónica UNEFON =
SELECT usuario, telefono FROM tblUsuarios WHERE compañia = 'UNEFON';

-- 9º.) Lista las diferentes marcas de celular en orden alfabético descendentemente =
SELECT DISTINCT marca FROM tblUsuarios ORDER BY marca DESC;

-- 10º.) Lista las diferentes compañias en orden alfabético aleatorio =
SELECT DISTINCT compañia FROM tblUsuarios ORDER BY RAND();

-- 11º.) Lista el "login" de los usuarios con nivel 0 o 2 =
SELECT usuario FROM tblUsuarios WHERE nivel IN(0, 2);

-- 12º.) Calcula el saldo promedio de los usuarios que tienen un teléfono marca LG =
SELECT AVG(saldo) FROM tblUsuarios WHERE marca = 'LG';

-- |===========================================3º. BLOQUE===========================================|

-- 1º.) Lista el "login" de los usuarios con nivel 1 o 3 =
SELECT usuario FROM tblUsuarios WHERE nivel IN(1, 3);

--2º.) Lista el nombre y el teléfono de los usuarios con un teléfono que no sea de la marca BLACKBERRY = 
SELECT nombre, telefono FROM tblUsuarios WHERE marca <> "BLACKBERRY";

-- 3º.) Lista el "login" de los usuarios con nivel 3 =
SELECT usuario FROM tblUsuarios WHERE nivel = 3;

-- 4º.) Lista el "login" de los usuarios con nivel 0 =
SELECT usuario FROM tblUsuarios WHERE nivel = 0;

-- 5º.) Lista el "login" de los usuarios con nivel 1 =
SELECT usuario FROM tblUsuarios WHERE nivel = 1;

-- 6º.) Cuenta el número de usuarios por su sexo =
SELECT sexo, COUNT(*) FROM tblUsuarios GROUP BY sexo;

-- 7º.) Lista el "login" y el teléfono de los usuarios con la compañia telefónica AT&T =
SELECT usuario, telefono FROM tblUsuarios WHERE compañia = "AT&T";

-- 8º.) Lista las diferentes compañias en orden alfabético descendentemente =
SELECT DISTINCT compañia FROM tblUsuarios ORDER BY compañia DESC;

-- 9º.) Lista el "login2 de los usuarios inactivos =
SELECT usuario FROM tblUsuarios WHERE NOT activo;

-- 10º.) Lista los números de teléfono sin saldo =
SELECT telefono FROM tblUsuarios WHERE saldo <= 0;

-- 11º.) Calcula el saldo mínimo de los usuarios de sexo "Hombre" =
SELECT MIN(saldo) FROM tblUsuarios WHERE sexo = 'H';

-- 12º.) Lista los números de teléfono con un saldo mayor a 300 =
SELECT telefono FROM tblUsuarios WHERE saldo > 300;

-- |===========================================4º. BLOQUE===========================================|

-- 1º.) Cuenta el número de usuarios por su marca de teléfono =
SELECT marca, COUNT(*) FROM tblUsuarios GROUP BY marca;

-- 2º.) Lista el nombre y el teléfono de los usuarios con un teléfono que no sea de la marca LG =
SELECT nombre, telefono FROM tblUsuarios WHERE marca <> "LG";

-- 3º.) Lista las diferentes compañias en orden alfabético ascendentemente =
SELECT DISTINCT compañia FROM tblUsuarios ORDER BY compañia ASC;

-- 4º.) Calcula la suma de los saldos de los usuarios de la compañia telefónica UNEFON =
SELECT SUM(saldo) FROM tblUsuarios WHERE compañia = 'UNEFON';

-- 5º.) Muestra el email de los usuarios que usan "hotmail" =
SELECT email FROM tblUsuarios WHERE email LIKE "%hotmail.com";

-- 6º.) Lista los nombres de los usuarios sin saldo o inactivos =
SELECT nombre FROM tblUsuarios WHERE NOT activo OR saldo <= 0;

-- 7º.) Lista el "login" y el teléfono de los usuarios con la compañia telefónica IUSACELL o TELCEL =
SELECT usuario, telefono FROM tblUsuarios WHERE compañia IN('IUSACELL', 'TELCEL');

-- 8º.) Lista las diferentes marcas de celular en orden alfabético ascendentemente =
SELECT DISTINCT marca FROM tblUsuarios ORDER BY marca DESC;

-- 9º.) Lista las diferentes marcas de celular en orden alfabético aleatorio =
SELECT DISTINCT marca FROM tblUsuarios ORDER BY RAND();

-- 10º.) Lista el "login" y el teléfono de los usuarios con la compañia telefónica IUSACELL o UNEFON =
SELECT usuario, telefono FROM tblUsuarios WHERE compañia IN('IUSACELL', 'UNEFON');

-- 11º.) Lista el nombre y el teléfono de los usuarios con un teléfono que no sea de la marca MOTOROLA o NOKIA =
SELECT nombre, telefono FROM tblUsuarios WHERE marca NOT IN('MOTOROLA', 'NOKIA');

--12º.) Calcula la suma de los saldos de los usuarios de la compañia telefónica TELCEL =
SELECT SUM(saldo) FROM tblUsuarios WHERE compañia = 'TELCEL';