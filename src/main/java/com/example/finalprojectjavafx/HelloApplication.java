package com.example.finalprojectjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException{

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Define.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Garden Guardian");
        stage.setResizable(false);
        stage.getIcons().add(new Image("C:\\Users\\ikort\\IdeaProjects\\Plant-disease_Final-project\\src\\main\\resources\\com\\example\\finalprojectjavafx\\plant.png"));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}