package org.AHJ.controllers.FXMLControllers;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Backend.FileInputTask;
import org.AHJ.controllers.Backend.FileOutputTask;
import org.AHJ.controllers.Handlers.TableViewHandler;
import org.AHJ.models.forsikringer.Båtforsikring;
import org.AHJ.models.objekter.Kunde;
import org.AHJ.models.objekter.Kunder;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KunderOversiktController {

    ExecutorService service;
    Kunder kunder;

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

    public KunderOversiktController() {
        service = Executors.newSingleThreadExecutor();
        kunder = new Kunder();
        System.out.println("Kunder added to kundeListe");
    }

    @FXML
    public void initialize(){
        TableViewHandler handler = new TableViewHandler(
                KundeTableView,
                DatoColumn,
                FornavnColumn,
                EtternavnColumn,
                ForsikringsnummerColumn,
                FakturaadresseColumn,
                filtrertTekst
        );

        Kunde jakob = new Kunde("Jakob", "Ramstad", "Loot Lake",
                1, 5);
        Kunde asim = new Kunde("Asim", "Abazi", "Tilted Towers",
                2, 4);
        jakob.addForsikring(new Båtforsikring(12.00,1,"vetafaen"));
        Kunde hamza = new Kunde("hamza", "aftab", "moisty mire",
                3, 500);
        Kunde asim2 = new Kunde("Asim2", "Abazi2", "Tilted Towers",
                4, 4);
        asim2.addForsikring(new Båtforsikring(12.00,1,"vetafaen"));
        asim2.addForsikring(new Båtforsikring(44.00,88,"betingelser2"));

        kunder.addKunde(jakob);
        kunder.addKunde(asim);
        kunder.addKunde(hamza);
        kunder.addKunde(asim2);



        handler.addObservableKunde(jakob);
        handler.addObservableKunde(asim);
        handler.addObservableKunde(hamza);
        handler.addObservableKunde(asim2);


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