package org.AHJ.modeller.vinduer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.AHJ.modeller.objekter.Kunde;

import java.io.IOException;

public class KundeDialog {

    @FXML
    Tab forsikringTab;

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
        BorderPane bp = new BorderPane();

        TabPane tp = new TabPane();
        Tab tab1 = new Tab("Båt");
        Tab tab2 = new Tab("Bolig");

        tp.getTabs().addAll(tab1, tab2);
        bp.setBottom(tp);

        forsikringTab.setContent(bp);
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
