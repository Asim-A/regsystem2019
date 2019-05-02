package org.AHJ.controllers.Handlers.filteralgoritmer.FilterKunde;

import org.AHJ.modeller.objekter.Kunde;

public class FilterAdresse implements FilterTekstFelt {
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        return kunde.getFakturaadresse().toLowerCase().contains(lowerCaseFilter);
    }
}
