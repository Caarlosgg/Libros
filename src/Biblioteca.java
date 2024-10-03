import java.io.*;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibros(ArrayList<Libro> libros) {
        this.libros.addAll(libros);  // Agregar libros a la lista interna
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }

    public void serializarLibros() {
        try (FileOutputStream fileOutput = new FileOutputStream("biblioteca.ser");
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {

            objectOutput.writeObject(libros);  // Serializar toda la lista de libros

            System.out.println("Los libros han sido serializados.");

        } catch (IOException e) {
            System.err.println("Error al serializar: " + e.getMessage());
        }
    }

    public void deserializarLibros() {
        try (FileInputStream fileInput = new FileInputStream("biblioteca.ser");
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {

            libros = (ArrayList<Libro>) objectInput.readObject();  // Deserializar la lista completa
            System.out.println("Los libros han sido deserializados.");

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
        }
    }
}
