package com.example.finalprojectjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class lastPageController implements Initializable {
    @FXML
    private Label diseaseName;
    @FXML
    private Label answer;


    public void Back(ActionEvent event) throws IOException {

        page p = new page();
        p.Page(event, "ChoosePlant.fxml");

    }

    public void Exit(ActionEvent event) {

        System.exit(1);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataSingleton obj = dataSingleton.getInstance();
        Connection con = jdbcConnection.getConnection();
        Statement statement;
        try {
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM disease where disease_name = '" + obj.getData() + "';");
            while (resultSet.next()){
                diseaseName.setText(resultSet.getString(5));
                answer.setText(resultSet.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
