package org.AHJ.kontroll.FXMLControllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.AHJ.modell.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modell.forsikringer.Reiseforsikring;
import org.AHJ.modell.objekter.Kunde;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

public class ReiseforsikringSkjemaController extends InnskrivingSkjemaController {

    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innForsikringsOmråde, innForsikringsSum;
    @FXML
    Button leggTil;
    private Kunde kunde;

    public ReiseforsikringSkjemaController() {}

    public ReiseforsikringSkjemaController(Kunde kunde){
        this.kunde = kunde;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.dataValiderer = new InnskrevetDataValiderer();
        leggTil.setOnAction(e -> leggTilForsikring());
    }

    @FXML
    private void leggTilForsikring()  {
        try {
            validerBaatforsikringData();
            kunde.getForsikringer().add(new Reiseforsikring(Double.parseDouble(innForsikringsPremie.getText()),
                    Double.parseDouble(innForsikringsbelop.getText()), innForsikringsbetingelser.getText(),
                    innForsikringsOmråde.getText(),Double.parseDouble(innForsikringsSum.getText())));
            System.out.println("forsikringlagt til kunde! Antall forsikringer: "+kunde.getFornavn()+" "+kunde.getForsikringer().size());
            visInfoMelding("Reiseforsikring Registrert På Kunde "+kunde.getFornavn());
        } catch (DataFormatException dfe) {
            visFeilmelding(dfe.getMessage());
        }
    }

    private void validerBaatforsikringData() throws NullPointerException, DataFormatException{
        innForsikringsPremie.setText(dataValiderer.validerDouble(innForsikringsPremie.getText(),
                innForsikringsPremie.getPromptText()));
        innForsikringsbelop.setText(dataValiderer.validerDouble(innForsikringsbelop.getText()
                ,innForsikringsbelop.getPromptText()));
        innForsikringsbetingelser.setText(dataValiderer.validerLangTekst(innForsikringsbetingelser.getText(),
                innForsikringsbetingelser.getPromptText()));
        innForsikringsOmråde.setText(dataValiderer.validerLangTekst(innForsikringsOmråde.getText(),
                innForsikringsOmråde.getPromptText()));
        innForsikringsSum.setText(dataValiderer.validerInt(innForsikringsSum.getText(),
                innForsikringsSum.getPromptText()));
    }
}
