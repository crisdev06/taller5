package cl.ucn.disc.pa.taller_fx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LoginView {

    private Scene scene;
    private TextField rutField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button exitButton;

    public LoginView() {
        // Crear los componentes de la vista
        Label rutLabel = new Label("RUT:");
        rutField = new TextField();
        Label passwordLabel = new Label("Contraseña:");
        passwordField = new PasswordField();
        loginButton = new Button("Iniciar sesión");
        exitButton = new Button("Cerrar programa");

        // Aplicar estilos CSS a los componentes
        String style = "-fx-font-size: 14px; -fx-padding: 8px;";
        rutLabel.setStyle(style);
        rutField.setStyle(style);
        passwordLabel.setStyle(style);
        passwordField.setStyle(style);
        loginButton.setStyle(style + "-fx-background-color: #4CAF50; -fx-text-fill: white;");
        exitButton.setStyle(style + "-fx-background-color: #3672f4; -fx-text-fill: white;");

        // Crear el diseño de la vista
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.getChildren().addAll(rutLabel, rutField, passwordLabel, passwordField, loginButton, exitButton);

        scene = new Scene(layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }

    public String getRut() {
        return rutField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public void setController(LoginController controller) {
        // Asignar el controlador a los botones
        loginButton.setOnAction(controller::login);
        exitButton.setOnAction(controller::exit);
    }
}