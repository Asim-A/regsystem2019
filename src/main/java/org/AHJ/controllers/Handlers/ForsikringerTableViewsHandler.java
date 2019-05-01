package org.AHJ.controllers.Handlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.AHJ.modeller.forsikringer.*;
import org.AHJ.modeller.objekter.Kunde;

import java.util.ArrayList;
import java.util.List;

public class ForsikringerTableViewsHandler {

    private Kunde kunde;
    private List<Forsikring> forsikringList;
    private Tab forsikringsTab;
    private TabPane forsikringerTabPane;
    private TableView<Forsikring> båtView;
    private TableView<Forsikring> fritidsBoligView;
    private TableView<Forsikring> hoiView;
    private TableView<Forsikring> reiseView;
    private List<TableColumn<Forsikring, ?>> båtForsikringKolonner;
    private List<TableColumn<Forsikring, ?>> fritidsBoligForsikringKolonner;
    private List<TableColumn<Forsikring, ?>> hoiForsikringKolonner;
    private List<TableColumn<Forsikring, ?>> reiseForsikringKolonner;
    private ObservableList<Forsikring> båtForsikringerObservableList = FXCollections.observableArrayList();
    private ObservableList<Forsikring> fritidsboligforsikringerObservableList = FXCollections.observableArrayList();
    private ObservableList<Forsikring> hoiForsikringerObservableList = FXCollections.observableArrayList();
    private ObservableList<Forsikring> reiseforsikringerObservableListforsikringObservableList = FXCollections.observableArrayList();

    public ForsikringerTableViewsHandler(Kunde kunde,
                                         Tab forsikringsTab,
                                         TabPane forsikringerTabPane,
                                         TableView<Forsikring> båtView,
                                         TableView<Forsikring> fritidsBoligView,
                                         TableView<Forsikring> hoiView,
                                         TableView<Forsikring> reiseView) {
        this.kunde = kunde;
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
    }

    public ForsikringerTableViewsHandler(Kunde kunde, Tab forsikringsTab, TabPane forsikringerTabPane) {
        this.kunde = kunde;
        forsikringList = kunde.getForsikringer();
        this.forsikringsTab = forsikringsTab;
        this.forsikringerTabPane = forsikringerTabPane;

        initTables();
    }

    private void initTables(){

    }

    private List<TableColumn<Forsikring, ?>> hentKolonner(TableView<Forsikring> view){
        List<TableColumn<Forsikring, ?>> kolonneListe = new ArrayList<>();

        for(TableColumn<Forsikring, ?> kolonne : view.getColumns()){
            kolonneListe.add(kolonne);
        }

        return kolonneListe;
    }

    public void fyllObservableList(){
        if(forsikringList.isEmpty()) return;

        for(Forsikring forsikring : forsikringList) {
            if (forsikring instanceof Baatforsikring)
                båtForsikringerObservableList.add(forsikring);
            else if (forsikring instanceof Fritidsboligforsikring)
                fritidsboligforsikringerObservableList.add(forsikring);
            else if (forsikring instanceof Hus_og_innboforsikring)
                hoiForsikringerObservableList.add(forsikring);
            else if (forsikring instanceof Reiseforsikring)
                reiseforsikringerObservableListforsikringObservableList.add(forsikring);
        }

    }
}
