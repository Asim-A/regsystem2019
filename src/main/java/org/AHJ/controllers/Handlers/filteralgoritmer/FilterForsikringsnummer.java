package org.AHJ.controllers.Handlers.filteralgoritmer;

import org.AHJ.modeller.objekter.Kunde;

public class FilterForsikringsnummer implements FilterAlgoritme{
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        return (Integer.toString(kunde.getForsikringsnummer())).contains(lowerCaseFilter);
    }
}
