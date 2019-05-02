package org.AHJ.controllers.FXMLControllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modeller.forsikringer.Baatforsikring;


import java.util.zip.DataFormatException;

public class BaatforsikringSkjemaController extends InnskrivingSkjemaController {

    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innEier, innRegistreringsnummer, innTypeOgModell,
            innLengde, innAarsmodell, innMotorTypeOgStyrke;

    public BaatforsikringSkjemaController(){
    }

    @FXML
    public void initialize(){
        this.dataValiderer = new InnskrevetDataValiderer();
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
            visInfoMelding("Båtforsikring Registrert På Kunde "+kunde.getFornavn());
        } catch (DataFormatException dfe) {
            visFeilmelding(dfe.getMessage());
        }
    }

    private void validerBaatforsikringData() throws NullPointerException, DataFormatException{
        innForsikringsPremie.setText(dataValiderer.validerDouble(innForsikringsPremie.getText(),
                innForsikringsPremie.getPromptText()));
        innForsikringsbelop.setText(dataValiderer.validerDouble(innForsikringsbelop.getText(),
                innForsikringsbelop.getPromptText()));
        innForsikringsbetingelser.setText(dataValiderer.validerLangTekst(innForsikringsbetingelser.getText(),
                innForsikringsbetingelser.getPromptText()));
        innEier.setText(dataValiderer.validerNavn(innEier.getText(),
                innEier.getPromptText()));
        innRegistreringsnummer.setText(dataValiderer.validerTekstMedTall(innRegistreringsnummer.getText(),
                innRegistreringsnummer.getPromptText()));
        innTypeOgModell.setText(dataValiderer.validerTekstMedTall(innTypeOgModell.getText(),
                innTypeOgModell.getPromptText()));
        innLengde.setText(dataValiderer.validerInt(innLengde.getText(),
                innLengde.getPromptText()));
        innAarsmodell.setText(dataValiderer.validerInt(innAarsmodell.getText(),
                innAarsmodell.getPromptText()));
        innMotorTypeOgStyrke.setText(dataValiderer.validerTekstMedTall(innMotorTypeOgStyrke.getText(),
                innMotorTypeOgStyrke.getPromptText()));
    }

}
