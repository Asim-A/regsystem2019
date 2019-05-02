package org.AHJ.modeller.vinduer;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modeller.forsikringer.Baatforsikring;
import org.AHJ.modeller.objekter.Kunde;


import java.util.zip.DataFormatException;

public class BaatforsikringDialogController extends ForsikringDialog {

    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innEier, innRegistreringsnummer, innTypeOgModell,
            innLengde, innAarsmodell, innMotorTypeOgStyrke;

    public BaatforsikringDialogController(){
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
            System.out.println("baatforsikring lagt til kunde! Antall forsikringer: "+kunde.getFornavn()+" "+kunde.getForsikringer().size());
            visInfoMelding("Båtforsikring Registrert På Kunde");
        } catch (DataFormatException dfe) {
            visFeilmelding(dfe.getMessage());
        }
    }

    private void validerBaatforsikringData() throws NullPointerException, DataFormatException{
        innDataValiderer.validerInt(innForsikringsPremie.getText(),innForsikringsPremie.getPromptText());
        innDataValiderer.validerInt(innForsikringsbelop.getText(),innForsikringsbelop.getPromptText());
        innDataValiderer.validerLangTekst(innForsikringsbetingelser.getText(),innForsikringsbetingelser.getPromptText());
        innDataValiderer.validerNavn(innEier.getText(),innEier.getPromptText());
        innDataValiderer.validerTekstMedTall(innRegistreringsnummer.getText(),innRegistreringsnummer.getPromptText());
        innDataValiderer.validerTekstMedTall(innTypeOgModell.getText(),innTypeOgModell.getPromptText());
        innDataValiderer.validerInt(innLengde.getText(),innLengde.getPromptText());
        innDataValiderer.validerInt(innAarsmodell.getText(),innAarsmodell.getPromptText());
        innDataValiderer.validerTekstMedTall(innMotorTypeOgStyrke.getText(), innMotorTypeOgStyrke.getPromptText());
    }

}
