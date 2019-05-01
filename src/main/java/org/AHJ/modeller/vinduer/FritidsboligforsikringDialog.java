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
import org.AHJ.modeller.forsikringer.Fritidsboligforsikring;
import org.AHJ.modeller.objekter.Kunde;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class FritidsboligforsikringDialog {



    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innAdresse,innbyggeÅr, innboligtype, innbyggemateriale, innstandard,
            innkvadratmeter, innforsikringsbeløp_for_bygning, innforsikringsbeløp_for_innbo;

    private Baatforsikring batforsikring;
    private Kunde kunde;
    private InnskrevetDataValiderer innDataValiderer;

    public FritidsboligforsikringDialog(){

    }

    @FXML
    public void initialize(){
        this.innDataValiderer = new InnskrevetDataValiderer();
    }

    @FXML
    private void leggTilForsikring()  {
        try {
            innDataValiderer.toString();
            validerInntastetData();
            kunde.getForsikringer().add(new Fritidsboligforsikring(Double.parseDouble(innForsikringsPremie.getText()),
                    Double.parseDouble(innForsikringsbelop.getText()), innForsikringsbetingelser.getText(),
                    innAdresse.getText(),Integer.valueOf(innbyggeÅr.getText()), innboligtype.getText(),
                    innbyggemateriale.getText(),innstandard.getText(),Double.valueOf(innkvadratmeter.getText()),
                    Double.valueOf(innforsikringsbeløp_for_bygning.getText()), Double.valueOf(innforsikringsbeløp_for_innbo.getText())));
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

    private void validerInntastetData() throws NullPointerException, DataFormatException{
        innDataValiderer.validerInt(innForsikringsPremie.getText(),innForsikringsPremie.getPromptText());
        innDataValiderer.validerInt(innForsikringsbelop.getText(),innForsikringsbelop.getPromptText());
        innDataValiderer.validerTekstMedTall(innForsikringsbetingelser.getText(),innForsikringsbetingelser.getPromptText());
        innDataValiderer.validerTekstMedTall(innAdresse.getText(),innAdresse.getPromptText());
        innDataValiderer.validerTekstMedTall(innbyggeÅr.getText(),innbyggeÅr.getPromptText());
        innDataValiderer.validerTekstMedTall(innboligtype.getText(),innboligtype.getPromptText());
        innDataValiderer.validerInt(innbyggemateriale.getText(),innbyggemateriale.getPromptText());
        innDataValiderer.validerTekstMedTall(innstandard.getText(),innstandard.getPromptText());
        innDataValiderer.validerInt(innkvadratmeter.getText(),innkvadratmeter.getPromptText());
        innDataValiderer.validerInt(innforsikringsbeløp_for_bygning.getText(),innforsikringsbeløp_for_bygning.getPromptText());
        innDataValiderer.validerInt(innforsikringsbeløp_for_innbo.getText(),innforsikringsbeløp_for_innbo.getPromptText());
    }



    public void setKunde(Kunde kunde){
        this.kunde = kunde;
    }

}
