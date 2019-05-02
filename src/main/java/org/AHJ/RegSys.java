package org.AHJ;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.AHJ.controllers.FXMLControllers.KundeOversiktController;

import java.awt.event.WindowEvent;

public class RegSys extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        /*loader.setLocation(getClass().getResource("/views/TESTING.fxml"));*/
        /*loader.setLocation(getClass().getResource("/views/KundeInfoScene.fxml"));*/
       // loader.setLocation(getClass().getResource("/views/Intro.fxml"));
        /*loader.setLocation(getClass().getResource("/views/KundeOversikt.fxml"));*/
        loader.setLocation(getClass().getResource("/views/KundeOversikt.fxml"));
        Parent root = loader.load();
        KundeOversiktController kd = loader.getController();
        root.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto");
        root.getStylesheets().add("/views/test.css");
        stage.setScene(new Scene(root));
        stage.setTitle("Tiyareed v2");
        stage.setResizable(false);
        stage.setOnCloseRequest(e -> {
            kd.tømRessurser();
            Platform.exit();
            System.exit(0);
        });
        stage.show();
        System.out.println("running");
    }
}
