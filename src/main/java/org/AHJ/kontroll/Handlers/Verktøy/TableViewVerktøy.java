package org.AHJ.kontroll.Handlers.Verktøy;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.AHJ.modell.forsikringer.Forsikring;
import org.AHJ.modell.objekter.Kunde;

import java.util.List;

public class TableViewVerktøy {

    public static Object hentMarkertObjekt(TableView<?> view){
        if(view.getSelectionModel().getSelectedItem() != null)
            return view.getSelectionModel().getSelectedItem();
        return null;
    }

    public static List<?> hentMarkertListe(TableView<?> view){
        if(view.getSelectionModel().getSelectedItems() != null)
            return view.getSelectionModel().getSelectedItems();
        return null;
    }

    public static void slettMerketRad(TableView<?> view, ObservableList<?> observableList){
        if(view.getSelectionModel().getSelectedItem() != null)
            observableList.remove(view.getSelectionModel().getSelectedItem());
    }

    public static void slettMerkedeRader(TableView<?> view, ObservableList<?> observableList){
        if(view.getSelectionModel().getSelectedItems() != null)
            observableList.removeAll(view.getSelectionModel().getSelectedItems());
    }

    public static void slettAlleRader(TableView<?> view, ObservableList observableList){
        if(view != null && observableList != null) observableList.clear();
    }

}
