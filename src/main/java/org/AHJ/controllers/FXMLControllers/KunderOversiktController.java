package org.AHJ.controllers.FXMLControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Filhåndtering.*;
import org.AHJ.models.objekter.Kunde;
import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KunderOversiktController {

    ExecutorService service;
    Kunder kunder;

    public KunderOversiktController() {
        service = Executors.newSingleThreadExecutor();
    }

    @FXML
    public void lastInnKunder(ActionEvent actionEvent) {
        File fileToRead = getChoosenFile();

        callReaderOnFile(fileToRead, kunder.getKundeListe());
    }

    @FXML
    public void lagreKunder(ActionEvent actionEvent) {
        File fileToWrite = getChoosenFile();
        kunder = new Kunder();
        kunder.getKundeListe().add(new Kunde("per","test", "fd",23,2 ));
        writerInstansiateOnFile(fileToWrite, kunder.getKundeListe());

    }

    //skal ikke skrive til fil her. Skal isteden lagre kundens da

    //skal ikke skrive til fil her. Skal isteden lagre kundens data i datamanager som senere kan skrives til fil
    private void writerInstansiateOnFile(File file, List kundeListe){

        if (file.toString().contains(".csv")){
            SkrivTilFil csvSkriv = new SkriverCSV();
            csvSkriv.skrivTilFil(file, kundeListe);

        } else if (file.toString().contains(".JOBJ")){
            SkrivTilFil jobjSkriv = new SkriverJOBJ();
            jobjSkriv.skrivTilFil(file, kundeListe);
        }
    }

    private void callReaderOnFile(File file, List kundeListe){
        if (file.toString().contains(".csv")){
            LastInnFil csvLast = new LasterCSV();
            try {
                csvLast.lastInnFil(file, kundeListe);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (file.toString().contains(".jobj")){
            LastInnFil jobjLast = new LasterJOBJ();
            try {
                jobjLast.lastInnFil(file, kundeListe);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //TODO exeption handling
    private File getChoosenFile(){
        FileChooser fileChooser = new FileChooser();
  /*      fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.csv","*.jobj"));*/
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        return fileChooser.showOpenDialog(null);
    }

}