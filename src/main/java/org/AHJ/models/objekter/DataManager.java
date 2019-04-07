package org.AHJ.models.objekter;

import org.AHJ.models.forsikringer.Forsikring;
import org.AHJ.models.skjermaer.Skademelding;

import java.util.HashMap;
import java.util.List;

public class DataManager {



    private  List<Kunde> kundeListe;
    private HashMap<Forsikring,Kunde> forsikringer;
    private HashMap<Skademelding,Kunde> skademeldinger;

    public List<Kunde> getKundeListe() {
        return kundeListe;
    }

    public void setKundeListe(List<Kunde> kundeListe) {
        DataManager.kundeListe = kundeListe;
    }



}
