package org.AHJ.modeller.vinduer;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modeller.forsikringer.Baatforsikring;
import org.AHJ.modeller.forsikringer.Forsikring;
import org.AHJ.modeller.forsikringer.Reiseforsikring;
import org.AHJ.modeller.objekter.Kunde;


import java.util.zip.DataFormatException;

public class BaatforsikringDialog {

    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innEier, innRegistreringsnummer, innTypeOgModell,
            innLengde, innAarsmodell, innMotorTypeOgStyrke;

    private Baatforsikring batforsikring;
    private Kunde kunde;
    private InnskrevetDataValiderer innDataValiderer;

    public BaatforsikringDialog(){
    }

    @FXML
    public void initialize(){
        this.innDataValiderer = new InnskrevetDataValiderer();
    }

    @FXML
    private void leggTilForsikring()  {
        try {
            validerBaatforsikringData();
            kunde.getForsikringer().add(new Baatforsikring(Double.parseDouble(innForsikringsPremie.getText()),
                    Double.parseDouble(innForsikringsbelop.getText()), innForsikringsbetingelser.getText(),
                    innEier.getText(),innRegistreringsnummer.getText(), innTypeOgModell.getText(),
                    innLengde.getText(),innAarsmodell.getText(), innMotorTypeOgStyrke.getText()));
            System.out.println("forsikringlagt til kunde! Antall forsikringer: "+kunde.getFornavn()+" "+kunde.getForsikringer().size());
        } catch (DataFormatException dfe) {
            visFeilmelding(dfe.getMessage());
        }
    }

    private void visFeilmelding(String feilMelding) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Feil");
        alert.setContentText(feilMelding);
        alert.showAndWait();
    }

    private void validerBaatforsikringData() throws NullPointerException, DataFormatException{
        innDataValiderer.validerInt(innForsikringsPremie.getText(),innForsikringsPremie.getPromptText());
        innDataValiderer.validerInt(innForsikringsbelop.getText(),innForsikringsbelop.getPromptText());
        innDataValiderer.validerTekstMedTall(innForsikringsbetingelser.getText(),innForsikringsbetingelser.getPromptText());
        innDataValiderer.validerNavn(innEier.getText(),innEier.getPromptText());
        innDataValiderer.validerTekstMedTall(innRegistreringsnummer.getText(),innRegistreringsnummer.getPromptText());
        innDataValiderer.validerTekstMedTall(innTypeOgModell.getText(),innTypeOgModell.getPromptText());
        innDataValiderer.validerInt(innLengde.getText(),innLengde.getPromptText());
        innDataValiderer.validerInt(innAarsmodell.getText(),innAarsmodell.getPromptText());
        innDataValiderer.validerTekstMedTall(innMotorTypeOgStyrke.getText(), innMotorTypeOgStyrke.getPromptText());
    }

    public void setKunde(Kunde kunde){
        this.kunde = kunde;
    }
}
