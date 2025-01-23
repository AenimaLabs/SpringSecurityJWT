package algoritmos;

import cl.playground.SpringSecurityBackend.model.Alumno;
import cl.playground.SpringSecurityBackend.model.Materia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    // Metodo para filtrar e imprimir los nombres de los alumnos que estudian una materia específica
    private static void filtrarAlumnos(List<Alumno> alumnos, String materiaBuscada) {
        alumnos.stream() // Convertimos la lista de alumnos en un flujo para procesar los datos
                .filter(alumno -> alumno.getMaterias().stream() // Filtramos los alumnos por materias
                        .anyMatch(materia -> materia.getNombre() // Verificamos si el nombre de la materia coincide
                                .equalsIgnoreCase(materiaBuscada)))
                .map(Alumno::getNombre) // Obtenemos solo los nombres de los alumnos filtrados
                .forEach(System.out::println); // Imprimimos los nombres en la consola
    }

    public static void main(String[] args) {

        // Creamos instancias de materias con nombres específicos
        Materia materia1 = new Materia(null, "Matemáticas", null);
        Materia materia2 = new Materia(null, "Historia", null);
        Materia materia3 = new Materia(null, "Matemáticas", null);
        Materia materia4 = new Materia(null, "Ciencias", null);
        Materia materia5 = new Materia(null, "Física", null);
        Materia materia6 = new Materia(null, "Literatura", null);
        Materia materia7 = new Materia(null, "Química", null);
        Materia materia8 = new Materia(null, "Geografía", null);

        // Lista que almacenará los alumnos
        List<Alumno> alumnos = new ArrayList<>();

        // Creamos instancias de alumnos con sus atributos básicos
        Alumno alumno1 = new Alumno(null, "12345678-9", "Juan Perez", "Calle Falsa 123", new HashSet<>());
        Alumno alumno2 = new Alumno(null, "98765432-1", "Maria Lopez", "Avenida Siempre Viva 742", new HashSet<>());
        Alumno alumno3 = new Alumno(null, "11223344-5", "Carlos Gonzalez", "Pasaje Estrella 45", new HashSet<>());
        Alumno alumno4 = new Alumno(null, "66778899-0", "Ana Rodriguez", "Carrera 10 #25-30", new HashSet<>());
        Alumno alumno5 = new Alumno(null, "55443322-1", "Luis Torres", "Diagonal 15 #40-50", new HashSet<>());
        Alumno alumno6 = new Alumno(null, "33221144-7", "Elena Morales", "Transversal 8 #12-15", new HashSet<>());

        // Asignamos materias a cada alumno
        alumno1.getMaterias().add(materia1); // Juan Perez estudia Matemáticas
        alumno1.getMaterias().add(materia2); // Juan Perez estudia Historia
        alumno2.getMaterias().add(materia3); // Maria Lopez estudia Matemáticas
        alumno3.getMaterias().add(materia4); // Carlos Gonzalez estudia Ciencias
        alumno4.getMaterias().add(materia5); // Ana Rodriguez estudia Física
        alumno4.getMaterias().add(materia6); // Ana Rodriguez estudia Literatura
        alumno5.getMaterias().add(materia7); // Luis Torres estudia Química
        alumno6.getMaterias().add(materia8); // Elena Morales estudia Geografía

        // Agregamos los alumnos a la lista
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);
        alumnos.add(alumno5);
        alumnos.add(alumno6);

        // Filtramos e imprimimos los nombres de los alumnos que estudian "Matemáticas"
        filtrarAlumnos(alumnos, "Matemáticas");
        System.out.println("------------------------------");
        filtrarAlumnos(alumnos, "Historia");
        System.out.println("------------------------------");
        filtrarAlumnos(alumnos, "Química");
    }
}
