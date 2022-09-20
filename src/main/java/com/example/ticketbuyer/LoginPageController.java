package com.example.ticketbuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {

    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_password;

    @FXML
    private Label label_username;

    @FXML
    private Label label_password;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize");

    }


    public  void loginUser(ActionEvent event) throws IOException {
        if (tf_username!=null&&tf_password!=null) {
            if (tf_username.getText().equals("admin") && tf_password.getText().equals("admin")) {
                String name = tf_username.getText();
                Parent root = null;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPage.fxml"));
                root = loader.load();
                MainPageController mainPageController = loader.getController();
                mainPageController.displayName(name);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Main page");
                stage.setScene(new Scene(root, 600, 400));
                stage.show();
            }
        }
    }

}
