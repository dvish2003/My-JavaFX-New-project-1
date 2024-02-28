package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.db.MyDetails;

import java.io.IOException;


public class LoginController {
    public TextField txtUserName;
    public TextField txtPassword;
    public Button btnLogin;
    public AnchorPane ancerPane;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
       /* String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if(userName.equals(MyDetails.UserName) && password.equals(MyDetails.Password)){ */
            Parent root = FXMLLoader.load((getClass().getResource("/view/Home_form.fxml")));
            Stage stage = (Stage) ancerPane.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("HOME PAGE");
            stage.setScene(scene);
            stage.show();

      /*  }else{

            new Alert(Alert.AlertType.ERROR, "Login Failed").show();

        }*/


    }
    }
