-- Roles

INSERT INTO rol (nombre, descripcion) VALUES ('Trabajador', 'Trabajador de la institución'), ('Estudiante', 'Estudiante de la institución');

-- Niveles

INSERT INTO nivel (nombre) VALUES ('Preescolar'), ('Primaria'), ('Secundaria');

-- Grados

INSERT INTO grado (id_nivel, nro_grado) VALUES (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (3, 1), (3, 2), (3, 3), (3, 4), (3, 5);