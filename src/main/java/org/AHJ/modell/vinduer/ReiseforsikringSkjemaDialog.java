package org.AHJ.modell.vinduer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.AHJ.kontroll.FXMLControllers.BoligforsikringSkjemaController;
import org.AHJ.kontroll.FXMLControllers.ReiseforsikringSkjemaController;
import org.AHJ.modell.objekter.Kunde;

import java.io.IOException;

public class ReiseforsikringSkjemaDialog extends Dialog{

    private Stage stage;
    private Kunde kunde;

    public ReiseforsikringSkjemaDialog(Kunde kunde) {
        super();
        this.stage = super.stage;
        this.kunde = kunde;
        stage.setTitle("Reiseforsikring");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/Reiseforsikring.fxml"));
        Parent root = null;
        try {
            ReiseforsikringSkjemaController controller = new ReiseforsikringSkjemaController(kunde);
            loader.setController(controller);
            root = loader.load();
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
