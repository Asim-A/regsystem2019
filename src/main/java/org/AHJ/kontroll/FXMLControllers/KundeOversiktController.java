package org.AHJ.kontroll.FXMLControllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import org.AHJ.modell.DataValidering.InnskrevetDataValiderer;
import org.AHJ.kontroll.Handlers.Verktøy.TableViewVerktøy;
import org.AHJ.modell.Tasks.FileInputTask;
import org.AHJ.modell.Tasks.FileOutputTask;

import org.AHJ.kontroll.Handlers.KundeOversiktTableViewHandler;

import org.AHJ.modell.objekter.Kunde;
import org.AHJ.modell.objekter.Kunder;
import org.AHJ.modell.vinduer.*;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;

public class KundeOversiktController {


    private ExecutorService service;
    private Kunder kunder;
    private KundeOversiktTableViewHandler handler;
    private InnskrevetDataValiderer dataValiderer;
    private Kunde kunde;
    private boolean toogle;

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
        ioProgessBar.progressProperty().unbind();
        Task<Void> task = new FileInputTask(filTilInnlesning, kunder, this::oppdaterGUI);
        task.setOnFailed((e->{
            visFeilmelding(task.getException().getMessage());
            oppdaterGUI();
        }));
        task.setOnCancelled(e -> {
            e.consume();
            oppdaterGUI();
        });
        ioPane.setVisible(true);
        handler.getObservableListKunde().clear();
        ioProgessBar.progressProperty().bind(task.progressProperty());
        service.submit(task);
        toogle=false;
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

    private void oppdaterGUI(){
        ioPane.setVisible(false);
        handler.addAllObserableKunde(kunder.getKundeListe());
        toogle=true;
    }

    private void visFeilmelding(String feilMelding){
        if(feilMelding == null) return;
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

    public void leggTilSkademelding(ActionEvent actionEvent) {
        if (!toogle){
            return;
        }
        Kunde tempKunde;
        if (KundeTableView.getSelectionModel().getSelectedItem() != null) {
            tempKunde = KundeTableView.getSelectionModel().getSelectedItem();
            new SkademeldingSkjemaDialog(tempKunde);
        }
        else return;
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
        if (!toogle){
            return;
        }
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
        kunder.getKundeListe().removeAll(TableViewVerktøy.hentMarkertListe(KundeTableView));
        TableViewVerktøy.slettMerkedeRader(KundeTableView, handler.getObservableListKunde());
    }

    public void slettRaderMeny(ActionEvent actionEvent) {
        kunder.getKundeListe().removeAll(TableViewVerktøy.hentMarkertListe(KundeTableView));
        TableViewVerktøy.slettMerkedeRader(KundeTableView, handler.getObservableListKunde());
    }

    public void visMerKnapp(ActionEvent actionEvent) {
        Kunde kunde = (Kunde)TableViewVerktøy.hentMarkertObjekt(KundeTableView);
        KundeInfoDialog kd = new KundeInfoDialog(kunde);
    }
}