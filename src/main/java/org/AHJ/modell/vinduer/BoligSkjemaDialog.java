package org.AHJ.modell.vinduer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.AHJ.kontroll.FXMLControllers.BoligforsikringSkjemaController;
import org.AHJ.modell.objekter.Kunde;

import java.io.IOException;

public class BoligSkjemaDialog extends Dialog{

    public enum Bolig {
        FRITIDS,
        HUSOGINNBO
    }

    private Stage stage;
    private Kunde kunde;

    public BoligSkjemaDialog(Kunde kunde, Bolig bolig) {
        super();
        this.stage = super.stage;
        this.kunde = kunde;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/Boligforsikring.fxml"));
        Parent root = null;
        try {
            BoligforsikringSkjemaController controller = new BoligforsikringSkjemaController(kunde);
            loader.setController(controller);
            root = loader.load();
            if(bolig == Bolig.FRITIDS) {
                String tittel = "Fritidsforsikring";
                controller.setOverskrift(tittel);
                stage.setTitle(tittel);
            }
            else if (bolig == Bolig.HUSOGINNBO) {
                String tittel = "Hus- og innboforsikring";
                controller.setOverskrift(tittel);
                stage.setTitle(tittel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto");
        root.getStylesheets().add("/views/stylesheet.css");
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
