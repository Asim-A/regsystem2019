package org.AHJ.controllers.FXMLControllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modeller.objekter.Kunde;

public class SkademeldingDialogController {

    InnskrevetDataValiderer dataValiderer;

    @FXML
    JFXTextField innDato, innSkadenummer, innSkadeType, innBeskrivelse_av_skade,
            innKontaktinfo_vitner,innTakseringsbelop_av_skade,innutbetalt_erstatningsbelop;

    private Kunde kunde;



    public SkademeldingDialogController(){
    }

    @FXML
    private void leggTilSkademelding(ActionEvent actionEvent) {

    }

    @FXML
    public void initialize(){
        this.dataValiderer = new InnskrevetDataValiderer();
    }

    public void setKunde(Kunde kunde){
        this.kunde = kunde;
    }
}
