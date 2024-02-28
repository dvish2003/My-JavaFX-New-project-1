package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeFormController {
    public Button btnCustomer;
    public Button btnItem;
    public Button btnLogin;
    public AnchorPane HomeForm;
    public AnchorPane btnControlArea;

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("/view/Customer_form.fxml")));
        btnControlArea.getChildren().clear();
        btnControlArea.getChildren().add(root);
    }

    public void btnItemOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("/view/Item_form.fxml")));
        btnControlArea.getChildren().clear();
        btnControlArea.getChildren().add(root);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("/view/login_form.fxml")));
        Stage stage = (Stage) HomeForm.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }
}
