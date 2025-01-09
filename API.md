# API Documentation

## Endpoints

### Alumno Endpoints

#### GET /api/v1/alumnos

**Description:** Retrieve a paginated list of alumnos.

**Request Parameters:**
- `page` (optional, default: `0`): The page number.
- `size` (optional, default: `10`): The size of the page.

**Response:**
- Status: `200 OK`
- Body:
```json
{
  "content": [
    {
      "id": 1,
      "rut": "12345678-9",
      "nombre": "Juan Pérez",
      "direccion": "Calle Falsa 123",
      "materias": ["Matemáticas", "Historia"]
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10
  },
  "totalElements": 1,
  "totalPages": 1
}
```

#### POST /api/v1/alumnos

**Description:** Create a new alumno.

**Request Body:**
```json
{
  "rut": "12345678-9",
  "nombre": "Juan Pérez",
  "direccion": "Calle Falsa 123",
  "materiaIds": [1, 2]
}
```

**Response:**
- Status: `200 OK`

---

### Materia Endpoints

#### POST /api/v1/materias

**Description:** Create a new materia.

**Request Body:**
```json
{
  "nombre": "Matemáticas",
  "alumno": 1
}
```

**Response:**
- Status: `200 OK`
- Body:
```json
{
  "nombre": "Matemáticas",
  "alumno": 1
}
```

---

## DTOs

### AlumnoCreateDTO

```json
{
  "rut": "string",
  "nombre": "string",
  "direccion": "string",
  "materiaIds": [
    "long"
  ]
}
```

### AlumnoResponseDto

```json
{
  "id": "long",
  "rut": "string",
  "nombre": "string",
  "direccion": "string",
  "materias": [
    "string"
  ]
}
```

### MateriaCreateDTO

```json
{
  "nombre": "string",
  "alumno": "long"
}
