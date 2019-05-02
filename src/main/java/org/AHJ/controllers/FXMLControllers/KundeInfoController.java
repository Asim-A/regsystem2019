package org.AHJ.controllers.FXMLControllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import org.AHJ.controllers.Handlers.ForsikringerTableViewsHandler;
import org.AHJ.modeller.forsikringer.*;
import org.AHJ.modeller.objekter.Kunde;
import org.AHJ.modeller.skjema.Skademelding;

public class KundeInfoController {

    @FXML
    Tab forsikringTab;
    @FXML
    TabPane forsikringerTabPane;
    @FXML
    TableView<? extends Forsikring> båtView, fritidsBoligView, hoiView, reiseView;
    @FXML
    TableView<Skademelding> skademeldingView;

    Kunde kunde;
    ForsikringerTableViewsHandler forskringsViewHandler;

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

    }

    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }


    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
