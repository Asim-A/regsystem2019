package org.AHJ.controllers.FXMLControllers;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Filhåndtering.*;
import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.nio.file.Paths;

public class NyKundeController {


    //skal ikke skrive til fil her. Skal isteden lagre kundens data i datamanager som senere kan skrives til fil
    @FXML
    public void registrerKunde() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("csv", "*.csv"));
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        File selectedFile = fileChooser.showOpenDialog(null);
        writeInstansiatorOnFile(selectedFile);
    }

    //skal ikke skrive til fil her. Skal isteden lagre kundens data i datamanager som senere kan skrives til fil
    private void writeInstansiatorOnFile(File file){
        Kunder k = new Kunder(); //TODO FUNKER IKKE
        if (file.toString().contains(".csv")){
            SkrivTilFil csvSkriv = new SkriverCSV();
            csvSkriv.skrivTilFil(file, k);

        } else if (file.toString().contains(".JOBJ")){
            SkrivTilFil jojbSkriv = new SkriverJOBJ();
        }
    }

}
