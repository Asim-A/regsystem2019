package org.AHJ.modeller.vinduer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.AHJ.modeller.forsikringer.Baatforsikring;
import org.AHJ.modeller.objekter.Kunde;


import java.io.IOException;

public class BaatforsikringDialog {


    private Baatforsikring batforsikring;
    private Kunde kunde;

    public BaatforsikringDialog(){}

    public BaatforsikringDialog(Kunde kunde){
        this.kunde = kunde;
        Stage stage = new Stage();
        stage.setTitle("Baatforsikring");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("views/Baatforsikring.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getStylesheets().add("views/test.css");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
