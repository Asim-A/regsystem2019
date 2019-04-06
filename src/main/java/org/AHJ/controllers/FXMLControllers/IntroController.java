package org.AHJ.controllers.FXMLControllers;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Filhåndtering.SkrivCSV;


import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Paths;

public class IntroController {


    @FXML
    public void chooseFile(){

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.csv"));
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        File selectedFile = fileChooser.showOpenDialog(null);
        callReaderOnFile(selectedFile);
    }

    private void callReaderOnFile(File file){

    }




}
