package org.AHJ.controllers.Handlers.filteralgoritmer.FilterForsikring;

import org.AHJ.modeller.forsikringer.Forsikring;
import org.AHJ.modeller.forsikringer.Hus_og_innboforsikring;
import org.AHJ.modeller.objekter.Kunde;

import java.util.List;

public class FilterHOIForsikring implements FilterChoiceBox{

    @Override
    public boolean filtrer(Kunde kunde) {
        List<Forsikring> forsikringer = kunde.getForsikringer();
        for(Forsikring forsikring : forsikringer){
            if(forsikring instanceof Hus_og_innboforsikring)
                return true;
        }
        return false;
    }
}
