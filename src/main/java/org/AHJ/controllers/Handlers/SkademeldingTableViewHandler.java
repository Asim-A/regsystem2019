package org.AHJ.controllers.Handlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.AHJ.controllers.Handlers.TableViewVerktøy.TableColumnVerktøy;
import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.objekter.tableviewmodeller.TableViewKolonneModeller;
import org.AHJ.modeller.skjema.Skademelding;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkademeldingTableViewHandler {

    private TableView<Skademelding> skademeldingTableView;
    private List<TableColumn<Skademelding, ?>> skademeldingTableKolonner;
    private Kunde kunde;
    private List<Skademelding> skademeldinger;
    private ObservableList<Skademelding> skademeldingObservableList= FXCollections.observableArrayList();

    public SkademeldingTableViewHandler(TableView<Skademelding> skademeldingTableView, Kunde kunde) {
        this.skademeldingTableView = skademeldingTableView;
        skademeldingTableKolonner = skademeldingTableView.getColumns();
        this.kunde = kunde;
        skademeldinger = kunde.getSkademeldinger();

        initTable();
    }

    public void initTable(){


        skademeldingTableView.setItems(skademeldingObservableList);
    }

    public void initSkademeldingCeller(){
        for(Map.Entry<Integer, String> map : TableViewKolonneModeller.skademeldingKolonner.entrySet()){
            Integer indeks = map.getKey();
            String verdiPåIndeks = map.getValue();

            TableColumn<Skademelding, ?> skademeldingKolonne = skademeldingTableKolonner.get(indeks);
            initCellValueFactory(skademeldingKolonne, verdiPåIndeks);
            initCellFactory(skademeldingKolonne, indeks);
        }
    }

    public void initCellValueFactory(TableColumn<Skademelding, ?> kolonne, String verdi){
        settCellValueFactory(kolonne, verdi);
    }

    public void initCellFactory(TableColumn<Skademelding, ?> kolonne, int indeks){
        if(indeks == 0) TableColumnVerktøy.handleLocalDateKolonneEdit(kolonne);
        else if(indeks > 4) TableColumnVerktøy.handleDoubleKolonneEdit(kolonne);
        else TableColumnVerktøy.handleStringKolonneEdit(kolonne);

        initCommitOnEditEvent(kolonne, indeks);
    }

    public void initCommitOnEditEvent(TableColumn<Skademelding, ?> kolonne, int indeks){
        switch(indeks){
            case 0:
                kolonne.setOnEditCommit(e -> e.getRowValue().setDato((LocalDate)e.getNewValue()));
                break;
            case 1:
                kolonne.setOnEditCommit(e -> e.getRowValue().setSkadenummer((String) e.getNewValue()));
                break;
            case 2:
                kolonne.setOnEditCommit(e -> e.getRowValue().setTypeSkade((String) e.getNewValue()));
                break;
            case 3:
                kolonne.setOnEditCommit(e -> e.getRowValue().setBeskrivelse_av_skade((String) e.getNewValue()));
                break;
            case 4:
                kolonne.setOnEditCommit(e -> e.getRowValue().setKontaktinfo_vitner((String) e.getNewValue()));
                break;
            case 5:
                kolonne.setOnEditCommit(e -> e.getRowValue().setTakseringsbelop_av_skade((Double) e.getNewValue()));
                break;
            case 6:
                kolonne.setOnEditCommit(e -> e.getRowValue().setUtbetalt_erstatningsbelop((Double) e.getNewValue()));
        }
    }

    private <S,T> void settCellValueFactory(TableColumn<S,T> kolonne, String egenskap){
        kolonne.setCellValueFactory(new PropertyValueFactory<>(egenskap));
    }

    private void fyllObservableList(){
        skademeldingObservableList.addAll(skademeldinger);
    }
}
