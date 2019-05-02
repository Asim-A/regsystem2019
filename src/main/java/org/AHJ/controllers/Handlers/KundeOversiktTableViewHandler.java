package org.AHJ.controllers.Handlers;


import com.jfoenix.controls.JFXCheckBox;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.AHJ.controllers.Handlers.filteralgoritmer.FilterKunde.*;
import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.controllers.Handlers.TableViewVerktøy.LocalDateStringConverter;
import org.AHJ.modeller.vinduer.KundeInfoDialog;
import java.time.LocalDate;
import java.util.List;

public class KundeOversiktTableViewHandler {

    private TextField filtrertTekst;

    private TableView<Kunde> KundeTableView;

    private TableColumn<Kunde, LocalDate> DatoColumn;
    private TableColumn<Kunde, String> FornavnColumn;
    private TableColumn<Kunde, String> EtternavnColumn;
    private TableColumn<Kunde, Integer> ForsikringsnummerColumn;
    private TableColumn<Kunde, String> FakturaadresseColumn;

    private ObservableList<Kunde> observableListKunde = FXCollections.observableArrayList();

    public KundeOversiktTableViewHandler(
            TableView<Kunde> kundeTableView,
            TableColumn<Kunde, LocalDate> datoColumn,
            TableColumn<Kunde, String> fornavnColumn,
            TableColumn<Kunde, String> etternavnColumn,
            TableColumn<Kunde, Integer> forsikringsnummerColumn,
            TableColumn<Kunde, String> fakturaadresseColumn,
            TextField filtrertTekst)
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

        settCellValueFactory(DatoColumn, "dato");
        settCellValueFactory(ForsikringsnummerColumn, "forsikringsnummer");
        settCellValueFactory(FornavnColumn, "fornavn");
        settCellValueFactory(EtternavnColumn, "etternavn");
        settCellValueFactory(FakturaadresseColumn, "fakturaadresse");

        DatoColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
        FornavnColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        EtternavnColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        FakturaadresseColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        DatoColumn.setOnEditCommit(cellEditEvent -> cellEditEvent.getRowValue().setDato(cellEditEvent.getNewValue()));
        FornavnColumn.setOnEditCommit(cellEditEvent -> cellEditEvent.getRowValue().setFornavn(cellEditEvent.getNewValue()));
        EtternavnColumn.setOnEditCommit(cellEditEvent -> cellEditEvent.getRowValue().setEtternavn(cellEditEvent.getNewValue()));
        FakturaadresseColumn.setOnEditCommit(cellEditEvent -> cellEditEvent.getRowValue().setFakturaadresse(cellEditEvent.getNewValue()));


        settKontekstMenyPåRader(KundeTableView);

        FilteredList<Kunde> filterListe = new FilteredList<>(observableListKunde, p -> true);
        filtrertTekst.textProperty().addListener(
                (observable, gammelVerdi, søkeVerdi) -> filterListe.setPredicate(kunde -> {

            if (søkeVerdi == null || søkeVerdi.isEmpty()) return true;

            String lowerCaseFilter = søkeVerdi.toLowerCase();



            return new FilterGenerell().filtrer(kunde, lowerCaseFilter);


        }));

        SortedList<Kunde> sortertListe = new SortedList<>(filterListe);
        sortertListe.comparatorProperty().bind(KundeTableView.comparatorProperty());

        KundeTableView.setItems(sortertListe);
    }

    private <S,T> void settCellValueFactory(TableColumn<S,T> kolonne, String egenskap){
        kolonne.setCellValueFactory(new PropertyValueFactory<>(egenskap));
    }

    private void settKontekstMenyPåRader(TableView<Kunde> tabell){
        tabell.setRowFactory(kundeTableView -> {

            final TableRow<Kunde> rad = new TableRow<>();
            final ContextMenu radMeny = new ContextMenu();
            MenuItem visMer = new MenuItem("Vis mer");
            visMer.setOnAction(e -> {
                new KundeInfoDialog(rad.getItem());
            });

            radMeny.getItems().addAll(visMer);

            rad.contextMenuProperty().bind(
                    Bindings.when(Bindings.isNotNull(rad.itemProperty()))
                            .then(radMeny)
                            .otherwise((ContextMenu)null));
            return rad;
        });

    }

    public void addObservableKunde(Kunde kunde) {
        observableListKunde.add(kunde);
    }

    public void addAllObserableKunde(List<Kunde> kunder){
        observableListKunde.addAll(kunder);
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
