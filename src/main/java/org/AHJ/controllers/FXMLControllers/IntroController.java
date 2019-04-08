package org.AHJ.controllers.FXMLControllers;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Filhåndtering.*;


import java.io.File;
import java.nio.file.Paths;

public class IntroController {

    
    @FXML
    public void initiateReadFromFile(){
        File fileToRead = getChoosenFile();
        callReaderOnFile(fileToRead);
    }


    private void callReaderOnFile(File file){
        if (file.toString().contains(".csv")){
            LastInnFil csvLast = new LasterCSV();
            try {
                csvLast.lastInnFil(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (file.toString().contains(".jobj")){
            LastInnFil jobjLast = new LasterJOBJ();
            try {
                jobjLast.lastInnFil(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //TODO exeption handling
    private File getChoosenFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.csv","*.jobj"));
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        return fileChooser.showOpenDialog(null);
    }
}
