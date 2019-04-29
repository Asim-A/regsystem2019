package org.AHJ.controllers.FXMLControllers;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Tasks.FileInputTask;
import org.AHJ.controllers.Tasks.FileOutputTask;
import org.AHJ.controllers.Handlers.TableViewHandler;
import org.AHJ.modeller.forsikringer.Båtforsikring;
import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.objekter.Kunder;
import org.AHJ.modeller.vinduer.BatforsikringDialog;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KundeOversiktController {

    ExecutorService service;
    Kunder kunder;
    TableViewHandler handler;

    @FXML
    TextField filtrertTekst;
    @FXML
    TableView<Kunde> KundeTableView;
    @FXML
    TableColumn<Kunde, LocalDate> DatoColumn;
    @FXML
    TableColumn<Kunde, String> FornavnColumn;
    @FXML
    TableColumn<Kunde, String> EtternavnColumn;
    @FXML
    TableColumn<Kunde, Integer> ForsikringsnummerColumn;
    @FXML
    TableColumn<Kunde, String> FakturaadresseColumn;
    @FXML
    ToggleGroup search;

    public KundeOversiktController() {
        service = Executors.newSingleThreadExecutor();
        kunder = new Kunder();
        System.out.println("Kunder added to kundeListe");
    }

    @FXML
    public void initialize(){
        handler = new TableViewHandler(
                KundeTableView,
                DatoColumn,
                FornavnColumn,
                EtternavnColumn,
                ForsikringsnummerColumn,
                FakturaadresseColumn,
                filtrertTekst
        );


        search.selectedToggleProperty().addListener(((observableValue, toggle, t1) -> {
            filtrertTekst.setText("");
            filtrertTekst.setPromptText("\uD83D\uDD0E "+((RadioButton) search.getSelectedToggle()).getText());
        }));


    }

    @FXML
    public void lastInnKunder(ActionEvent actionEvent) {
        File fileToRead = getChosenFile();
        kunder=new Kunder();
        Task<Void> task = new FileInputTask(fileToRead, kunder, this::updateKunder);
        try {
            service.execute(task);
        } catch (Exception e){
            System.out.println("Exeption");
        }
    }

    @FXML
    public void lagreKunder(ActionEvent actionEvent) {
        File fileToWrite = getChosenFile();
        Task<Void> task = new FileOutputTask(fileToWrite, kunder);
        service.execute(task);
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

    private void updateKunder(){
        for(Kunde k : kunder.getKundeListe()){
            handler.addObservableKunde(k);
        }
    }

    @FXML
    private void visBatforsikring(){
        BatforsikringDialog batForsikring = new BatforsikringDialog(kunder.getKundeListe().get(0));
        System.out.println("ligma");
    }
   // public void
}