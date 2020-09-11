package org.AHJ.modell.vinduer;

import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class Dialog {
    Stage stage;

    public Dialog() {
        this.stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
    }
}
