package org.AHJ.controllers.FXMLControllers;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.AHJ.controllers.Backend.ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TESTCONTROLLER {

    @FXML
    TextField inputField;
    @FXML
    Button loadBtn;
    @FXML
    Label label;

    ExecutorService ex;

    public TESTCONTROLLER() {
        ex = Executors.newSingleThreadExecutor();
    }

    @FXML
    public void initilize(){



    }

    public void changeLabel(ActionEvent actionEvent) {
        Task<Void> task = new ThreadTest(this::changeLabel, "AHAHAHAH");
        ex.execute(task);
    }

    private void changeLabel(){
        if(!inputField.getText().isEmpty()) label.setText(inputField.getText());
    }
}
