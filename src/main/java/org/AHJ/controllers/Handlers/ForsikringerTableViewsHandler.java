package org.AHJ.controllers.Handlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.AHJ.controllers.Handlers.TableViewVerktøy.TableColumnVerktøy;
import org.AHJ.modeller.forsikringer.*;
import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.objekter.tableviewmodeller.LocalDateStringConverter;
import org.AHJ.modeller.objekter.tableviewmodeller.TableViewKolonneModeller;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ForsikringerTableViewsHandler {

    private Kunde kunde;
    private List<Forsikring> forsikringList;
    private Tab forsikringsTab;
    private TabPane forsikringerTabPane;
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
                                         Tab forsikringsTab,
                                         TabPane forsikringerTabPane,
                                         TableView<Baatforsikring> båtView,
                                         TableView<Fritidsboligforsikring> fritidsBoligView,
                                         TableView<Hus_og_innboforsikring> hoiView,
                                         TableView<Reiseforsikring> reiseView) {
        this.kunde = kunde;
        forsikringList = kunde.getForsikringer();

        for (Forsikring f : forsikringList) System.out.println(f.toString());
        this.forsikringsTab = forsikringsTab;
        this.forsikringerTabPane = forsikringerTabPane;
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

    public ForsikringerTableViewsHandler(Kunde kunde, Tab forsikringsTab, TabPane forsikringerTabPane) {
        this.kunde = kunde;
        forsikringList = kunde.getForsikringer();
        this.forsikringsTab = forsikringsTab;
        this.forsikringerTabPane = forsikringerTabPane;


    }

    private void initTables(){

        initDefaultCellValueFactory();
        initBåtCelleValueFactory();
        initBoligCelleValueFactory();
        initReiseCelleValueFactory();

        fyllObservableList();
        båtView.setItems(båtForsikringerObservableList);
        fritidsBoligView.setItems(fritidsboligforsikringerObservableList);
        hoiView.setItems(hoiForsikringerObservableList);
        reiseView.setItems(reiseforsikringerObservableListforsikringObservableList);

    }

    private void initDefaultCommitOnEditEvent(Integer indeks, String verdiPåIndeks){
        Baatforsikring forsikring = new Baatforsikring();
        Method[] methods = forsikring.getClass().getMethods();



    }

    private void initDefaultCellValueFactory(){

        for(Map.Entry<Integer, String> map : TableViewKolonneModeller.defaultForsikringKolonner.entrySet()){
            Integer indeks = map.getKey();
            String verdiPåIndeks = map.getValue();

            TableColumn<? extends Forsikring, ? > båtTemp = båtForsikringKolonner.get(indeks);
            TableColumn<? extends Forsikring, ? > fritidsboligTemp = fritidsBoligForsikringKolonner.get(indeks);
            TableColumn<? extends Forsikring, ? > hoiTemp = hoiForsikringKolonner.get(indeks);
            TableColumn<? extends Forsikring, ? > reiseTemp = reiseForsikringKolonner.get(indeks);

            settCellValueFactory(båtTemp, verdiPåIndeks);
            settCellValueFactory(fritidsboligTemp, verdiPåIndeks);
            settCellValueFactory(hoiTemp, verdiPåIndeks);
            settCellValueFactory(reiseTemp, verdiPåIndeks);

            if(indeks == 0) {
                TableColumnVerktøy.handleLocalDateColumnEdit(båtTemp, fritidsboligTemp, hoiTemp, reiseTemp);
            }
            else if(indeks > 0 && indeks < 3){
                TableColumnVerktøy.handleDoubleColumnEdit(båtTemp, fritidsboligTemp, hoiTemp, reiseTemp);
            }

            else if(indeks > 2){
                TableColumnVerktøy.handleStringColumnEdit(båtTemp, fritidsboligTemp, hoiTemp, reiseTemp);
            }

        }

    }

    private void initBåtCelleValueFactory(){
        for(Map.Entry<Integer, String> map : TableViewKolonneModeller.båtKolonner.entrySet()){
            Integer indeks = map.getKey();
            String verdiPåIndeks = map.getValue();
            settCellValueFactory(båtForsikringKolonner.get(indeks), verdiPåIndeks);
            TableColumn<Forsikring, String> b = (TableColumn<Forsikring, String>) båtForsikringKolonner.get(indeks);
            b.setCellFactory(TextFieldTableCell.forTableColumn());
        }
    }

    private void initBoligCelleValueFactory(){
        for(Map.Entry<Integer, String> map : TableViewKolonneModeller.boligKolonner.entrySet()){
            Integer indeks = map.getKey();
            String verdiPåIndeks = map.getValue();

            TableColumn<? extends Forsikring, ?> fritidsboligTemp = fritidsBoligForsikringKolonner.get(indeks);
            TableColumn<? extends Forsikring, ?> hoiTemp = hoiForsikringKolonner.get(indeks);

            settCellValueFactory(fritidsboligTemp, verdiPåIndeks);
            settCellValueFactory(hoiTemp, verdiPåIndeks);

            if(indeks == 5)
                TableColumnVerktøy.handleIntegerColumnEdit(fritidsboligTemp, hoiTemp);
            if(indeks > 7)
                TableColumnVerktøy.handleDoubleColumnEdit(fritidsboligTemp, hoiTemp);
            else
                TableColumnVerktøy.handleStringColumnEdit(fritidsboligTemp, hoiTemp);
        }
    }

    private void initReiseCelleValueFactory() {
        for(Map.Entry<Integer, String> map : TableViewKolonneModeller.reiseKolonner.entrySet()){
            Integer indeks = map.getKey();
            String verdiPåIndeks = map.getValue();

            TableColumn<? extends Forsikring, ?> reiseTemp = reiseForsikringKolonner.get(indeks);
            settCellValueFactory(reiseTemp, verdiPåIndeks);

            if(indeks == 1){
                TableColumnVerktøy.handleStringColumnEdit(reiseTemp);
            }
            else {
                TableColumnVerktøy.handleDoubleColumnEdit(reiseTemp);
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
            else if (forsikring instanceof Hus_og_innboforsikring)
                hoiForsikringerObservableList.add((Hus_og_innboforsikring) forsikring);
            else if (forsikring instanceof Reiseforsikring)
                reiseforsikringerObservableListforsikringObservableList.add((Reiseforsikring) forsikring);
        }

    }


}
