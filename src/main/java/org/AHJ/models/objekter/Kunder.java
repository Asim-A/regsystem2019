package org.AHJ.models.objekter;


import java.io.Serializable;
import java.util.List;

public class Kunder implements Serializable {

    public List<Kunde> getKundeListe() {
        return kundeListe;
    }

    public void setKundeListe(List<Kunde> kundeListe) {
        this.kundeListe = kundeListe;
    }

    private List<Kunde> kundeListe;



}
