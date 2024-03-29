-- Roles

INSERT INTO roles (nombre, descripcion) VALUES ('Trabajador', 'Trabajador de la institución'), ('Estudiante', 'Estudiante de la institución');

-- Niveles

INSERT INTO niveles (nombre) VALUES ('Preescolar'), ('Primaria'), ('Secundaria');

-- Grados

INSERT INTO grados (id_nivel, gradonro) VALUES (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (3, 1), (3, 2), (3, 3), (3, 4), (3, 5);


-- Departamentos
INSERT INTO departamentos (nombre, descripcion) VALUES  ('Administrativo', 'Encargado de administrar los recursos de la organización'),('Docencia', 'Dictado de clases a los estudiantes de la institución'),('Direccion', 'Máximos representantes de la institución'),  ('Personal de Limpieza', 'Encargados de mantener la limpieza en todos los ambientes de la institución'),('Adicional', 'Desempeñan otro tipo de labores en la institución');

-- Usuarios

INSERT INTO usuarios (id_rol, nombre, apellido, fecha_nacimiento, email, password) VALUES (1, 'Juan', 'Perez', '1990-01-01', 'example@example.com', '123456'), (2, 'Maria', 'Gonzalez', '2000-01-01', 'maria@gmail.com', '123456');