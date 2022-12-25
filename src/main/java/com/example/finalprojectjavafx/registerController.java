package com.example.finalprojectjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class registerController implements Initializable {
    @FXML
    private Button registerBtn;
    @FXML
    private TextField emailText;
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;

    private boolean userIsFound(String username) throws SQLException {
        Connection con = jdbcConnection.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM login where username = '" + username + "';");
        return resultSet.absolute(1);
    }

    private boolean userEmailFound(String email) throws SQLException {

        Connection con = jdbcConnection.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM login where email = '" + email + "';");
        return resultSet.absolute(1);

    }


    public void Register(ActionEvent event) throws IOException, SQLException {
        String username = usernameText.getText();
        String email = emailText.getText();
        String password = passwordText.getText();

        boolean isValidInputs = Validation.Register(username, email, password);

        if (!isValidInputs) {
            JOptionPane.showMessageDialog(null, "Please enter all required data!");
            return;
        }

        boolean UserIsFound = userIsFound(username);
        boolean EmailFound = userEmailFound(email);

        if (UserIsFound) {
            JOptionPane.showMessageDialog(null, "username is already used");
            return;
        }

        if (EmailFound) {
            JOptionPane.showMessageDialog(null, "email is already used");
            return;
        }

        if (!Validation.emailValidation(email)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address");
            return;
        }

        Connection con = jdbcConnection.getConnection();
        Statement statement = con.createStatement();
        statement.executeUpdate("INSERT INTO login (username, password, email) VALUES ('"+username+"', '"+password+"', '"+email+"');");
        JOptionPane.showMessageDialog(null, "Congratulations, your account has been created");
        page p = new page();
        p.Page(event, "ChoosePlant.fxml");


    }

    public void Back(ActionEvent event) throws IOException {

        System.out.println("Register Link Clicked!");
        page p = new page();
        p.Page(event, "Login.fxml");

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}