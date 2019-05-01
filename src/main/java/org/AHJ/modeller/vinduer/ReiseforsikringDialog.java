package org.AHJ.modeller.vinduer;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modeller.forsikringer.Baatforsikring;
import org.AHJ.modeller.forsikringer.Reiseforsikring;
import org.AHJ.modeller.objekter.Kunde;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class ReiseforsikringDialog {

    private Kunde kunde;
    private InnskrevetDataValiderer innDataValiderer;

    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innForsikringsOmråde, innForsikringsSum;

    public ReiseforsikringDialog(){

    }

    @FXML
    public void initialize(){
        this.innDataValiderer = new InnskrevetDataValiderer();
    }

    @FXML
    private void leggTilForsikring()  {
        try {
            validerBaatforsikringData();
            kunde.getForsikringer().add(new Reiseforsikring(Double.parseDouble(innForsikringsPremie.getText()),
                    Double.parseDouble(innForsikringsbelop.getText()), innForsikringsbetingelser.getText(),
                    innForsikringsOmråde.getText(),Double.parseDouble(innForsikringsSum.getText())));
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
        innDataValiderer.validerTekstMedTall(innForsikringsOmråde.getText(),innForsikringsOmråde.getPromptText());
        innDataValiderer.validerInt(innForsikringsSum.getText(),innForsikringsSum.getPromptText());
    }

    public void setKunde(Kunde kunde){
        this.kunde = kunde;
    }
}
