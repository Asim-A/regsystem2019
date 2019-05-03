package org.AHJ.kontroll.FXMLControllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import org.AHJ.kontroll.Handlers.ForsikringerTableViewsHandler;
import org.AHJ.kontroll.Handlers.SkademeldingTableViewHandler;
import org.AHJ.kontroll.Handlers.Verktøy.TableViewVerktøy;
import org.AHJ.modell.forsikringer.*;
import org.AHJ.modell.objekter.Kunde;
import org.AHJ.modell.skjema.Skademelding;



public class KundeInfoController {

    @FXML
    TableView<? extends Forsikring> båtView, fritidsBoligView, hoiView, reiseView;
    @FXML
    TableView<Skademelding> skademeldingView;

    Kunde kunde;
    ForsikringerTableViewsHandler forskringsViewHandler;
    SkademeldingTableViewHandler skademeldingTableViewHandler;

    public KundeInfoController(Kunde kunde) {
        this.kunde = kunde;
    }

    @FXML
    public void initialize(){

        forskringsViewHandler = new ForsikringerTableViewsHandler(
                kunde,
                (TableView<Baatforsikring>) båtView,
                (TableView<Fritidsboligforsikring>)fritidsBoligView,
                (TableView<Hus_og_innboforsikring>)hoiView,
                (TableView<Reiseforsikring>)reiseView);
        skademeldingTableViewHandler = new SkademeldingTableViewHandler(skademeldingView, kunde);

    }

    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void slettRad(ActionEvent event){
        String id = ((Button) event.getSource()).getId().toLowerCase();
        if(id.contains("båt"))
            TableViewVerktøy.slettMerketRad(
                    båtView,
                    forskringsViewHandler.getBåtForsikringerObservableList()
            );
        else if(id.contains("fritid"))
            TableViewVerktøy.slettMerketRad(
                    fritidsBoligView,
                    forskringsViewHandler.getFritidsboligforsikringerObservableList()
            );
        else if(id.contains("hoi"))
            TableViewVerktøy.slettMerketRad(
                    hoiView,
                    forskringsViewHandler.getHoiForsikringerObservableList()
            );
        else if(id.contains("reise"))
            TableViewVerktøy.slettMerketRad(
                    reiseView,
                    forskringsViewHandler.getReiseforsikringerObservableListforsikringObservableList()
            );
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
