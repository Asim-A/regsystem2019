package org.AHJ.controllers.Handlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.skjema.Skademelding;

import java.util.List;

public class SkademeldingTableViewHandler {

    private TableView<Skademelding> skademeldingTableView;
    private Kunde kunde;
    private List<Skademelding> skademeldinger;
    private ObservableList<Skademelding> skademeldingObservableList= FXCollections.observableArrayList();

    public SkademeldingTableViewHandler(TableView<Skademelding> skademeldingTableView, Kunde kunde) {
        this.skademeldingTableView = skademeldingTableView;
        this.kunde = kunde;
        skademeldinger = kunde.getSkademeldinger();
    }

    private void fyllObservableList(){
        skademeldingObservableList.addAll(skademeldinger);
    }
}
