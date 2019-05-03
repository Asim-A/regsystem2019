package org.AHJ.kontroll.FXMLControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.AHJ.modell.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modell.forsikringer.Baatforsikring;
import org.AHJ.modell.objekter.Kunde;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

public class BaatforsikringSkjemaController extends InnskrivingSkjemaController {

    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innEier, innRegistreringsnummer, innTypeOgModell,
            innLengde, innAarsmodell, innMotorTypeOgStyrke;

    @FXML
    JFXButton leggTil;

    private Kunde kunde;

    public BaatforsikringSkjemaController(){
    }

    public BaatforsikringSkjemaController(Kunde kunde){
        this.kunde = kunde;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.dataValiderer = new InnskrevetDataValiderer();
        leggTil.setOnAction(e->leggTilForsikring());
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
        System.out.println("HAHAH");
        innForsikringsPremie.setText(dataValiderer.validerDouble(innForsikringsPremie.getText(),
                innForsikringsPremie.getPromptText()));
        System.out.println(innForsikringsPremie);
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
