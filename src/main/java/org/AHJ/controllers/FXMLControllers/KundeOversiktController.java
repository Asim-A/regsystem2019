package org.AHJ.controllers.FXMLControllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.controllers.Tasks.FileInputTask;
import org.AHJ.controllers.Tasks.FileOutputTask;

import org.AHJ.controllers.Handlers.KundeOversiktTableViewHandler;

import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.objekter.Kunder;
import org.AHJ.modeller.vinduer.BaatforsikringDialog;
import org.AHJ.modeller.vinduer.FritidsboligforsikringDialog;
import org.AHJ.modeller.vinduer.ReiseforsikringDialog;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;

public class KundeOversiktController {

    ExecutorService service;
    Kunder kunder;
    KundeOversiktTableViewHandler handler;
    InnskrevetDataValiderer innDataValiderer;

    /////////////////////////////////////////////////////
    //ved edit av forsikringsnummer
    /*    int minValue=handler.getObservableListKunde().size();
        if (Integer.valueOf(ForsikringsnummerColumn.getText())<minValue){
            visFeilmelding("Forsikringsnummer må vøre unikt");
        }*/
    @FXML
    JFXTextField innFakturaAdresse, innEtternavn, innFornavn;
    @FXML
    JFXComboBox<String> comboBox;
    @FXML
    TextField filtrertTekst;
    @FXML
    TableView<Kunde> KundeTableView;
    @FXML
    TableColumn<Kunde, LocalDate> DatoColumn;
    @FXML
    TableColumn<Kunde, String> FornavnColumn, EtternavnColumn, FakturaadresseColumn;
    @FXML
    TableColumn<Kunde, Integer> ForsikringsnummerColumn;
    @FXML
    ToggleGroup search;

    public KundeOversiktController() {
        service = Executors.newSingleThreadExecutor();
        kunder = new Kunder();
        System.out.println("Kunder added to kundeListe");
    }

    @FXML
    public void initialize(){

        handler = new KundeOversiktTableViewHandler(
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
        comboBox.getItems().addAll("Baatforsikring","Fritidsboligforsikring",
                "Hus og innboforsikring", "Reiseforsikring");
        this.innDataValiderer = new InnskrevetDataValiderer();
    }

    @FXML
    public void lastInnKunder(ActionEvent actionEvent) {
        File fileToRead = getChosenFile();
        kunder.setKundeListe(new ArrayList<>());
        Task<Void> task = new FileInputTask(fileToRead, kunder, this::updateKunder);
        try {
            service.submit(task);
        } catch (Exception e){
            System.out.println("Exeption");
        }
    }

    @FXML
    public void lagreKunder(ActionEvent actionEvent) {
        File fileToWrite = getChosenFile();
        Task<Void> task = new FileOutputTask(fileToWrite, kunder);
        service.submit(task);
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
        //   handler.setObservableListKunde(FXCollections.observableArrayList());
        handler.addAllObserableKunde(kunder.getKundeListe());
      //  System.out.println("kunder" + kunder.getKundeListe().get(0).getFornavn());
    }

    private void leggTilKunde(Kunde k){
        kunder.getKundeListe().add(k);
        handler.addObservableKunde(k);
    }

    private void leggTilObservableKunde(Kunde k){
        handler.addObservableKunde(k);
    }

    private void visFeilmelding(String feilMelding){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("ERROR");
        alert.setContentText(feilMelding);
        alert.showAndWait();
    }

    @FXML
    private void visForsikring()  {
        try {
            validerInntastetKundeData();
            Kunde kunde = new Kunde(innFornavn.getText(),innEtternavn.getText(),innFakturaAdresse.getText());
            System.out.println(kunde.getFornavn());
            switch (comboBox.getValue()){
                case "Baatforsikring" :
                    visForsikringVindu(comboBox.getValue(),"views/Baatforsikring.fxml",kunde);
                    break;
                case "Hus og innboforsikring" :
                case "Fritidsboligforsikring" :
                    visForsikringVindu(comboBox.getValue(),"views/Fritidsboligforsikring.fxml",kunde);
                    break;
                case "Reiseforsikring" :
                    visForsikringVindu(comboBox.getValue(),"views/Reiseforsikring.fxml",kunde);
                    break;
            }
        } catch (DataFormatException | NullPointerException e) {
            visFeilmelding(e.getMessage());
        }
        comboBox.setValue(comboBox.getPromptText());
    }

    private void visForsikringVindu(String forsikring, String fxml, Kunde kunde){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource(fxml));
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (forsikring.equals("Baatforsikring")) {
            BaatforsikringDialog forsikringDialog = loader.getController();
            forsikringDialog.setKunde(kunde);
        } else if (forsikring.equals("Fritidsboligforsikring") || forsikring.equals("Hus og innboforsikring") ) {
            FritidsboligforsikringDialog forsikringDialog = loader.getController();
            forsikringDialog.setKunde(kunde);
            forsikringDialog.setOverskrift(forsikring);
        } else if (forsikring.equals("Reiseforsikring")) {
            ReiseforsikringDialog forsikringDialog = loader.getController();
            forsikringDialog.setKunde(kunde);
        }
        root.getStylesheets().add("views/test.css");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(forsikring);
        stage.setScene(new Scene(root));
        stage.showAndWait();
        leggTilKunde(kunde);
        System.out.println("navn "+kunde.getFornavn()+" forsikringer "+kunde.getForsikringer().size());
    }

    private void validerInntastetKundeData() throws DataFormatException, NullPointerException {
        innDataValiderer.validerNavn(innFornavn.getText(),innFornavn.getPromptText());
        innDataValiderer.validerNavn(innEtternavn.getText(),innEtternavn.getPromptText());
        innDataValiderer.validerTekstMedTall(innFakturaAdresse.getText(),innFakturaAdresse.getPromptText());
    }

    public void tømRessurser() {
        terminerExecutorService();
    }

    public void terminerExecutorService(){
        service.shutdown();
        try {
            if (!service.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }

    public ExecutorService getService() {
        return service;
    }
}