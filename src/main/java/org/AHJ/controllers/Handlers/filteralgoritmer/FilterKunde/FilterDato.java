package org.AHJ.controllers.Handlers.filteralgoritmer.FilterKunde;

import org.AHJ.modeller.objekter.Kunde;

public class FilterDato implements FilterTekstFelt {
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        return kunde.getDato().toString().toLowerCase().contains(lowerCaseFilter);
    }
}
