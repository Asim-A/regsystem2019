package org.AHJ.controllers.Handlers.filteralgoritmer.FilterKunde;

import org.AHJ.modeller.objekter.Kunde;

public class FilterForsikringsnummer implements FilterTekstFelt {
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        return (Integer.toString(kunde.getForsikringsnummer())).contains(lowerCaseFilter);
    }
}
