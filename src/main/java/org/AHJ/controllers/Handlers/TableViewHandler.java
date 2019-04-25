package org.AHJ.controllers.Handlers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.AHJ.models.objekter.Kunde;

import java.time.LocalDate;

public class TableViewHandler{


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
            TableColumn<Kunde, String> fakturaadresseColumn)
    {
        KundeTableView = kundeTableView;
        DatoColumn = datoColumn;
        FornavnColumn = fornavnColumn;
        EtternavnColumn = etternavnColumn;
        ForsikringsnummerColumn = forsikringsnummerColumn;
        FakturaadresseColumn = fakturaadresseColumn;

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

        FakturaadresseColumn.setCellValueFactory(new PropertyValueFactory<>("fakturaadresse"));
        FakturaadresseColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        FakturaadresseColumn.setOnEditCommit(kundeStringCellEditEvent -> (kundeStringCellEditEvent.getTableView().getItems().get(
                kundeStringCellEditEvent.getTablePosition().getRow())
        ).setFornavn(kundeStringCellEditEvent.getNewValue()));

        KundeTableView.setItems(observableListKunde);
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
}
