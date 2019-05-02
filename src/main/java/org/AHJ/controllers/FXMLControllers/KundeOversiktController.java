package org.AHJ.controllers.FXMLControllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.controllers.Handlers.Verktøy.TableViewVerktøy;
import org.AHJ.controllers.Tasks.FileInputTask;
import org.AHJ.controllers.Tasks.FileOutputTask;

import org.AHJ.controllers.Handlers.KundeOversiktTableViewHandler;

import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.objekter.Kunder;

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
    InnskrevetDataValiderer dataValiderer;
    Kunde kunde;
    private boolean toggled;

    /////////////////////////////////////////////////////
    //ved edit av forsikringsnummer
    /*    int minValue=forskringsViewHandler.getObservableListKunde().size();
        if (Integer.valueOf(ForsikringsnummerKolonne.getText())<minValue){
            visFeilmelding("Forsikringsnummer må vøre unikt");
        }*/

    @FXML
    JFXTextField innFakturaAdresse, innEtternavn, innFornavn;
    @FXML
    JFXComboBox<String> comboBox;
    @FXML
    TextField filtrertTekst;
    @FXML
    JFXProgressBar ioProgessBar;
    @FXML
    Pane ioPane;
    @FXML
    TableView<Kunde> KundeTableView;
    @FXML
    TableColumn<Kunde, LocalDate> DatoKolonne;
    @FXML
    TableColumn<Kunde, String> FornavnKolonne, EtternavnKolonne, FakturaadresseKolonne;
    @FXML
    TableColumn<Kunde, Integer> ForsikringsnummerKolonne, UbetalteErstattningerKolonne;

    public KundeOversiktController() {
        service = Executors.newSingleThreadExecutor();
        kunder = new Kunder();
        System.out.println("Kunder added to kundeListe");
    }

    @FXML
    public void initialize(){

        handler = new KundeOversiktTableViewHandler(
                KundeTableView,
                DatoKolonne,
                FornavnKolonne,
                EtternavnKolonne,
                ForsikringsnummerKolonne,
                FakturaadresseKolonne,
                UbetalteErstattningerKolonne,
                filtrertTekst
        );



        KundeTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        comboBox.getItems().addAll("Baatforsikring","Fritidsboligforsikring",
                "Hus og innboforsikring", "Reiseforsikring");
        this.dataValiderer = new InnskrevetDataValiderer();
    }

    @FXML
    public void lastInnKunder(ActionEvent actionEvent) {
        File fileToRead = getChosenFile();
        handler.getObservableListKunde().clear();
        kunder.setKundeListe(new ArrayList<>());
        try {
            Task<Void> task = new FileInputTask(fileToRead, kunder, this::updateKunder);
            ioPane.setVisible(true);
            ioProgessBar.progressProperty().unbind();
            ioProgessBar.progressProperty().bind(task.progressProperty());
            service.submit(task);
        } catch (Exception e){
            System.out.println("Exeption");
            visFeilmelding("kunne ikke laste inn data");
        }
    }

    @FXML
    public void lagreKunder(ActionEvent actionEvent) {
        File fileToWrite = getChosenFile();
        Task<Void> task = new FileOutputTask(fileToWrite, kunder);
        service.submit(task);
    }

    private File getChosenFile(){
        FileChooser fileChooser = new FileChooser();
       /* fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.csv","*.jobj"));*/
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        return fileChooser.showOpenDialog(null);
    }

    private void updateKunder(){
        ioPane.setVisible(false);
        handler.addAllObserableKunde(kunder.getKundeListe());
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
        alert.initStyle(StageStyle.DECORATED);
        alert.setTitle("ERROR");
        alert.setHeaderText("Feilmelding: ");
        alert.setContentText(feilMelding);
        alert.showAndWait();
    }

    @FXML
    private void forberedSkademeldingVindu(){
        try {
            if((innFornavn.getText().equals("")) || (innEtternavn.getText().equals("")) ||
                    (innFakturaAdresse.getText().equals(""))){
                throw new NullPointerException("Alle innskrivingsfelt må fylles ut!\n "+
                        "Kunde må ha forsikring før du kan registrere skademelding");
            }
            if(this.kunde==null){
                throw new NullPointerException("Kunde må ha forsikring før du kan registrere skademelding");
            }
            visSkjemaVindu("Skademelding","views/Skademelding.fxml", this.kunde);
        } catch (NullPointerException npe){
            visFeilmelding(npe.getMessage());
        }
    }

    @FXML
    private void forberedForsikringVindu(ActionEvent actionEvent)  {
        try {
            Kunde kunde;
            if (this.kunde==null){
                validerInntastetKundeData();
                kunde = new Kunde(innFornavn.getText(),innEtternavn.getText(),innFakturaAdresse.getText());
            } else {
                kunde = this.kunde;
            }
            switch (comboBox.getValue()){
                case "Baatforsikring" :
                    visSkjemaVindu(comboBox.getValue(),"views/Baatforsikring.fxml",kunde);
                    break;
                case "Hus og innboforsikring" :
                case "Fritidsboligforsikring" :
                    visSkjemaVindu(comboBox.getValue(),"views/Fritidsboligforsikring.fxml",kunde);
                    break;
                case "Reiseforsikring" :
                    visSkjemaVindu(comboBox.getValue(),"views/Reiseforsikring.fxml",kunde);
                    break;
                default :
                    visFeilmelding("Velg ForsikringsType");
            }
        } catch (DataFormatException | NullPointerException e) {
            visFeilmelding(e.getMessage());
        }
        comboBox.setValue(comboBox.getPromptText());
    }

    private void visSkjemaVindu(String skjema, String fxml, Kunde kunde){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource(fxml));
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (skjema.equals("Baatforsikring")) {
            BaatforsikringSkjemaController skjemaController = loader.getController();
            skjemaController.setKunde(kunde);
        } else if (skjema.equals("Fritidsboligforsikring") || skjema.equals("Hus og innboforsikring") ) {
            BoligforsikringSkjemaController skjemaController = loader.getController();
            skjemaController.setKunde(kunde);
            skjemaController.setOverskrift(skjema);
        } else if (skjema.equals("Reiseforsikring")) {
            ReiseforsikringSkjemaController skjemaController = loader.getController();
            skjemaController.setKunde(kunde);
        } else if (skjema.equals("Skademelding")){
            SkademeldingSkjemaController skjemaController = loader.getController();
            skjemaController.setKunde(kunde);
        }
        root.getStylesheets().add("views/test.css");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(skjema);
        stage.setScene(new Scene(root));
        stage.showAndWait();
        this.kunde = kunde;
        System.out.println("navn "+kunde.getFornavn()+" forsikringer "+kunde.getForsikringer().size());
    }

    @FXML
    private void registrerKunde(){
        if (kunde==null){
            try {
                validerInntastetKundeData();
                kunde = new Kunde(innFornavn.getText(),innEtternavn.getText(),innFakturaAdresse.getText());
                kunde.oppdaterUbetalte_Erstatninger();
                leggTilKunde(this.kunde);
                this.kunde = null;
            } catch (Exception e){
                visFeilmelding(e.getMessage());
            }
        } else {
            kunde.oppdaterUbetalte_Erstatninger();
            leggTilKunde(this.kunde);
            this.kunde = null;
        }
    }

    private void validerInntastetKundeData() throws DataFormatException, NullPointerException {
        innFornavn.setText(dataValiderer.validerNavn(innFornavn.getText(),innFornavn.getPromptText()));
        innEtternavn.setText(dataValiderer.validerNavn(innEtternavn.getText(),innEtternavn.getPromptText()));
        innFakturaAdresse.setText(dataValiderer.validerTekstMedTall(innFakturaAdresse.getText(),innFakturaAdresse.getPromptText()));
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

    public void slettRader(ActionEvent actionEvent) {
        TableViewVerktøy.slettMerkedeRader(KundeTableView, handler.getObservableListKunde());
    }

    public void slettRaderMeny(ActionEvent actionEvent) {
        TableViewVerktøy.slettMerkedeRader(KundeTableView, handler.getObservableListKunde());
    }
}