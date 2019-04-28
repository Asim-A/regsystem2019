package org.AHJ.modeller.objekter;

import java.util.List;

public class DataManager {

    private List<Kunde> kundeListe;
   // private HashMap<Forsikring,Kunde> forsikringer;
   // private HashMap<Skademelding,Kunde> skademeldinger;

    public List<Kunde> getKundeListe() {
        return kundeListe;
    }

    public void setKundeListe(List<Kunde> kundeListe) {
        this.kundeListe = kundeListe;
    }

    /*public String kundeToString(){
        StringBuilder kundeString = new StringBuilder();
        for (int j = 0 ; j< kundeListe.size();j++){
            kundeString.append(kundeListe.get(j));
            for (int i = 0;i<kundeListe.get(j).forsikringer.size();i++){
                kundeString.append(kundeListe.get(j).forsikringer.get(i).toString());
            }
            for (int i = 0;i<kundeListe.get(j).skademeldinger.size();i++){
                kundeString.append(kundeListe.get(j).skademeldinger.get(i).toString());
            }
        }
        return kundeString.toString();
    }*/
}
