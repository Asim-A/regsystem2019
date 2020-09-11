package org.AHJ.modell.filteralgoritmer.FilterKunde;

import org.AHJ.modell.objekter.Kunde;

public class FilterNavn implements FilterTekstFelt {

    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        if (kunde.getFornavn().toLowerCase().contains(lowerCaseFilter)) return true;
        else return kunde.getEtternavn().toLowerCase().contains(lowerCaseFilter);
    }
}
