package org.AHJ.controllers.Handlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.AHJ.modeller.forsikringer.Forsikring;
import org.AHJ.modeller.objekter.Kunde;

import java.util.List;

public class ForsikringerTableViewsHandler {

    Kunde kunde;
    List<Forsikring> forsikringList;
    Tab forsikringsTab;
    TabPane forsikringerTabPane;
    ObservableList<Forsikring> forsikringObservableList = FXCollections.observableArrayList();

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
