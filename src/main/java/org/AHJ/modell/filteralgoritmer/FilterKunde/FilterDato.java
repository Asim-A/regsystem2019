package org.AHJ.modell.filteralgoritmer.FilterKunde;

import org.AHJ.modell.objekter.Kunde;

public class FilterDato implements FilterTekstFelt {
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        return kunde.getDato().toString().toLowerCase().contains(lowerCaseFilter);
    }
}
