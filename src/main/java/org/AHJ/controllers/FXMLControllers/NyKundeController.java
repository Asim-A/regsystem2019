package org.AHJ.controllers.FXMLControllers;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Filhåndtering.*;

import java.io.File;
import java.nio.file.Paths;

public class NyKundeController {

    @FXML
    public void registrerKunde() {

        FileChooser fileChooser = new FileChooser();
       /* fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("csv", "*.csv"));*/
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        File selectedFile = fileChooser.showOpenDialog(null);
        writeInstansiatorOnFile(selectedFile);
    }

    private void writeInstansiatorOnFile(File file){

        if (file.toString().contains(".csv")){
            SkrivTilFil csvSkriv = new SkriverCSV();
            csvSkriv.skrivTilFil(file);

        } else if (file.toString().contains(".JOBJ")){
            SkrivTilFil jojbSkriv = new SkriverJOBJ();

        }SkrivTilFil skriver = new SkriverCSV();
        skriver.skrivTilFil(file);
    }

}
