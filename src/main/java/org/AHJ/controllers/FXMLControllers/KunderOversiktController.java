package org.AHJ.controllers.FXMLControllers;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Backend.FileOutputTask;
import org.AHJ.models.objekter.Kunde;
import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KunderOversiktController {

    ExecutorService service;
    Kunder kundeListe;

    public KunderOversiktController() {
        service = Executors.newSingleThreadExecutor();
        Kunder kundeListe = new Kunder();
        Kunde jakob = new Kunde("Jakob", "Fortnite", "Loot Lake",
                1, 0);
        kundeListe.addKunde(jakob);

    }

    @FXML
    public void initialize(){

    }

    public void lastInnKunder(ActionEvent actionEvent) {



    }

    public void lagreKunder(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("jobj", "*.jobj"));
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        File selectedFile = fileChooser.showOpenDialog(null);

        Task<Void> task = new FileOutputTask(selectedFile, kundeListe);
        service.execute(task);

    }
}