package lk.ijse.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/login_form.fxml"));
        AnchorPane rootNode = loader.load();

        // Set up the scene
        Scene scene = new Scene(rootNode);
        stage.setTitle("Login page");
        stage.setScene(scene);
        stage.show();
    }
}
