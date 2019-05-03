package org.AHJ.modell.vinduer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.AHJ.kontroll.FXMLControllers.BaatforsikringSkjemaController;
import org.AHJ.modell.forsikringer.Forsikring;
import org.AHJ.modell.objekter.Kunde;

import java.io.IOException;

public class BaatforsikringSkjemaDialog extends Dialog{

    private Kunde kunde;
    Stage stage;

    public BaatforsikringSkjemaDialog(Kunde kunde) {
        super();
        this.stage = super.stage;
        this.kunde = kunde;
        stage.setTitle("Båtskjema");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/Baatforsikring.fxml"));
        Parent root = null;
        try {
            BaatforsikringSkjemaController controller = new BaatforsikringSkjemaController(kunde);
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
