import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Libro libro1 = new Libro("Capitan Calzoncillos", "Juanmi", "2739", 5.00, 2.00);
        Libro libro2 = new Libro("Geronimo", "Parrales", "2325", 10.00, 3.00);
        Libro libro3 = new Libro("La vida de Paquirrin", "Belen Esteban", "539", 7.00, 5.00);

        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        Biblioteca biblio = new Biblioteca();
        biblio.agregarLibros(libros);

        System.out.println("Libros antes de la serialización:");
        biblio.mostrarLibros();

        biblio.serializarLibros();

        biblio.deserializarLibros();
        System.out.println("\nLibros después de la deserialización:");
        biblio.mostrarLibros();
    }
}
