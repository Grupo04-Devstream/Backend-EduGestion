-- Roles

INSERT INTO roles (nombre, descripcion) VALUES ('Trabajador', 'Trabajador de la institución'), ('Estudiante', 'Estudiante de la institución');

-- Niveles

INSERT INTO niveles (nombre) VALUES ('Preescolar'), ('Primaria'), ('Secundaria');

-- Grados

INSERT INTO grados (id_nivel, gradonro) VALUES (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (3, 1), (3, 2), (3, 3), (3, 4), (3, 5);

-- Usuarios

INSERT INTO usuarios (id_rol, nombre, apellido, email, password) VALUES (1, 'Juan', 'Perez', 'example@example.com', '123456'), (2, 'Maria', 'Gonzalez', 'maria@gmail.com', '123456');

-- Aulas

INSERT INTO aulas (descripcion, piso, capacidad, pabellon) VALUES ('azul', 1, 20, 1), ('azul', 2, 21, 1), ('azul', 3, 22, 1), ('verde', 1, 23, 2), ('verde', 2, 24, 2), ('verde', 3, 25, 2), ('rojo', 1, 26, 1), ('rojo', 2, 27, 1), ('rojo', 3, 28, 1), ('azul', 1, 29, 2), ('azul', 2, 30, 2), ('azul', 3, 31, 2), ('verde', 1, 32, 1), ('verde', 2, 33, 1);