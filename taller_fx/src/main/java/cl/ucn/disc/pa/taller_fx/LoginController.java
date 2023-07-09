package cl.ucn.disc.pa.taller_fx;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class LoginController {



    private LoginView loginView;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libro> libros;

    public LoginController(LoginView loginView, ArrayList<Usuario> usuarios, ArrayList<Libro> libros) {
        this.loginView = loginView;
        this.usuarios = usuarios;
        this.libros = libros;
    }

    private Usuario findUsuario(String rut, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getRut().equals(rut) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showMainMenu() {
        // Crear los componentes del menú principal
        Label titleLabel = new Label("Menú principal");
        Button buscarLibroButton = new Button("Buscar Libro");
        Button prestarLibroButton = new Button("Prestar Libro");
        Button agregarLibroButton = new Button("Agregar Libro");
        Button devolverLibroButton = new Button("Devolver Libro");
        Button cerrarSesionButton = new Button("Cerrar Sesión");

        // Configurar los estilos y el comportamiento de los componentes
        String style = "-fx-font-size: 14px; -fx-padding: 8px;";
        titleLabel.setStyle(style + "-fx-font-weight: bold; -fx-font-size: 18px;");
        buscarLibroButton.setStyle(style);
        prestarLibroButton.setStyle(style);
        agregarLibroButton.setStyle(style);
        devolverLibroButton.setStyle(style);
        cerrarSesionButton.setStyle(style + "-fx-background-color: #F44336; -fx-text-fill: white;");

        buscarLibroButton.setOnAction(e -> buscarLibro());
        prestarLibroButton.setOnAction(e -> prestarLibro());
        agregarLibroButton.setOnAction(e -> agregarLibro());
        devolverLibroButton.setOnAction(e -> devolverLibro());
        cerrarSesionButton.setOnAction(e -> exitM());

        // Crear el diseño del menú principal
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(titleLabel, buscarLibroButton, prestarLibroButton, agregarLibroButton, devolverLibroButton, cerrarSesionButton);

        // Crear la escena y establecerla en el primaryStage
        Scene scene = new Scene(layout, 300, 300);
        //primaryStage.setScene(scene);
    }

    private void exitM() {
    }

    private void devolverLibro() {
    }

    private void agregarLibro() {
    }

    private void prestarLibro() {
    }

    private void buscarLibro() {
    }


    public void login(ActionEvent event) {
        String rut = loginView.getRut();
        String password = loginView.getPassword();

        if (rut.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Debe completar todos los campos.");
            return;
        }

        // Lógica para verificar las credenciales y permitir el inicio de sesión
        Usuario usuario = findUsuario(rut, password);
        if (usuario != null) {
            showMainMenu();
        } else {
            showAlert("Error", "Credenciales inválidas.");
        }
    }

    public void exit(ActionEvent event) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("registro.txt"))) {
            // Obtener la fecha y hora actual
            Date fechaHoraActual = new Date();

            // Escribir las transacciones en el archivo "registro.txt"
            Transaccion[] transacciones = new Transaccion[0];
            for (Transaccion transaccion : transacciones) {
                String mensaje = "[" + fechaHoraActual.toString() + "] " + transaccion.toString();
                writer.println(mensaje);
            }

            // Cerrar el programa
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de registro: " + e.getMessage());
        }
    }
}
