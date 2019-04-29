package org.AHJ.modeller.vinduer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.AHJ.modeller.forsikringer.Båtforsikring;
import org.AHJ.modeller.objekter.Kunde;

import java.io.IOException;

public class BatforsikringDialog {


    private Båtforsikring batforsikring;
    private Kunde kunde;

    public BatforsikringDialog(){}

    public BatforsikringDialog(Kunde kunde){
        this.kunde = kunde;
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Båtforsikring: "+kunde.getForsikringsnummer());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/Båtforsikring.fxml"));
        Parent root = null;
        try {
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
}
