package org.AHJ.controllers.FXMLControllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.AHJ.modeller.objekter.Kunde;

public class KundeInfoController {

    @FXML
    Tab forsikringTab;
    @FXML
    TabPane forsikringerTabpane;

    Kunde kunde;

    public KundeInfoController(Kunde kunde) {
        this.kunde = kunde;
    }

    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void initialize(){
        Tab båtForsikring = new Tab("Båtforsikring");
        Tab boligForsikring = new Tab("Boligforsikring");

        System.out.println(kunde);

        forsikringerTabpane.getTabs().addAll(båtForsikring, boligForsikring);
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
