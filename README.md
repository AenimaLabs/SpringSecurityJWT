# Student Grading System

This project implements a **Student Grading System** for Universidad de Los Andes. It consists of a backend REST API and a frontend web application, both developed using **Spring Boot**. The system manages student data, their assigned subjects, and user authentication using JWT.

## Instructions

Carefully follow the requirements outlined below to understand and deploy the system.

---

## Description

The system is designed to handle student grades for undergraduate programs. The backend provides a REST API for managing students and their assigned subjects, with authentication using JWT. The frontend enables a user to log in, view a list of students, and their subjects.

---

## Features

### Backend (Hito 1)

1. **REST API**
   - Handles CRUD operations for students and subjects.
   - Secured with JWT-based authentication.

2. **Models**
   - `Alumno` (Student):
     - `id`: Long
     - `rut`: String
     - `nombre`: String
     - `direccion`: String
     - `materiaList`: Set<Materia>
   - `Materia` (Subject):
     - `id`: Long
     - `nombre`: String
     - `alumno`: Alumno

3. **Repositories**
   - `AlumnoRepository` for student data persistence.
   - `MateriaRepository` for subject data persistence.

4. **Services**
   - `AlumnoService`:
     - `save`: Save a student.
     - `findAll`: Retrieve all students.
   - `MateriaService`:
     - `save`: Save a subject.

5. **Controllers**
   - `AlumnoController`:
     - `findAll`: Get all students.
     - `save`: Save a student.
   - `MateriaController`:
     - `save`: Save a subject.

6. **JWT Security**
   - Dependencies: Spring Security and `jsonwebtoken.io`.
   - Token configuration in `application.yml`:
     - Secret key.
     - Token expiration time.
   - Components:
     - `JwtTokenProvider`: Generates JWT tokens.
     - `JwtTokenFilter`: Validates incoming tokens.
     - `JwtTokenFilterConfigurer`: Configures the filter.
   - `WebSecurityConfig`: Configures security settings.

7. **Authentication**
   - Models:
     - `User`:
       - `id`: Long
       - `name`: String
       - `username`: String
       - `email`: String
       - `roles`: List<Role>
     - Enum `Role`: `ROLE_ADMIN`, `ROLE_CLIENT`.
   - Services:
     - `UserService`:
       - `signin`: Authenticate a user.
       - `signup`: Register a user.
       - `loadUserByUsername`: Validate user credentials.
   - Controllers:
     - `UserController`:
       - `signin`: Authenticate and return a token.
       - `signup`: Register a user.

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

2. **Services**
   - `AlumnoService`:
     - `findAll`: Fetch all students from the backend.
   - `UserService`:
     - `signin`: Authenticate users from the frontend.

3. **Controllers**
   - `LoginController`:
     - `login`: Displays login page.
     - `home`: Displays student data.

4. **Views**
   - `login.html`: Login form.
   - `home.html`: Displays a list of students and their subjects.

5. **Security**
   - `WebSecurityConfig`: Configures security settings for the frontend.

---

## Requirements

- **Java 17+**
- **Maven**
- **Spring Boot**
- REST API client (e.g., Postman or Insomnia)

---

## How to Run

### Backend

1. Navigate to the backend project directory.
2. Run the project using Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Access the API at `http://localhost:8080`.

### Frontend

1. Navigate to the frontend project directory.
2. Run the project using Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Access the application at `http://localhost:8081`.

---

## Testing

1. Use Postman or Insomnia to test backend endpoints.
2. Authenticate to obtain a JWT token:
   - Endpoint: `/api/auth/signin`
   - Method: `POST`
   - Body:
     ```json
     {
       "username": "testuser",
       "password": "password"
     }
     ```
3. Use the JWT token to access secured endpoints.

---

## Logs

Add a logger to capture detailed logs during development and testing.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

