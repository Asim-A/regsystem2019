package org.AHJ.controllers.FXMLControllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modeller.objekter.Kunde;

public class SkademeldingSkjemaController extends InnskrivingSkjemaController {

    @FXML
    JFXTextField innDato, innSkadenummer, innSkadeType, innBeskrivelse_av_skade,
            innKontaktinfo_vitner,innTakseringsbelop_av_skade,innutbetalt_erstatningsbelop;

    private Kunde kunde;



    public SkademeldingSkjemaController(){
    }

    @FXML
    private void leggTilSkademelding(ActionEvent actionEvent) {

    }

    @FXML
    public void initialize(){
        this.dataValiderer = new InnskrevetDataValiderer();
    }

}
