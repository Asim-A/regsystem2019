package org.AHJ.kontroll.FXMLControllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.AHJ.modell.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modell.forsikringer.Fritidsboligforsikring;
import org.AHJ.modell.forsikringer.Hus_og_innboforsikring;

import java.util.zip.DataFormatException;

public class BoligforsikringSkjemaController extends InnskrivingSkjemaController {



    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innAdresse,innbyggeÅr, innboligtype, innbyggemateriale, innstandard,
            innkvadratmeter, innforsikringsbeløp_for_bygning, innforsikringsbeløp_for_innbo;

    @FXML
    private Label overskrift;

    public BoligforsikringSkjemaController(){

    }

<<<<<<< HEAD
    public BoligforsikringSkjemaController(Kunde kunde) {
        this.kunde = kunde;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
=======
    @FXML
    public void initialize(){
>>>>>>> parent of f526bf3... objektorientert dialogbokser men funker ikek 100%
        this.dataValiderer = new InnskrevetDataValiderer();
    }

    @FXML
    private void leggTilForsikring()  {
        try {
            validerFritidsboligforsikring();
<<<<<<< HEAD
            if (overskrift.getText().toLowerCase().contains("fritid")){
=======
            if (overskrift.getText().equals("Fritidsboligforsikring")){
>>>>>>> parent of f526bf3... objektorientert dialogbokser men funker ikek 100%
                kunde.getForsikringer().add(new Fritidsboligforsikring(Double.parseDouble(innForsikringsPremie.getText()),
                        Double.parseDouble(innForsikringsbelop.getText().trim()), innForsikringsbetingelser.getText(),
                        innAdresse.getText(),Integer.valueOf(innbyggeÅr.getText()), innboligtype.getText(),
                        innbyggemateriale.getText(),innstandard.getText(),Double.valueOf(innkvadratmeter.getText()),
                        Double.valueOf(innforsikringsbeløp_for_bygning.getText()), Double.valueOf(innforsikringsbeløp_for_innbo.getText())));
            } else {
                kunde.getForsikringer().add(new Hus_og_innboforsikring(Double.parseDouble(innForsikringsPremie.getText()),
                        Double.parseDouble(innForsikringsbelop.getText()), innForsikringsbetingelser.getText(),
                        innAdresse.getText(), Integer.valueOf(innbyggeÅr.getText()), innboligtype.getText(),
                        innbyggemateriale.getText(), innstandard.getText(), Double.valueOf(innkvadratmeter.getText()),
                        Double.valueOf(innforsikringsbeløp_for_bygning.getText()), Double.valueOf(innforsikringsbeløp_for_innbo.getText())));
            }
            visInfoMelding(overskrift.getText()+" Registrert På Kunde "+kunde.getFornavn());
        } catch (DataFormatException dfe) {
            visFeilmelding(dfe.getMessage());
        }
    }

    private void validerFritidsboligforsikring() throws NullPointerException, DataFormatException{
        innForsikringsPremie.setText(dataValiderer.validerDouble(innForsikringsPremie.getText(),
                innForsikringsPremie.getPromptText()));
        innForsikringsbelop.setText(dataValiderer.validerDouble(innForsikringsbelop.getText(),
                innForsikringsbelop.getPromptText()));
        innForsikringsbetingelser.setText(dataValiderer.validerLangTekst(innForsikringsbetingelser.getText(),
                innForsikringsbetingelser.getPromptText()));
        innAdresse.setText(dataValiderer.validerTekstMedTall(innAdresse.getText(),
                innAdresse.getPromptText()));
        innbyggeÅr.setText(dataValiderer.validerInt(innbyggeÅr.getText(),
                innbyggeÅr.getPromptText()));
        innboligtype.setText(dataValiderer.validerTekstMedTall(innboligtype.getText(),
                innboligtype.getPromptText()));
        innbyggemateriale.setText(dataValiderer.validerTekstMedTall(innbyggemateriale.getText(),
                innbyggemateriale.getPromptText()));
        innstandard.setText(dataValiderer.validerTekstMedTall(innstandard.getText(),
                innstandard.getPromptText()));
        innkvadratmeter.setText(dataValiderer.validerInt(innkvadratmeter.getText(),
                innkvadratmeter.getPromptText()));
        innforsikringsbeløp_for_bygning.setText(dataValiderer.validerInt(innforsikringsbeløp_for_bygning.getText(),
                innforsikringsbeløp_for_bygning.getPromptText()));
        innforsikringsbeløp_for_innbo.setText(dataValiderer.validerInt(innforsikringsbeløp_for_innbo.getText(),
                innforsikringsbeløp_for_innbo.getPromptText()));
    }

    public void setOverskrift(String overskrift){
        this.overskrift.setText(overskrift);
    }
}
