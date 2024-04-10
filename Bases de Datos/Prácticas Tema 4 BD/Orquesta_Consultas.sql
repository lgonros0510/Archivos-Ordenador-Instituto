CREATE DATABASE IF NOT EXISTS orchestra_database;
USE orchestra_database;

CREATE TABLE IF NOT EXISTS orchestras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    rating INT,
    city_origin VARCHAR(255),
    country_origin VARCHAR(255),
    year_founded INT
);

CREATE TABLE IF NOT EXISTS concerts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(255),
    country VARCHAR(255),
    year INT,
    rating INT,
    orchestra_id INT,
    FOREIGN KEY (orchestra_id) REFERENCES orchestras(id)
);

CREATE TABLE IF NOT EXISTS members (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    position VARCHAR(255),
    wage DECIMAL(10, 2),
    experience INT,
    orchestra_id INT,
    FOREIGN KEY (orchestra_id) REFERENCES orchestras(id)
);

INSERT INTO orchestras (name, rating, city_origin, country_origin, year)
VALUES
('Orquesta Filarmónica', 5, 'Berlín', 'Alemania', 1882),
('Orquesta Sinfónica', 4, 'Londres', 'Reino Unido', 1904),
('Orquesta Filarmónica', 4, 'Viena', 'Austria', 1842),
('Orquesta Nacional', 3, 'Madrid', 'España', 1937),
('Orquesta de Cámara', 4, 'Munich', 'Alemania', 1950),
('Orquesta de Cámara', 3, 'Zurich', 'Suiza', 1945),
('Orquesta de Cámara', 4, 'París', 'Francia', 1920),
('Orquesta de Cámara', 5, 'Moscú', 'Rusia', 1960);

INSERT INTO concerts (city, country, year, rating, orchestra_id)
VALUES
('Nueva York', 'Estados Unidos', 2023, 4, 1),
('París', 'Francia', 2024, 3, 2),
('Viena', 'Austria', 2024, 4, 3),
('Barcelona', 'España', 2023, 3, 4),
('Munich', 'Alemania', 2023, 4, 5),
('Zurich', 'Suiza', 2024, 3, 6),
('París', 'Francia', 2023, 4, 7),
('Moscú', 'Rusia', 2024, 5, 8);

INSERT INTO members (name, position, wage, experience, orchestra_id)
VALUES ('John Smith', 'Violinista', 5000, 10, 1),
('Maria Garcia', 'Violonchelista', 5500, 8, 2),
('Anna Müller', 'Flautista', 4800, 6, 3),
('Pedro López', 'Trompetista', 4200, 8, 4),
('Sophie Schmidt', 'Violista', 4500, 7, 5),
('Markus Weber', 'Violonchelista', 4800, 9, 6),
('Claire Martin', 'Violinista', 4200, 6, 7),
('Ivan Petrov', 'Contrabajista', 5000, 10, 8);

-- 1º.) Seleccionar las orquestas con ciudad de origen donde se celebró un concierto en 2013 =
SELECT name FROM orchestras WHERE city_origin IN (SELECT city FROM concerts WHERE year = 2013);

-- 2º.) Seleccionar los miembros que pertenezcan a orquestas muy valoradas =
SELECT name, position FROM members
WHERE experience > 10 AND orchestra_id NOT IN (SELECT id FROM orchestras WHERE rating < 8);

-- 3º.) Seleccionar los miembros que ganan más que los violinistas =
SELECT name, position FROM members
WHERE wage > (SELECT AVG(wage) FROM members WHERE position = 'Violinista');

-- 4º.) Seleccionar orquestas de alta calificación más recientes que la Orquesta de Cámara =
SELECT name FROM orchestras
WHERE year > (SELECT year FROM orchestras WHERE name = 'Orquesta de Cámara')
AND rating > 7.5;

-- 5º.) Seleccionar los intérpretes en grandes orquestas =
SELECT o.name, COUNT(m.id) FROM orchestras o
JOIN members m ON o.id = m.orchestra_id GROUP BY o.name
HAVING COUNT(m.id) > (SELECT AVG(d.count) FROM (SELECT orchestra_id, COUNT(id)
FROM members GROUP BY orchestra_id) AS d);