package org.AHJ.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void initilize(){

    }

}
