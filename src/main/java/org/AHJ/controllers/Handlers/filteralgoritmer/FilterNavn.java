package org.AHJ.controllers.Handlers.filteralgoritmer;

import org.AHJ.modeller.objekter.Kunde;

public class FilterNavn implements FilterAlgoritme{

    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        if (kunde.getFornavn().toLowerCase().contains(lowerCaseFilter)) return true;
        else return kunde.getEtternavn().toLowerCase().contains(lowerCaseFilter);
    }
}
