package org.AHJ.controllers.Handlers;


import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import org.AHJ.models.objekter.Kunde;
import org.AHJ.models.vinduer.KundeDialog;

import java.time.LocalDate;

public class TableViewHandler{

    TextField filtrertTekst;

    TableView<Kunde> KundeTableView;

    TableColumn<Kunde, LocalDate> DatoColumn;
    TableColumn<Kunde, String> FornavnColumn;
    TableColumn<Kunde, String> EtternavnColumn;
    TableColumn<Kunde, Integer> ForsikringsnummerColumn;
    TableColumn<Kunde, String> FakturaadresseColumn;
    private ObservableList<Kunde> observableListKunde = FXCollections.observableArrayList();

    public TableViewHandler(
            TableView<Kunde> kundeTableView,
            TableColumn<Kunde, LocalDate> datoColumn,
            TableColumn<Kunde, String> fornavnColumn,
            TableColumn<Kunde, String> etternavnColumn,
            TableColumn<Kunde, Integer> forsikringsnummerColumn,
            TableColumn<Kunde, String> fakturaadresseColumn, TextField filtrertTekst)
    {
        KundeTableView = kundeTableView;
        DatoColumn = datoColumn;
        FornavnColumn = fornavnColumn;
        EtternavnColumn = etternavnColumn;
        ForsikringsnummerColumn = forsikringsnummerColumn;
        FakturaadresseColumn = fakturaadresseColumn;
        this.filtrertTekst = filtrertTekst;

        initTable();
    }

    private void initTable(){



        DatoColumn.setCellValueFactory(new PropertyValueFactory<>("dato"));

        FornavnColumn.setCellValueFactory(new PropertyValueFactory<>("fornavn"));
        FornavnColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        FornavnColumn.setOnEditCommit(kundeStringCellEditEvent -> (kundeStringCellEditEvent.getTableView().getItems().get(
                kundeStringCellEditEvent.getTablePosition().getRow())
        ).setFornavn(kundeStringCellEditEvent.getNewValue()));

        EtternavnColumn.setCellValueFactory(new PropertyValueFactory<>("etternavn"));
        EtternavnColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        EtternavnColumn.setOnEditCommit(kundeStringCellEditEvent -> (kundeStringCellEditEvent.getTableView().getItems().get(
                kundeStringCellEditEvent.getTablePosition().getRow())
        ).setFornavn(kundeStringCellEditEvent.getNewValue()));

        ForsikringsnummerColumn.setCellValueFactory(new PropertyValueFactory<>("forsikringsnummer"));

        FakturaadresseColumn.setCellValueFactory(new PropertyValueFactory<>("fakturaadresse"));
        FakturaadresseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        FakturaadresseColumn.setOnEditCommit(kundeStringCellEditEvent -> (kundeStringCellEditEvent.getTableView().getItems().get(
                kundeStringCellEditEvent.getTablePosition().getRow())
        ).setFornavn(kundeStringCellEditEvent.getNewValue()));

        FilteredList<Kunde> filtrertData = new FilteredList<>(observableListKunde, p -> true);
        filtrertTekst.textProperty().addListener(
                (observables, gammelVerdi, nyVerdi) -> filtrertData.setPredicate(kunde -> {

            if (nyVerdi == null || nyVerdi.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = nyVerdi.toLowerCase();

            if (kunde.getFornavn().toLowerCase().contains(lowerCaseFilter)) return true;
            else if (kunde.getEtternavn().toLowerCase().contains(lowerCaseFilter)) return true;

            return false;

        }));

        KundeTableView.setRowFactory(kundeTableView -> {

            final TableRow<Kunde> rad = new TableRow<>();
            final ContextMenu radMeny = new ContextMenu();
            MenuItem visMer = new MenuItem("Vis mer");
            visMer.setOnAction(e -> {
                KundeDialog kd = new KundeDialog();
            });

            radMeny.getItems().addAll(visMer);

            rad.contextMenuProperty().bind(
                    Bindings.when(Bindings.isNotNull(rad.itemProperty()))
                            .then(radMeny)
                            .otherwise((ContextMenu)null));
            return rad;
        });

        SortedList<Kunde> sortertListe = new SortedList<>(filtrertData);
        sortertListe.comparatorProperty().bind(KundeTableView.comparatorProperty());

        KundeTableView.setItems(sortertListe);
    }

    public void addObservableKunde(Kunde kunde) {
        observableListKunde.add(kunde);
    }

    public ObservableList<Kunde> getObservableListKunde() {
        return observableListKunde;
    }

    public void setObservableListKunde(ObservableList<Kunde> observableListKunde) {
        this.observableListKunde = observableListKunde;
    }

    public void syncLists(){
        observableListKunde.addListener((ListChangeListener<Kunde>) change -> {
            //add to list
        });
    }
}
