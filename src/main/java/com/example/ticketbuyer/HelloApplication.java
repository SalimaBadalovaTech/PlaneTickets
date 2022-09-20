package com.example.ticketbuyer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class HelloApplication extends Application {
    private Parent root;
    @Override
    public void start(Stage stage) throws IOException {
       root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("login.fxml")));
        Scene scene = new Scene(root);
        Screen screen = Screen.getPrimary();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}