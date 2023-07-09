package cl.ucn.disc.pa.taller_fx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LecturaArchivos {

    public ArrayList<Libro> leerArchivoLibros() {
        ArrayList<Libro> libros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String isbn = chain[0];
                String title = chain[1];
                String author = chain[2];
                String category = chain[3];
                int copies = Integer.parseInt(chain[4]);
                int price = Integer.parseInt(chain[5]);

                Libro libro = new Libro(isbn, title, author, category, copies, price);
                libros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de libros: " + e.getMessage());
        }

        return libros;
    }

    public ArrayList<Usuario> leerArchivoUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String password = chain[3];

                Usuario usuario = new Usuario(rut, name, lastname, password);
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }

        return usuarios;
    }
}