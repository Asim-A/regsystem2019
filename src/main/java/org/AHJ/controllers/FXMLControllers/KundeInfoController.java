package org.AHJ.controllers.FXMLControllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.AHJ.controllers.Handlers.ForsikringerTableViewsHandler;
import org.AHJ.modeller.forsikringer.Forsikring;
import org.AHJ.modeller.objekter.Kunde;

import java.util.ArrayList;
import java.util.List;

public class KundeInfoController {

    @FXML
    Tab forsikringTab;
    @FXML
    TabPane forsikringerTabPane;
    @FXML
    TableView<Forsikring> båtView, fritidsBoligView, hoiView, reiseView;

    Kunde kunde;
    ForsikringerTableViewsHandler handler;

    public KundeInfoController(Kunde kunde) {
        this.kunde = kunde;
    }

    @FXML
    public void initialize(){

        handler = new ForsikringerTableViewsHandler(
                kunde,
                forsikringTab,
                forsikringerTabPane,
                hentKolonner(båtView),
                hentKolonner(fritidsBoligView),
                hentKolonner(hoiView),
                hentKolonner(reiseView));


    }

    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    public List<TableColumn<Forsikring, ?>> hentKolonner(TableView<Forsikring> view){
        List<TableColumn<Forsikring, ?>> kolonneListe = new ArrayList<>();

        for(TableColumn<Forsikring, ?> kolonne : view.getColumns()){
            kolonneListe.add(kolonne);
        }

        return kolonneListe;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
