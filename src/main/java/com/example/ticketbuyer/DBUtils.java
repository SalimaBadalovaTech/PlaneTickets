package com.example.ticketbuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DBUtils {
    public static void changeScene(ActionEvent actionEvent, String fxmlFile, String title, String username) throws IOException {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
        root = FXMLLoader.load(Objects.requireNonNull(DBUtils.class.getResource(fxmlFile)));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

}
