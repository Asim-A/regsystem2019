package org.AHJ.controllers.Handlers.filteralgoritmer.FilterKunde;

import org.AHJ.modeller.objekter.Kunde;

public interface FilterTekstFelt {

    boolean filtrer(Kunde kunde, String lowerCaseFilter);

}
