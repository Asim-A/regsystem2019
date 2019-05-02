package org.AHJ.controllers.FXMLControllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.controllers.FXMLControllers.ForsikringDialog;
import org.AHJ.modeller.forsikringer.Reiseforsikring;

import java.util.zip.DataFormatException;

public class ReiseforsikringDialogController extends ForsikringDialog {

    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innForsikringsOmråde, innForsikringsSum;

    public ReiseforsikringDialogController(){

    }

    @FXML
    public void initialize(){
        this.dataValiderer = new InnskrevetDataValiderer();
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
