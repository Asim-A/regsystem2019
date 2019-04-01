package org.AHJ;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class RegSys extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/MainView.fxml"));
        loader.setLocation(getClass().getResource("org/kordamp/bootstrapfx/bootstrapfx.css"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("AHJ");
        stage.show();
    }

}
