package org.AHJ.controllers.Handlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import org.AHJ.modeller.forsikringer.Forsikring;
import org.AHJ.modeller.objekter.Kunde;

import java.util.List;

public class ForsikringerTableViewsHandler {

    Kunde kunde;
    List<Forsikring> forsikringList;
    Tab forsikringsTab;
    TabPane forsikringerTabPane;
    List<TableColumn<Forsikring, ?>> båtForsikringKolonner;
    List<TableColumn<Forsikring, ?>> fritidsBoligForsikringKolonner;
    List<TableColumn<Forsikring, ?>> hoiForsikringKolonner;
    List<TableColumn<Forsikring, ?>> reiseForsikringKolonner;
    ObservableList<Forsikring> forsikringObservableList = FXCollections.observableArrayList();

    public ForsikringerTableViewsHandler(Kunde kunde,
                                         Tab forsikringsTab,
                                         TabPane forsikringerTabPane,
                                         List<TableColumn<Forsikring, ?>> båtForsikringKolonner,
                                         List<TableColumn<Forsikring, ?>> fritidsBoligForsikringKolonner,
                                         List<TableColumn<Forsikring, ?>> hoiForsikringKolonner,
                                         List<TableColumn<Forsikring, ?>> reiseForsikringKolonner) {
        this.kunde = kunde;
        this.forsikringsTab = forsikringsTab;
        this.forsikringerTabPane = forsikringerTabPane;
        this.båtForsikringKolonner = båtForsikringKolonner;
        this.fritidsBoligForsikringKolonner = fritidsBoligForsikringKolonner;
        this.hoiForsikringKolonner = hoiForsikringKolonner;
        this.reiseForsikringKolonner = reiseForsikringKolonner;
    }

    public ForsikringerTableViewsHandler(Kunde kunde, Tab forsikringsTab, TabPane forsikringerTabPane) {
        this.kunde = kunde;
        forsikringList = kunde.getForsikringer();
        this.forsikringsTab = forsikringsTab;
        this.forsikringerTabPane = forsikringerTabPane;

        initTables();
    }

    public void initTables(){

    }

    public void fyllObservableList(){
        if(forsikringList.isEmpty()) return;

        forsikringObservableList.addAll(forsikringList);
    }
}
