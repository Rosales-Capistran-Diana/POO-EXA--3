/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problemaexamen;



/*
Antes de ejecutar el código, asegúrese de realizar los siguientes pasos:
1. Crea una carpeta en tu sistema donde se almacenará el archivo de datos. Puedes llamarlo 
"data" u otro nombre que prefieras. Por ejemplo, puedes crear la carpeta "data" en la misma 
ubicación donde se encuentra tu archivo de código Java.

2. Actualiza la variable `filename` en el método `main` con la ruta completa del archivo donde
deseas almacenar los datos de los estudiantes. Por ejemplo, si creaste la carpeta "data" en la
misma ubicación que tu archivo de código Java y deseas que el archivo se llame "estudiantes.dat",
puedes establecer `String filename = "data/estudiantes.dat";`.

3. Luego de realizar los pasos anteriores, puedes ejecutar el código y debería crear los objetos 
de estudiante, agregarlos al sistema, almacenar los datos en el archivo especificado, borrar los
datos del sistema, cargar los datos desde el archivo y finalmente recuperar la información de un 
estudiante específico y mostrarla por pantalla.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Estudiante> estudiantes;

    public StudentManagementSystem() {
        estudiantes = new ArrayList<>();
    }

    public void addStudent(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public Estudiante getStudent(int rollNumber) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNumeroLista() == rollNumber) {
                return estudiante;
            }
        }
        return null;
    }

    public void storeData(String filename) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(estudiantes);
            System.out.println("Datos almacenados en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al almacenar los datos en el archivo: " + e.getMessage());
        }
    }

    public void loadData(String filename) {
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            estudiantes = (List<Estudiante>) objectInputStream.readObject();
            System.out.println("Datos cargados desde el archivo correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos desde el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filename = "data/estudiantes.dat";
        StudentManagementSystem system = new StudentManagementSystem();

        // Crear objetos de estudiante
        Estudiante estudiante1 = new Estudiante("Juan", 1, "Grado 10");
        Estudiante estudiante2 = new Estudiante("María", 2, "Grado 11");
        Estudiante estudiante3 = new Estudiante("Pedro", 3, "Grado 9");

        // Agregar estudiantes al sistema
        system.addStudent(estudiante1);
        system.addStudent(estudiante2);
        system.addStudent(estudiante3);

        // Almacenar datos de los estudiantes en un archivo
        system.storeData(filename);

        // Borrar los datos de los estudiantes del sistema
        system.estudiantes.clear();

        // Cargar los datos de los estudiantes desde el archivo
        system.loadData(filename);

        // Recuperar la información de un estudiante específico y mostrarla
        Estudiante estudianteRecuperado = system.getStudent(2);
        if (estudianteRecuperado != null) {
            System.out.println("Información del estudiante:");
            System.out.println("Nombre: " + estudianteRecuperado.getNombre());
            System.out.println("Número de lista: " + estudianteRecuperado.getNumeroLista());
            System.out.println("Grado: " + estudianteRecuperado.getGrado());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
}

class Estudiante implements Serializable {
    private String nombre;
    private int numeroLista;
    private String grado;

    public Estudiante(String nombre, int numeroLista, String grado) {
        this.nombre = nombre;
        this.numeroLista = numeroLista;
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroLista() {
        return numeroLista;
    }

    public String getGrado() {
        return grado;
    }
}

