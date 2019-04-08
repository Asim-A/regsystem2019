package org.AHJ.controllers.FXMLControllers;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Backend.FileInputTask;
import org.AHJ.controllers.Backend.FileOutputTask;
import org.AHJ.models.objekter.Kunde;
import org.AHJ.controllers.Filhåndtering.*;
import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KunderOversiktController {

    ExecutorService service;
    Kunder kunder;

    public KunderOversiktController() {
        service = Executors.newSingleThreadExecutor();

        kunder = new Kunder();
        Kunde jakob = new Kunde("Jakob", "Fortnite", "Loot Lake",
                1, 0);
        kunder.addKunde(jakob);
        kunder.addKunde(new Kunde("Jakob", "Fortnite", "Loot Lake",
                1, 0));
        System.out.println("Kunder added to kundeListe");
    }

    @FXML
    public void initialize(){

    }

    @FXML
    public void lastInnKunder(ActionEvent actionEvent) {
        File fileToRead = getChosenFile();
        //callReaderOnFile(fileToRead, kundeListe);
        Task<Void> task = new FileInputTask(fileToRead, kunder);
        service.execute(task);
    }

    @FXML
    public void lagreKunder(ActionEvent actionEvent) {
        File fileToWrite = getChosenFile();
     //   instansiateWriterOnFile(fileToWrite, kundeListe);
        System.out.println("size of kundeListe in controller"+kunder.getKundeListe().size());
        Task<Void> task = new FileOutputTask(fileToWrite, kunder);
        service.execute(task);
    }

    //skal ikke skrive til fil her. Skal isteden lagre kundens data i datamanager som senere kan skrives til fil
   /* private void instansiateWriterOnFile(File file, Kunder kundeListe){

        if (file.toString().contains(".csv")){
            SkrivTilFil csvSkriv = new SkriverCSV();
            try {
                csvSkriv.skrivTilFil(file, kundeListe);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else if (file.toString().contains(".JOBJ")){
            SkrivTilFil jobjSkriv = new SkriverJOBJ();
            try {
                jobjSkriv.skrivTilFil(file, kundeListe);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }*/

    private void callReaderOnFile(File file, Kunder kundeListe) {
        if (file.toString().contains(".csv")) {
            LastInnFil csvLast = new LasterCSV();
            try {
                csvLast.lastInnFil(file, kundeListe);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (file.toString().contains(".jobj")) {
            LastInnFil jobjLast = new LasterJOBJ();
            try {
                jobjLast.lastInnFil(file, kundeListe);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //TODO exeption handling
    private File getChosenFile(){
        FileChooser fileChooser = new FileChooser();
       /* fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.csv","*.jobj"));*/
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        return fileChooser.showOpenDialog(null);
    }

}