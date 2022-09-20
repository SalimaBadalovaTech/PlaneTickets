package com.example.ticketbuyer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private static Label label_username;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public static void setLabel_username(String username){
        label_username.setText("Welcome to Magic Airlines" + username);
    }
}
