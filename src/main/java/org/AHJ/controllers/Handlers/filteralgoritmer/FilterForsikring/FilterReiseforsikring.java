package org.AHJ.controllers.Handlers.filteralgoritmer.FilterForsikring;

import org.AHJ.modeller.forsikringer.Forsikring;
import org.AHJ.modeller.forsikringer.Reiseforsikring;
import org.AHJ.modeller.objekter.Kunde;

import java.util.List;

public class FilterReiseforsikring implements FilterChoiceBox{
    @Override
    public boolean filtrer(Kunde kunde) {
        List<Forsikring> forsikringer = kunde.getForsikringer();
        for(Forsikring forsikring : forsikringer){
            if(forsikring instanceof Reiseforsikring)
                return true;
        }
        return false;
    }
}
