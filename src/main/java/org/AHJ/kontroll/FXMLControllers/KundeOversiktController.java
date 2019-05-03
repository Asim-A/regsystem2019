package org.AHJ.kontroll.FXMLControllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
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
import org.AHJ.modell.DataValidering.InnskrevetDataValiderer;
import org.AHJ.kontroll.Handlers.Verktøy.TableViewVerktøy;
import org.AHJ.modell.Tasks.FileInputTask;
import org.AHJ.modell.Tasks.FileOutputTask;

import org.AHJ.kontroll.Handlers.KundeOversiktTableViewHandler;

import org.AHJ.modell.objekter.Kunde;
import org.AHJ.modell.objekter.Kunder;
import org.AHJ.modell.vinduer.BaatforsikringSkjemaDialog;
import org.AHJ.modell.vinduer.BoligSkjemaDialog;
import org.AHJ.modell.vinduer.ReiseforsikringSkjemaDialog;
import org.AHJ.modell.vinduer.SkademeldingSkjemaDialog;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;

public class KundeOversiktController {


<<<<<<< HEAD
    private ExecutorService service;
    private Kunder kunder;
    private KundeOversiktTableViewHandler handler;
    private InnskrevetDataValiderer dataValiderer;
    private Kunde kunde;
=======
    ExecutorService service;
    Kunder kunder;
    KundeOversiktTableViewHandler handler;
    InnskrevetDataValiderer dataValiderer;
    Kunde kunde;
    AvviksHåndterer avviksHåndterer;
    private boolean toggled;
>>>>>>> parent of 38ac103... Merge branch 'master' of https://github.com/Asim-A/regsystem2019

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
    public void lastInnKunder() {
        File filTilInnlesning = velgFil();
        if (filTilInnlesning==null){return;}
        Task<Void> task = new FileInputTask(filTilInnlesning, kunder, this::updateKunder);
        task.setOnFailed( e-> visFeilmelding(task.getException().getMessage()));
        handler.getObservableListKunde().clear();
        ioPane.setVisible(true);
        ioProgessBar.progressProperty().unbind();
        ioProgessBar.progressProperty().bind(task.progressProperty());
        service.submit(task);
    }

    private void threadFerdig() {
        handler.addAllObserableKunde(kunder.getKundeListe());
    }

    @FXML
    public void lagreKunder() {
        if (kundeListeErTom()){
            visFeilmelding("Ingen Kunder å lagre");
            return;
        }
        File fileToWrite = velgFil();
        Task<Void> task = new FileOutputTask(fileToWrite, kunder);
        task.setOnFailed(e -> visFeilmelding(task.getException().getMessage()));
        service.submit(task);
    }

    private File velgFil(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Allowed Files", "*.csv","*.jobj"));
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        return fileChooser.showOpenDialog(null);
    }

    private void updateKunder(){
        ioPane.setVisible(false);
        handler.addAllObserableKunde(kunder.getKundeListe());
    }

    private void visFeilmelding(String feilMelding){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.DECORATED);
        alert.setTitle("ERROR");
        alert.setHeaderText("Feilmelding: ");
        alert.setContentText(feilMelding);
        alert.showAndWait();
    }

    private boolean kundeListeErTom(){
        if (kunder.getKundeListe().size() == 0) {
            return true;
        }
        return false;
    }

    private void leggTilKunde(Kunde k){
        kunder.getKundeListe().add(k);
        handler.addObservableKunde(k);
    }
    private void leggTilObservableKunde(Kunde k){
        handler.addObservableKunde(k);
    }

    @FXML
    private void forberedSkademeldingVindu() {
        this.kunde = KundeTableView.getSelectionModel().getSelectedItem();
        if (this.kunde != null) {
            this.kunde = new SkademeldingSkjemaDialog(kunde).getKunde();
        } else {
            try {
                if ((innFornavn.getText().equals("")) || (innEtternavn.getText().equals("")) ||
                        (innFakturaAdresse.getText().equals(""))) {
                    throw new Exception("Alle innskrivingsfelt må fylles ut!\n " +
                            "Kunde må ha forsikring før du kan registrere skademelding");
                }
                if (this.kunde == null) {
                    throw new Exception("Kunde må ha forsikring før du kan registrere skademelding");
                }
                new SkademeldingSkjemaDialog(kunde);
            } catch (Exception e) {
                visFeilmelding(e.getMessage());
            }
        }
    }

    @FXML
    private void forberedForsikringVindu()  {
        try {
            Kunde kunde;
            if (this.kunde==null){
                validerInntastetKundeData();
                kunde = new Kunde(innFornavn.getText(),innEtternavn.getText(),innFakturaAdresse.getText());
            } else {
                kunde = this.kunde;
            }
            String comboBoxValue = comboBox.getValue().toLowerCase();

            if(comboBoxValue.contains("baatforsikring"))
                this.kunde = new BaatforsikringSkjemaDialog(kunde).getKunde();
            else if(comboBoxValue.contains("fritid"))
                this.kunde = new BoligSkjemaDialog(kunde, BoligSkjemaDialog.Bolig.FRITIDS).getKunde();
            else if(comboBoxValue.contains("hus"))
                this.kunde = new BoligSkjemaDialog(kunde, BoligSkjemaDialog.Bolig.HUSOGINNBO).getKunde();
            else if(comboBoxValue.contains("reiseforsikring"))
                this.kunde = new ReiseforsikringSkjemaDialog(kunde).getKunde();
            else
                visFeilmelding("Velg ForsikringsType");

        } catch (DataFormatException | NullPointerException e) {
            visFeilmelding(e.getMessage());
        }
        comboBox.setValue(comboBox.getPromptText());
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
            kunde.setForsikringsnummer(KundeTableView.getItems().size());
            leggTilKunde(this.kunde);
            this.kunde = null;
        }
    }

    private void validerInntastetKundeData() throws DataFormatException, NullPointerException {
        innFornavn.setText(dataValiderer.validerNavn(innFornavn.getText(),innFornavn.getPromptText()));
        innEtternavn.setText(dataValiderer.validerNavn(innEtternavn.getText(),innEtternavn.getPromptText()));
        innFakturaAdresse.setText(dataValiderer.validerTekstMedTall(innFakturaAdresse.getText(),innFakturaAdresse.getPromptText()));
    }

    @FXML
    private void tilbakeStill(){
       innFornavn.setText("");
       innEtternavn.setText("");
       innFakturaAdresse.setText("");
       /*kunde = null;*/
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