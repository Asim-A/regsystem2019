package org.AHJ.controllers.Handlers.filteralgoritmer;

import org.AHJ.modeller.objekter.Kunde;

public class FilterDato implements FilterAlgoritme{
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        return kunde.getDato().toString().toLowerCase().contains(lowerCaseFilter);
    }
}
