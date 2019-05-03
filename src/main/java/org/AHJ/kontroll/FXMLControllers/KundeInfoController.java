package org.AHJ.kontroll.FXMLControllers;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import org.AHJ.kontroll.Handlers.ForsikringerTableViewsHandler;
import org.AHJ.kontroll.Handlers.SkademeldingTableViewHandler;
import org.AHJ.kontroll.Handlers.Verktøy.TableViewVerktøy;
import org.AHJ.modell.forsikringer.*;
import org.AHJ.modell.objekter.Kunde;
import org.AHJ.modell.skjema.Skademelding;

import java.net.URL;
import java.util.ResourceBundle;


public class KundeInfoController implements Initializable{

    @FXML
    TableView<? extends Forsikring> båtView, fritidsBoligView, hoiView, reiseView;
    @FXML
    TableView<Skademelding> skademeldingView;
    @FXML
    JFXButton fjernRadBåt, fjernRadFritid, fjernRadHOI, fjernRadReise;

    Kunde kunde;
    ForsikringerTableViewsHandler forskringsViewHandler;
    SkademeldingTableViewHandler skademeldingTableViewHandler;

    public KundeInfoController(Kunde kunde) {
        this.kunde = kunde;
    }


    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void behandleLeggTilForsikring(ActionEvent event){
        String id = hentParentTilKnappPane(event);

        /*if(id.contains("båt"){

        }*/


    }

    public void behandleLeggTilSkademelding(ActionEvent event){

    }

    public void slettRad(ActionEvent event){
        String id = hentKnappId(event);
        if(id.contains("båt")) {
            kunde.getForsikringer().remove(TableViewVerktøy.hentMarkertObjekt(båtView));
            TableViewVerktøy.slettMerketRad(
                    båtView,
                    forskringsViewHandler.getBåtForsikringerObservableList()
            );
        }
        else if(id.contains("fritid")) {
            kunde.getForsikringer().remove(TableViewVerktøy.hentMarkertObjekt(fritidsBoligView));
            TableViewVerktøy.slettMerketRad(
                    fritidsBoligView,
                    forskringsViewHandler.getFritidsboligforsikringerObservableList()
            );
        }
        else if(id.contains("hoi")) {
            kunde.getForsikringer().remove(TableViewVerktøy.hentMarkertObjekt(hoiView));
            TableViewVerktøy.slettMerketRad(
                    hoiView,
                    forskringsViewHandler.getHoiForsikringerObservableList()
            );
        }
        else if(id.contains("reise")) {
            kunde.getForsikringer().remove(TableViewVerktøy.hentMarkertObjekt(reiseView));
            TableViewVerktøy.slettMerketRad(
                    reiseView,
                    forskringsViewHandler.getReiseforsikringerObservableListforsikringObservableList()
            );
        }
    }

    private String hentKnappId(ActionEvent event){
        return ((Button) event.getSource()).getId().toLowerCase();
    }

    private String hentParentTilKnappPane(ActionEvent event){
        return ((Button) event.getSource()).getParent().getId().toLowerCase();
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        forskringsViewHandler = new ForsikringerTableViewsHandler(
                kunde,
                (TableView<Baatforsikring>) båtView,
                (TableView<Fritidsboligforsikring>)fritidsBoligView,
                (TableView<Hus_og_innboforsikring>)hoiView,
                (TableView<Reiseforsikring>)reiseView);
        skademeldingTableViewHandler = new SkademeldingTableViewHandler(skademeldingView, kunde);
        fjernRadBåt.setOnAction(e -> slettRad(e));
        fjernRadFritid.setOnAction(e -> slettRad(e));
        fjernRadHOI.setOnAction(e -> slettRad(e));
        fjernRadReise.setOnAction(e -> slettRad(e));
    }
}
