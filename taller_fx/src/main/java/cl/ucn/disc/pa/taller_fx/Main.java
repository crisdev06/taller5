package cl.ucn.disc.pa.taller_fx;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private Stage primaryStage;
    private LoginController loginController;
    private LecturaArchivos lecturaArchivos;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        lecturaArchivos = new LecturaArchivos();
        ArrayList<Usuario> usuarios = lecturaArchivos.leerArchivoUsuarios();
        ArrayList<Libro> libros = lecturaArchivos.leerArchivoLibros();
        showLoginView(usuarios, libros);
    }

    public void showLoginView(ArrayList<Usuario> usuarios, ArrayList<Libro> libros) {
        // Crear y mostrar la vista del inicio de sesión
        LoginView loginView = new LoginView();
        loginController = new LoginController(loginView, usuarios, libros);
        loginView.setController(loginController);
        primaryStage.setScene(loginView.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}