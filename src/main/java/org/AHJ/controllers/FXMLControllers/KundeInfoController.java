package org.AHJ.controllers.FXMLControllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.AHJ.controllers.Handlers.ForsikringerTableViewsHandler;
import org.AHJ.modeller.objekter.Kunde;

public class KundeInfoController {

    @FXML
    Tab forsikringTab;
    @FXML
    TabPane forsikringerTabPane;

    Kunde kunde;
    ForsikringerTableViewsHandler handler;

    public KundeInfoController(Kunde kunde) {
        this.kunde = kunde;
    }

    @FXML
    public void initialize(){

        handler = new ForsikringerTableViewsHandler(kunde, forsikringTab, forsikringerTabPane);

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
