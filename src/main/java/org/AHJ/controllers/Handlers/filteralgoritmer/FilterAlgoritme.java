package org.AHJ.controllers.Handlers.filteralgoritmer;

import org.AHJ.modeller.objekter.Kunde;

public interface FilterAlgoritme {

    boolean filtrer(Kunde kunde, String lowerCaseFilter);

}
