package org.AHJ.kontroll.Handlers;


import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.AHJ.modell.FilterKunde.*;
import org.AHJ.modell.objekter.Kunde;
import org.AHJ.kontroll.Handlers.Verktøy.LocalDateStringConverter;
import org.AHJ.modell.vinduer.KundeInfoDialog;
import java.time.LocalDate;
import java.util.List;

public class KundeOversiktTableViewHandler {

    private TextField filtrertTekst;

    private TableView<Kunde> KundeTableView;

    private TableColumn<Kunde, LocalDate> DatoKolonne;
    private TableColumn<Kunde, String> FornavnKolonne;
    private TableColumn<Kunde, String> EtternavnKolonne;
    private TableColumn<Kunde, Integer> ForsikringsnummerKolonne;
    private TableColumn<Kunde, String> FakturaadresseKolonne;
    private TableColumn<Kunde, Integer> UbetalteErstattningerKolonne;

    private ObservableList<Kunde> observableListKunde = FXCollections.observableArrayList();

    public KundeOversiktTableViewHandler(
            TableView<Kunde> kundeTableView,
            TableColumn<Kunde, LocalDate> datoColumn,
            TableColumn<Kunde, String> fornavnColumn,
            TableColumn<Kunde, String> etternavnColumn,
            TableColumn<Kunde, Integer> forsikringsnummerColumn,
            TableColumn<Kunde, String> fakturaadresseColumn,
            TableColumn<Kunde, Integer> ubetalteErstattningerColumn,
            TextField filtrertTekst)
    {
        KundeTableView = kundeTableView;
        DatoKolonne = datoColumn;
        FornavnKolonne = fornavnColumn;
        EtternavnKolonne = etternavnColumn;
        ForsikringsnummerKolonne = forsikringsnummerColumn;
        FakturaadresseKolonne = fakturaadresseColumn;
        UbetalteErstattningerKolonne = ubetalteErstattningerColumn;
        this.filtrertTekst = filtrertTekst;

        initTable();
    }

    private void initTable(){

        initKundeCeller();

        settKontekstMenyPåRader(KundeTableView);

        FilteredList<Kunde> filterListe = new FilteredList<>(observableListKunde, p -> true);

        filtrertTekst.textProperty().addListener(
                (observable, gammelVerdi, søkeVerdi) -> filterListe.setPredicate(kunde -> {

            if (søkeVerdi == null || søkeVerdi.isEmpty())
                return true;

            String lowerCaseFilter = søkeVerdi.toLowerCase();

            return new FilterGenerell().filtrer(kunde, lowerCaseFilter);
        }));

        SortedList<Kunde> sortertListe = new SortedList<>(filterListe);
        sortertListe.comparatorProperty().bind(KundeTableView.comparatorProperty());

        KundeTableView.setItems(sortertListe);
    }

    private void initKundeCeller(){
        initKundeCelleValueFactory();
        initKundeCellFactory();
        initKundeOnEditCell();
    }

    private void initKundeCelleValueFactory(){
        settCellValueFactory(DatoKolonne, "dato");
        settCellValueFactory(ForsikringsnummerKolonne, "forsikringsnummer");
        settCellValueFactory(FornavnKolonne, "fornavn");
        settCellValueFactory(EtternavnKolonne, "etternavn");
        settCellValueFactory(FakturaadresseKolonne, "fakturaadresse");
        settCellValueFactory(UbetalteErstattningerKolonne, "ubetalte_erstatninger");
    }

    private void initKundeCellFactory(){
        DatoKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
        FornavnKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        EtternavnKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        FakturaadresseKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void initKundeOnEditCell(){
        DatoKolonne.setOnEditCommit(cellEditEvent -> cellEditEvent.getRowValue().setDato(cellEditEvent.getNewValue()));
        FornavnKolonne.setOnEditCommit(cellEditEvent -> cellEditEvent.getRowValue().setFornavn(cellEditEvent.getNewValue()));
        EtternavnKolonne.setOnEditCommit(cellEditEvent -> cellEditEvent.getRowValue().setEtternavn(cellEditEvent.getNewValue()));
        FakturaadresseKolonne.setOnEditCommit(cellEditEvent -> cellEditEvent.getRowValue().setFakturaadresse(cellEditEvent.getNewValue()));
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

    public void tømView(){
        if(observableListKunde != null) observableListKunde.clear();
    }

}
