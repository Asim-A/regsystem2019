package org.AHJ.kontroll.FXMLControllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import org.AHJ.kontroll.Handlers.ForsikringerTableViewsHandler;
import org.AHJ.kontroll.Handlers.SkademeldingTableViewHandler;
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


    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
