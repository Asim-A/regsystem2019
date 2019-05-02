package org.AHJ.controllers.Handlers.Verktøy;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class TableViewVerktøy {

    public static void slettRader(TableView<?> view, ObservableList<?> observableList){
        if(view.getSelectionModel().getSelectedItems() != null)
            observableList.removeAll(view.getSelectionModel().getSelectedItems());
    }

}
