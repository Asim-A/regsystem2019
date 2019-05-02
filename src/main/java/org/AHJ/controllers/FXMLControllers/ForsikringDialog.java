package org.AHJ.controllers.FXMLControllers;

import javafx.scene.control.Alert;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modeller.forsikringer.Baatforsikring;
import org.AHJ.modeller.objekter.Kunde;

public class ForsikringDialog {

    Kunde kunde;
    InnskrevetDataValiderer dataValiderer;

    void visFeilmelding(String feilMelding) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Feil");
        alert.setHeaderText("Ugyldig data");
        alert.setContentText(feilMelding);
        alert.showAndWait();
    }

    void visInfoMelding(String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMASJON");
        alert.setHeaderText("Informasjon");
        alert.setContentText(info);
        alert.showAndWait();
    }

    public void setKunde(Kunde kunde){
        this.kunde = kunde;
    }

}
