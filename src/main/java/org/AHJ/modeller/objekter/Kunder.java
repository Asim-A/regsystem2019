package org.AHJ.modeller.objekter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Kunder implements Serializable {

    private List<Kunde> kundeListe;

    public Kunder() {
        kundeListe = new ArrayList<>();
    }

    public void addKunde(Kunde kunde){
        kundeListe.add(kunde);
    }

    public List<Kunde> getKundeListe() {
        return kundeListe;
    }

    public void setKundeListe(List<Kunde> kundeListe) {
        this.kundeListe = kundeListe;
    }

    public void tømKunder(){
        if(kundeListe != null)
            kundeListe.clear();
    }

}
