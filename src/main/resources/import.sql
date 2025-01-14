-- Insert data into Alumno --
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('12345678-9', 'Juan Perez', 'Calle 123');
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('98765432-1', 'Maria Lopez', 'Avenida Siempre Viva');
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('12312312-3', 'Carlos Gonzalez', 'Calle Falsa 123');
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('11111111-1', 'Ana Torres', 'Boulevard Principal');
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('22222222-2', 'Luis Martinez', 'Pasaje Secundario');
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('33333333-3', 'Sofia Ramirez', 'Plaza Central');
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('44444444-4', 'Diego Herrera', 'Calle Luna');
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('55555555-5', 'Laura Fernandez', 'Calle Sol');
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('66666666-6', 'Pedro Castillo', 'Calle Mar');
INSERT INTO alumnos (rut, nombre, direccion) VALUES ('77777777-7', 'Lucia Vega', 'Avenida del Norte');

-- Insert data into Materia --
INSERT INTO materias (nombre, alumno_id) VALUES ('Matematicas', 1);
INSERT INTO materias (nombre, alumno_id) VALUES ('Fisica', 1);
INSERT INTO materias (nombre, alumno_id) VALUES ('Quimica', 2);
INSERT INTO materias (nombre, alumno_id) VALUES ('Historia', 3);
INSERT INTO materias (nombre, alumno_id) VALUES ('Geografia', 4);
INSERT INTO materias (nombre, alumno_id) VALUES ('Biologia', 5);
INSERT INTO materias (nombre, alumno_id) VALUES ('Ingles', 6);
INSERT INTO materias (nombre, alumno_id) VALUES ('Programacion', 7);
INSERT INTO materias (nombre, alumno_id) VALUES ('Arte', 8);
INSERT INTO materias (nombre, alumno_id) VALUES ('Musica', 9);


INSERT INTO roles (name) VALUES ('ADMIN');

-- Inserta el usuario administrador con su hash de contraseña (bcrypt)
INSERT INTO users (username, rut, password, email, is_active) VALUES ('admin', '26.931.652-7', '$2a$10$jMEiqDfyI0LfLcKhnUQTH./Hxac12x9HWKkAyJlhRyiscO9tN4dDC', 'admin@example.com', true);

-- Asigna el rol ADMIN al usuario admin
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);


