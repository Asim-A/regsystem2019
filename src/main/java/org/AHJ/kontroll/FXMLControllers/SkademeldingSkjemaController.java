package org.AHJ.kontroll.FXMLControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.AHJ.modell.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modell.objekter.Kunde;
import org.AHJ.modell.skjema.Skademelding;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

public class SkademeldingSkjemaController extends InnskrivingSkjemaController {

    @FXML
    JFXTextField innDato, innSkadenummer, innSkadeType, innBeskrivelse_av_skade,
            innKontaktinfo_vitner,innTakseringsbelop_av_skade,innutbetalt_erstatningsbelop;
    @FXML
    JFXButton leggTil;
    private Kunde kunde;

    public SkademeldingSkjemaController(){
    }

    public SkademeldingSkjemaController(Kunde kunde){
        this.kunde = kunde;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.dataValiderer = new InnskrevetDataValiderer();
        leggTil.setOnAction(e -> leggTilSkademelding());
    }

    @FXML
    private void leggTilSkademelding()  {
        try {
            validerSkademeldingData();
            kunde.getSkademeldinger().add(new Skademelding(
                    innSkadenummer.getText(), innSkadeType.getText(),
                    innBeskrivelse_av_skade.getText(),innKontaktinfo_vitner.getText(),
                    Double.parseDouble(innTakseringsbelop_av_skade.getText()),
                    Double.parseDouble(innutbetalt_erstatningsbelop.getText())));
            System.out.println("baatforsikring lagt til kunde! Antall forsikringer: "+kunde.getFornavn()+" "+kunde.getForsikringer().size());
            visInfoMelding("Båtforsikring Registrert På Kunde "+kunde.getFornavn());
        } catch (DataFormatException dfe) {
            visFeilmelding(dfe.getMessage());
        }
    }

    private void validerSkademeldingData() throws NullPointerException, DataFormatException{
        innSkadenummer.setText(dataValiderer.validerInt(innSkadenummer.getText(),
                innSkadenummer.getPromptText()));
        innSkadeType.setText(dataValiderer.validerNavn(innSkadeType.getText(),
                innSkadeType.getPromptText()));
        innBeskrivelse_av_skade.setText(dataValiderer.validerLangTekst(innBeskrivelse_av_skade.getText(),
                innBeskrivelse_av_skade.getPromptText()));
        innKontaktinfo_vitner.setText(dataValiderer.validerLangTekst(innKontaktinfo_vitner.getText(),
                innKontaktinfo_vitner.getPromptText()));
        innTakseringsbelop_av_skade.setText(dataValiderer.validerInt(innTakseringsbelop_av_skade.getText(),
                innTakseringsbelop_av_skade.getPromptText()));
        innutbetalt_erstatningsbelop.setText(dataValiderer.validerInt(innutbetalt_erstatningsbelop.getText(),
                innutbetalt_erstatningsbelop.getPromptText()));
    }

}
