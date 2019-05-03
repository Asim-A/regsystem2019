package org.AHJ.modell.FilterKunde;

import org.AHJ.modell.objekter.Kunde;

public interface FilterTekstFelt {

    boolean filtrer(Kunde kunde, String lowerCaseFilter);

}
