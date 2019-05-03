package org.AHJ.kontroll.Handlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.AHJ.kontroll.Handlers.Verktøy.TableColumnVerktøy;
import org.AHJ.modell.forsikringer.*;
import org.AHJ.modell.objekter.Kunde;
import org.AHJ.modell.objekter.tableviewmodeller.TableViewKolonneModeller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ForsikringerTableViewsHandler {

    private Kunde kunde;
    private List<Forsikring> forsikringList;
    private TableView<Baatforsikring> båtView;
    private TableView<Fritidsboligforsikring> fritidsBoligView;
    private TableView<Hus_og_innboforsikring> hoiView;
    private TableView<Reiseforsikring> reiseView;
    private List<TableColumn<? extends Forsikring, ?>> båtForsikringKolonner;
    private List<TableColumn<? extends Forsikring, ?>> fritidsBoligForsikringKolonner;
    private List<TableColumn<? extends Forsikring, ?>> hoiForsikringKolonner;
    private List<TableColumn<? extends Forsikring, ?>> reiseForsikringKolonner;
    private ObservableList<Baatforsikring> båtForsikringerObservableList = FXCollections.observableArrayList();
    private ObservableList<Fritidsboligforsikring> fritidsboligforsikringerObservableList = FXCollections.observableArrayList();
    private ObservableList<Hus_og_innboforsikring> hoiForsikringerObservableList = FXCollections.observableArrayList();
    private ObservableList<Reiseforsikring> reiseforsikringerObservableListforsikringObservableList = FXCollections.observableArrayList();

    public ForsikringerTableViewsHandler(Kunde kunde,
                                         TableView<Baatforsikring> båtView,
                                         TableView<Fritidsboligforsikring> fritidsBoligView,
                                         TableView<Hus_og_innboforsikring> hoiView,
                                         TableView<Reiseforsikring> reiseView) {
        this.kunde = kunde;
        forsikringList = kunde.getForsikringer();
        this.båtView = båtView;
        this.båtForsikringKolonner = hentKolonner(båtView);
        this.fritidsBoligView = fritidsBoligView;
        this.fritidsBoligForsikringKolonner = hentKolonner(fritidsBoligView);
        this.hoiView = hoiView;
        this.hoiForsikringKolonner = hentKolonner(hoiView);
        this.reiseView = reiseView;
        this.reiseForsikringKolonner = hentKolonner(reiseView);
        initTables();
    }

    private void initTables(){

        initAlleCeller();
        fyllObservableList();
        fyllAlleTableViews();

        båtView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        fritidsBoligView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        hoiView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        reiseView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private void fyllAlleTableViews(){
        båtView.setItems(båtForsikringerObservableList);
        fritidsBoligView.setItems(fritidsboligforsikringerObservableList);
        hoiView.setItems(hoiForsikringerObservableList);
        reiseView.setItems(reiseforsikringerObservableListforsikringObservableList);
    }

    private void initAlleCeller(){
        initDefaultCeller();
        initBåtCeller();
        initBoligCeller();
        initReiseCeller();
    }

    private void initDefaultCeller(){

        for(Map.Entry<Integer, String> map : TableViewKolonneModeller.defaultForsikringKolonner.entrySet()){
            Integer indeks = map.getKey();
            String verdiPåIndeks = map.getValue();

            TableColumn<? extends Forsikring, ? > båtTemp = båtForsikringKolonner.get(indeks);
            TableColumn<? extends Forsikring, ? > fritidsboligTemp = fritidsBoligForsikringKolonner.get(indeks);
            TableColumn<? extends Forsikring, ? > hoiTemp = hoiForsikringKolonner.get(indeks);
            TableColumn<? extends Forsikring, ? > reiseTemp = reiseForsikringKolonner.get(indeks);

            initDefaultCelleValueFactory(verdiPåIndeks, båtTemp, fritidsboligTemp, hoiTemp, reiseTemp);
            initDefaultCelleFactory(indeks, båtTemp, fritidsboligTemp, hoiTemp, reiseTemp);

        }

    }

    private void initDefaultCelleValueFactory(String verdi, TableColumn<? extends Forsikring, ? >... defaultKolonner){
        for(TableColumn<? extends Forsikring, ?> kolonne : defaultKolonner){
            settCellValueFactory(kolonne, verdi);
        }
    }

    private void initDefaultCelleFactory(int indeks, TableColumn<? extends Forsikring, ?>... defaultKolonner){
        for(TableColumn<? extends Forsikring, ?> kolonne: defaultKolonner){
            if(indeks == 0) {
                TableColumnVerktøy.handleLocalDateKolonneEdit(kolonne);
            }
            else if(indeks > 0 && indeks < 3){
                TableColumnVerktøy.handleDoubleKolonneEdit(kolonne);
            }

            else if(indeks > 2){
                TableColumnVerktøy.handleStringKolonneEdit(kolonne);
            }
            initDefaultCommitOnEditEvent(indeks, kolonne);
        }
    }

    private void initDefaultCommitOnEditEvent(int indeks, TableColumn<? extends Forsikring, ?> kolonne){

        switch(indeks){
            case 0:
                kolonne.setOnEditCommit(e -> e.getRowValue().setDato((LocalDate) e.getNewValue()));
                break;
            case 1:
                kolonne.setOnEditCommit(e -> e.getRowValue().setForsikringspremie((Double)e.getNewValue()));
                break;
            case 2:
                kolonne.setOnEditCommit(e -> e.getRowValue().setForsikringsbeløp((Double)e.getNewValue()));
                break;
            case 3:
                kolonne.setOnEditCommit(e -> e.getRowValue().setForsikringsbetingelser((String)e.getNewValue()));
        }

    }

    private void initBåtCeller(){
        for(Map.Entry<Integer, String> map : TableViewKolonneModeller.båtKolonner.entrySet()){
            Integer indeks = map.getKey();
            String verdiPåIndeks = map.getValue();
            TableColumn<Baatforsikring, ?> båtKolonne = (TableColumn<Baatforsikring, ?>) båtForsikringKolonner.get(indeks);
            settCellValueFactory(båtKolonne, verdiPåIndeks);
            TableColumnVerktøy.handleStringKolonnerEdit(båtKolonne);
            initBåtCommitOnEditEvent(indeks, båtKolonne);
        }
    }

    private void initBåtCommitOnEditEvent(int indeks, TableColumn<Baatforsikring, ?> kolonne){
        switch(indeks) {
            case 4:
                kolonne.setOnEditCommit(e -> e.getRowValue().setEier((String) e.getNewValue()));
                break;
            case 5:
                kolonne.setOnEditCommit(e -> e.getRowValue().setRegistreringsnummer((String) e.getNewValue()));
                break;
            case 6:
                kolonne.setOnEditCommit(e -> e.getRowValue().setBåttypeogModell((String)e.getNewValue()));
                break;
            case 7:
                kolonne.setOnEditCommit(e -> e.getRowValue().setLengde_i_fot((String) e.getNewValue()));
                break;
            case 8:
                kolonne.setOnEditCommit(e -> e.getRowValue().setÅrsmodell((String) e.getNewValue()));
                break;
            case 9:
                kolonne.setOnEditCommit(e -> e.getRowValue().setMotortype_og_motorstyrke((String) e.getNewValue()));

        }
    }

    private void initBoligCeller(){
        for(Map.Entry<Integer, String> map : TableViewKolonneModeller.boligKolonner.entrySet()){
            Integer indeks = map.getKey();
            String verdiPåIndeks = map.getValue();

            TableColumn<Fritidsboligforsikring, ?> fritidsboligTemp = (TableColumn<Fritidsboligforsikring, ?>) fritidsBoligForsikringKolonner.get(indeks);
            TableColumn<Hus_og_innboforsikring, ?> hoiTemp = (TableColumn<Hus_og_innboforsikring, ?>) hoiForsikringKolonner.get(indeks);

            settCellValueFactory(fritidsboligTemp, verdiPåIndeks);
            settCellValueFactory(hoiTemp, verdiPåIndeks);

            if(indeks == 5)
                TableColumnVerktøy.handleIntegerKolonnerEdit(fritidsboligTemp, hoiTemp);
            else if (indeks > 8)
                TableColumnVerktøy.handleDoubleKolonnerEdit(fritidsboligTemp, hoiTemp);
            else
                TableColumnVerktøy.handleStringKolonnerEdit(fritidsboligTemp, hoiTemp);

            initBoligCommitOnCellEdit(indeks, fritidsboligTemp);
            initBoligCommitOnCellEdit(indeks, hoiTemp);
        }
    }

    private void initBoligCommitOnCellEdit(int indeks, TableColumn<? extends Boligforsikring, ?> boligKolonne){
        switch(indeks){
            case 4:
                boligKolonne.setOnEditCommit(e -> e.getRowValue().setAdresse((String) e.getNewValue()));
                break;
            case 5:
                boligKolonne.setOnEditCommit(e -> e.getRowValue().setByggeÅr((Integer) e.getNewValue()));
                break;
            case 6:
                boligKolonne.setOnEditCommit(e -> e.getRowValue().setBoligtype((String) e.getNewValue()));
                break;
            case 7:
                boligKolonne.setOnEditCommit(e -> e.getRowValue().setByggemateriale((String) e.getNewValue()));
                break;
            case 8:
                boligKolonne.setOnEditCommit(e -> e.getRowValue().setStandard((String) e.getNewValue()));
                break;
            case 9:
                boligKolonne.setOnEditCommit(e -> e.getRowValue().setKvadratmeter((Double) e.getNewValue()));
                break;
            case 10:
                boligKolonne.setOnEditCommit(e -> e.getRowValue().setForsikringsbeløp_for_bygning((Double) e.getNewValue()));
                break;
            case 11:
                boligKolonne.setOnEditCommit(e -> e.getRowValue().setForsikringsbeløp_for_innbo((Double) e.getNewValue()));
                break;

        }
    }

    private void initReiseCeller() {
        for(Map.Entry<Integer, String> map : TableViewKolonneModeller.reiseKolonner.entrySet()){
            Integer indeks = map.getKey();
            String verdiPåIndeks = map.getValue();

            TableColumn<Reiseforsikring, ?> reiseTemp = (TableColumn<Reiseforsikring, ?>) reiseForsikringKolonner.get(indeks);
            settCellValueFactory(reiseTemp, verdiPåIndeks);

            if(indeks == 4) {
                TableColumnVerktøy.handleStringKolonneEdit(reiseTemp);
                reiseTemp.setOnEditCommit(e -> e.getRowValue().setForsikringsOmråde((String) e.getNewValue()));
            }
            else if(indeks == 5) {
                TableColumnVerktøy.handleDoubleKolonneEdit(reiseTemp);
                reiseTemp.setOnEditCommit(e -> e.getRowValue().setForsikringsSum((Double) e.getNewValue()));
            }
        }
    }

    private <S,T> void settCellValueFactory(TableColumn<S,T> kolonne, String egenskap){
        kolonne.setCellValueFactory(new PropertyValueFactory<>(egenskap));
    }

    private List<TableColumn<? extends Forsikring, ?>> hentKolonner(TableView< ?extends Forsikring> view){
        List<TableColumn<? extends Forsikring, ?>> kolonneListe = new ArrayList<>();

        for(TableColumn<? extends Forsikring, ?> kolonne : view.getColumns()){
            kolonneListe.add(kolonne);
        }

        return kolonneListe;
    }

    public void fyllObservableList(){
        if(forsikringList.isEmpty()) return;

        for(Forsikring forsikring : forsikringList) {
            if (forsikring instanceof Baatforsikring)
                båtForsikringerObservableList.add((Baatforsikring) forsikring);
            else if (forsikring instanceof Fritidsboligforsikring)
                fritidsboligforsikringerObservableList.add((Fritidsboligforsikring) forsikring);
            else if (forsikring instanceof Hus_og_innboforsikring) {
                hoiForsikringerObservableList.add((Hus_og_innboforsikring) forsikring);
            }
            else if (forsikring instanceof Reiseforsikring)
                reiseforsikringerObservableListforsikringObservableList.add((Reiseforsikring) forsikring);
        }

    }


}
