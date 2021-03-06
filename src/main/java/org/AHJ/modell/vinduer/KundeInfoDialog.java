package org.AHJ.modell.vinduer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.AHJ.kontroll.FXMLControllers.KundeInfoController;
import org.AHJ.modell.objekter.Kunde;

import java.io.IOException;

public class KundeInfoDialog extends Dialog{

    private Kunde kunde;
    private Stage stage;

    public KundeInfoDialog(){}

    public KundeInfoDialog(Kunde kunde){
        super();
        this.stage = super.stage;
        this.kunde = kunde;
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
