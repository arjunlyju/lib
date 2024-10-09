
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        LoginController loginController = new LoginController();
        
        // Basic login view
        VBox loginPane = new VBox();
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            User user = loginController.login(usernameField.getText(), passwordField.getText());
            if (user != null) {
                // After successful login, show dashboard
                showDashboard(user);
            } else {
                System.out.println("Invalid credentials.");
            }
        });

        loginPane.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

        Scene scene = new Scene(loginPane, 300, 200);
        primaryStage.setTitle("The Reading Room");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showDashboard(User user) {
        Stage dashboardStage = new Stage();
        VBox dashboard = new VBox();
        Label welcomeLabel = new Label("Welcome " + user.getFirstName() + " " + user.getLastName());
        dashboard.getChildren().add(welcomeLabel);
        
        // Display more dashboard content based on user role (admin or regular user)
        if (user.isAdmin()) {
            // Admin functionalities
            Label adminLabel = new Label("Admin Dashboard");
            dashboard.getChildren().add(adminLabel);
        } else {
            // Regular user functionalities
            Label userLabel = new Label("User Dashboard");
            dashboard.getChildren().add(userLabel);
        }

        Scene scene = new Scene(dashboard, 400, 300);
        dashboardStage.setScene(scene);
        dashboardStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
