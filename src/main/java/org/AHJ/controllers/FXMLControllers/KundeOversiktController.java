package org.AHJ.controllers.FXMLControllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.AHJ.controllers.Tasks.FileInputTask;
import org.AHJ.controllers.Tasks.FileOutputTask;
import org.AHJ.controllers.Handlers.TableViewHandler;
import org.AHJ.modeller.forsikringer.Forsikring;
import org.AHJ.modeller.forsikringer.Fritidsboligforsikring;
import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.objekter.Kunder;
import org.AHJ.modeller.vinduer.BaatforsikringDialog;
import org.AHJ.modeller.vinduer.FritidsboligforsikringDialog;
import org.AHJ.modeller.vinduer.Hus_og_innboforsikringDialog;
import org.AHJ.modeller.vinduer.ReiseforsikringDialog;

import javax.swing.*;
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
    JFXTextField innFakturaAdresse;
    @FXML
    JFXTextField innEtternavn;
    @FXML
    JFXTextField innFornavn;
    @FXML
    JFXComboBox<String> comboBox;
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
        comboBox.getItems().addAll("Baatforsikring","FritidsboligforsikringDialog",
                "Hus og innboforsikring", "ReiseforsikringDialog");




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

    private void visfeilmelding(){
        JOptionPane.showMessageDialog(null, "Feil", "alert", JOptionPane.ERROR_MESSAGE);
    }

    @FXML
    private void visForsikringVindu(){
    //    if ((comboBox.getValue().equals("")) || comboBox.getValue().equals(comboBox.getPromptText())){return;}
        Kunde kunde = new Kunde(innFornavn.getText(),innEtternavn.getText(),innFakturaAdresse.getText());
        if ((kunde.getFornavn().equals("")) || (kunde.getEtternavn().equals("")) || (kunde.getFakturaadresse().equals(""))){
            comboBox.setValue(comboBox.getPromptText());
            visfeilmelding();
            return;
        }
        switch (comboBox.getValue()){
            case "Baatforsikring" :
                BaatforsikringDialog baatForsikring = new BaatforsikringDialog(kunde);
                break;
            case "Fritidsboligforsikring" :
                FritidsboligforsikringDialog fritidsboligForsikring = new FritidsboligforsikringDialog(kunde);
                break;
            case "Hus og innboforsikring" :
                Hus_og_innboforsikringDialog hus_og_innboforsikringDialog = new Hus_og_innboforsikringDialog(kunde);
                break;
            case "ReiseforsikringDialog" :
                ReiseforsikringDialog reiseforsikringDialog = new ReiseforsikringDialog(kunde);
                break;
        }
        comboBox.setValue(comboBox.getPromptText());
    }
}