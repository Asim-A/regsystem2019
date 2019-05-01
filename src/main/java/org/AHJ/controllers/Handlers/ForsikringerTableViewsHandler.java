package org.AHJ.controllers.Handlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.AHJ.modeller.forsikringer.*;
import org.AHJ.modeller.objekter.Kunde;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        settCellValueFactory(båtForsikringKolonner.get(4), "eier");

        fyllObservableList();
        båtView.setItems(båtForsikringerObservableList);
        fritidsBoligView.setItems(fritidsboligforsikringerObservableList);
        hoiView.setItems(hoiForsikringerObservableList);
        reiseView.setItems(reiseforsikringerObservableListforsikringObservableList);

    }

    private void initDefaultCellValueFactory(){

        //hack måte å initiere default felt
        final String[] forsikringsfelt = {"dato", "forsikringspremie", "forsikringsbeløp", "forsikringsbetingelser"};
        for(int i = 0; i < forsikringsfelt.length; i++) {
            settCellValueFactory(båtForsikringKolonner.get(i), forsikringsfelt[i]);
            settCellValueFactory(fritidsBoligForsikringKolonner.get(i), forsikringsfelt[i]);
            settCellValueFactory(hoiForsikringKolonner.get(i), forsikringsfelt[i]);
            settCellValueFactory(reiseForsikringKolonner.get(i), forsikringsfelt[i]);
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
