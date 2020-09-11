package org.AHJ.modell.vinduer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.AHJ.kontroll.FXMLControllers.ReiseforsikringSkjemaController;
import org.AHJ.kontroll.FXMLControllers.SkademeldingSkjemaController;
import org.AHJ.modell.objekter.Kunde;

import java.io.IOException;

public class SkademeldingSkjemaDialog extends Dialog{

    private Stage stage;
    private Kunde kunde;

    public SkademeldingSkjemaDialog(Kunde kunde) {
        super();
        this.stage = super.stage;
        this.kunde = kunde;
        stage.setTitle("Registrer skademelding på kunde: " + kunde.getForsikringsnummer());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/Skademelding.fxml"));
        Parent root = null;
        try {
            SkademeldingSkjemaController controller = new SkademeldingSkjemaController(kunde);
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
