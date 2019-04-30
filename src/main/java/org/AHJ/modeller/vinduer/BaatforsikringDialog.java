package org.AHJ.modeller.vinduer;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.AHJ.controllers.DataValidering.InnskrevetDataValiderer;
import org.AHJ.modeller.forsikringer.Baatforsikring;
import org.AHJ.modeller.objekter.Kunde;


import javax.swing.*;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class BaatforsikringDialog {

    @FXML
    JFXTextField innForsikringsPremie, innForsikringsbelop, innForsikringsbetingelser,
            innEier, innRegistreringsnummer, innTypeOgModell,
            innLengde, innAarsmodell, innMotorTypeOgStryke;

    private Baatforsikring batforsikring;
    private Kunde kunde;
    private InnskrevetDataValiderer innskrevetDataValiderer;

    public BaatforsikringDialog(){
    }

    @FXML
    public void initialize(){
        this.innskrevetDataValiderer = new InnskrevetDataValiderer();
    }

    @FXML
    public void leggTilForsikring()  {
        try {
            innskrevetDataValiderer.toString();
            validerBaatforsikringData();
            kunde.getForsikringer().add(new Baatforsikring(Double.parseDouble(innForsikringsPremie.getText()),
                    Double.parseDouble(innForsikringsbelop.getText()), innForsikringsbetingelser.getText(),
                    innEier.getText(),innRegistreringsnummer.getText(), innTypeOgModell.getText(),
                    innLengde.getText(),innAarsmodell.getText(),innMotorTypeOgStryke.getText()));
            System.out.println("forsikringlagt til kunde! Antall forsikringer: "+kunde.getFornavn()+" "+kunde.getForsikringer().size());
        } catch (DataFormatException dfe) {
            visFeilmelding(dfe.getMessage());
        }
    }

    private void visFeilmelding(String feilMelding) {
        JOptionPane.showMessageDialog(null, feilMelding, "Alert", JOptionPane.ERROR_MESSAGE);
    }

    private void validerBaatforsikringData() throws NullPointerException, DataFormatException{
        innskrevetDataValiderer.validerInt(innForsikringsPremie.getText(),innForsikringsPremie.getPromptText());
        innskrevetDataValiderer.validerInt(innForsikringsbelop.getText(),innForsikringsbelop.getPromptText());
        innskrevetDataValiderer.validerTekstMedTall(innForsikringsbetingelser.getText(),innForsikringsbetingelser.getPromptText());
        innskrevetDataValiderer.validerNavn(innEier.getText(),innEier.getPromptText());
        innskrevetDataValiderer.validerTekstMedTall(innRegistreringsnummer.getText(),innRegistreringsnummer.getPromptText());
        innskrevetDataValiderer.validerTekstMedTall(innTypeOgModell.getText(),innTypeOgModell.getPromptText());
        innskrevetDataValiderer.validerInt(innLengde.getText(),innLengde.getPromptText());
        innskrevetDataValiderer.validerInt(innAarsmodell.getText(),innAarsmodell.getPromptText());
        innskrevetDataValiderer.validerTekstMedTall(innMotorTypeOgStryke.getText(),innMotorTypeOgStryke.getPromptText());
    }

    public void setKunde(Kunde kunde){
        this.kunde = kunde;
        System.out.println("kunde satt"+kunde.getFornavn());
    }

}
