package org.AHJ.modell.FilterKunde;

import org.AHJ.modell.objekter.Kunde;

public class FilterAdresse implements FilterTekstFelt {
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        return kunde.getFakturaadresse().toLowerCase().contains(lowerCaseFilter);
    }
}
