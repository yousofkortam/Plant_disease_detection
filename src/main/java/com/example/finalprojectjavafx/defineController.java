package com.example.finalprojectjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class defineController implements Initializable {

        @FXML
        private void Continue(ActionEvent event) throws IOException {
            System.out.println("Continue Button Clicked!");
            page p = new page();
            p.Page(event, "Login.fxml");
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* TODO */
    }
}

