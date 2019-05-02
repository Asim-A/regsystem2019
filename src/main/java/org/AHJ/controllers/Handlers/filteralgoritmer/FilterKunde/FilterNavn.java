package org.AHJ.controllers.Handlers.filteralgoritmer.FilterKunde;

import org.AHJ.modeller.objekter.Kunde;

public class FilterNavn implements FilterTekstFelt {

    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        if (kunde.getFornavn().toLowerCase().contains(lowerCaseFilter)) return true;
        else return kunde.getEtternavn().toLowerCase().contains(lowerCaseFilter);
    }
}
