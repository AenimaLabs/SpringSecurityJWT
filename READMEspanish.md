# Student Grading System

Este proyecto implementa un **Sistema de Calificaciones para Estudiantes** desarrollado para la Universidad de Los Andes. Consta de una API REST en el backend y una aplicación web en el frontend, ambas creadas con **Spring Boot**. El sistema gestiona datos de estudiantes, asignaturas y autenticación de usuarios mediante JWT.

---

## Descripción

El sistema está diseñado para gestionar calificaciones de estudiantes en programas de pregrado. El backend provee una API REST para administrar estudiantes y asignaturas con autenticación mediante JWT. El frontend permite a los usuarios iniciar sesión, ver una lista de estudiantes y sus asignaturas.

---

## Características

### Backend (Hito 1)

1. **API REST**

- Operaciones CRUD para estudiantes y asignaturas.
- Seguridad basada en autenticación JWT.

2. **Modelos**

- `Alumno` (Estudiante):
    - `id`: Long
    - `rut`: String
    - `nombre`: String
    - `direccion`: String
    - `materiaList`: Set<Materia>
- `Materia` (Asignatura):
    - `id`: Long
    - `nombre`: String
    - `alumno`: Alumno

3. **Repositorios**

- `AlumnoRepository`: Persistencia de datos de estudiantes.
- `MateriaRepository`: Persistencia de datos de asignaturas.

4. **Servicios**

- `AlumnoService`:
    - `save`: Guardar un estudiante.
    - `findAll`: Obtener todos los estudiantes.
- `MateriaService`:
    - `save`: Guardar una asignatura.

5. **Controladores**

- `AlumnoController`:
    - `findAll`: Obtener todos los estudiantes.
    - `save`: Guardar un estudiante.
- `MateriaController`:
    - `save`: Guardar una asignatura.

6. **Seguridad JWT**

- Dependencias: Spring Security y `jsonwebtoken.io`.
- Configuración en `application.yml`:
    - Clave secreta.
    - Tiempo de expiración del token.
- Componentes:
    - `JwtTokenProvider`: Genera tokens JWT.
    - `JwtTokenFilter`: Valida tokens entrantes.
    - `JwtTokenFilterConfigurer`: Configura el filtro.
- `WebSecurityConfig`: Configura la seguridad del sistema.

7. **Autenticación**

- Modelos:
    - `User`:
        - `id`: Long
        - `name`: String
        - `username`: String
        - `email`: String
        - `roles`: List<Role>
    - Enum `Role`: `ROLE_ADMIN`, `ROLE_CLIENT`.
- Servicios:
    - `UserService`:
        - `signin`: Autenticar un usuario.
        - `signup`: Registrar un usuario.
        - `loadUserByUsername`: Validar credenciales.
- Controladores:
    - `UserController`:
        - `signin`: Autenticar y devolver un token.
        - `signup`: Registrar un usuario.

---

### Frontend (Hito 2)

1. **DTOs**

- `AlumnoDTO`:
    - `id`: Long
    - `rut`: String
    - `nombre`: String
    - `direccion`: String
    - `materiaList`: Set<Materia>
- `MateriaDTO`:
    - `id`: Long
    - `nombre`: String
    - `alumno`: Alumno
- `UserDTO`:
    - `username`: String
    - `password`: String
    - `roles`: List<Role>

2. **Servicios**

- `AlumnoService`:
    - `findAll`: Consultar estudiantes desde el backend.
- `UserService`:
    - `signin`: Autenticar usuarios desde el frontend.

3. **Controladores**

- `LoginController`:
    - `login`: Muestra el formulario de inicio de sesión.
    - `home`: Muestra los datos de los estudiantes.

4. **Vistas**

- `login.html`: Formulario de inicio de sesión.
- `home.html`: Muestra una lista de estudiantes y sus asignaturas.

5. **Seguridad**

- `WebSecurityConfig`: Configura la seguridad para el frontend.

---

## Requisitos

- **Java 17+**
- **Maven**
- **Spring Boot**
- Cliente REST API (por ejemplo, Postman o Insomnia)

---

## Cómo Ejecutar

### Backend

1. Navega al directorio del proyecto backend.
2. Ejecuta el proyecto usando Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Accede a la API en `http://localhost:8080`.

### Frontend

1. Navega al directorio del proyecto frontend.
2. Ejecuta el proyecto usando Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Accede a la aplicación en `http://localhost:8081`.

---

## Pruebas

1. Utiliza Postman o Insomnia para probar los endpoints del backend.
2. Autentícate para obtener un token JWT:

- Endpoint: `/api/auth/signin`
- Método: `POST`
- Cuerpo:
  ```json
  {
    "username": "testuser",
    "password": "password"
  }
  ```

3. Usa el token JWT para acceder a endpoints protegidos.

---

## Logs

Agrega un logger para capturar registros detallados durante el desarrollo y las pruebas.

---

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

