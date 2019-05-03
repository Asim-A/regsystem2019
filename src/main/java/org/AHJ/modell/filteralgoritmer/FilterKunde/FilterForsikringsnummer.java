package org.AHJ.modell.filteralgoritmer.FilterKunde;

import org.AHJ.modell.objekter.Kunde;

public class FilterForsikringsnummer implements FilterTekstFelt {
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        return (Integer.toString(kunde.getForsikringsnummer())).contains(lowerCaseFilter);
    }
}
