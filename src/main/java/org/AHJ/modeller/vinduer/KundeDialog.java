package org.AHJ.modeller.vinduer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.AHJ.modeller.objekter.Kunde;

import java.io.IOException;

public class KundeDialog {

    @FXML
    Tab forsikringTab;
    @FXML
    TabPane forsikringerTabpane;

    private Kunde kunde;

    public KundeDialog(){}

    public KundeDialog(Kunde kunde){
        this.kunde = kunde;
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Kunde: " + kunde.getForsikringsnummer());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/KundeInfoScene.fxml"));
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

    @FXML
    public void initialize(){
        Tab båtForsikring = new Tab("Båtforsikring");
        Tab boligFOrsikring = new Tab("Boligforsikring");

        forsikringerTabpane.getTabs().addAll(båtForsikring, boligFOrsikring);
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
