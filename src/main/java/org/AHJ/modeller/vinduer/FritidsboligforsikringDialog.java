package org.AHJ.modeller.vinduer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.AHJ.modeller.objekter.Kunde;

import java.io.IOException;

public class FritidsboligforsikringDialog {

    Kunde kunde;



    public FritidsboligforsikringDialog(Kunde kunde){
        this.kunde = kunde;
        Stage stage = new Stage();
        stage.setTitle("Fritidsboligforsikring");
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
