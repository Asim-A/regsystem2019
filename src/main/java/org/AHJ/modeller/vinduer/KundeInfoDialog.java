package org.AHJ.modeller.vinduer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.AHJ.controllers.FXMLControllers.KundeInfoController;
import org.AHJ.modeller.objekter.Kunde;

import java.io.IOException;

public class KundeInfoDialog {

    private Kunde kunde;

    public KundeInfoDialog(){}

    public KundeInfoDialog(Kunde kunde){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Kunde: " + kunde.getForsikringsnummer());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/KundeInfoScene.fxml"));
        Parent root = null;
        try {
            KundeInfoController kic = new KundeInfoController(kunde);
            loader.setController(kic);
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto");
        root.getStylesheets().add("/views/test.css");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }


    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
