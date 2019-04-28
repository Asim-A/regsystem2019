package org.AHJ.controllers.Handlers.filteralgoritmer;

import org.AHJ.modeller.objekter.Kunde;

public class FilterAdresse implements FilterAlgoritme{
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        return kunde.getFakturaadresse().toLowerCase().contains(lowerCaseFilter);
    }
}
