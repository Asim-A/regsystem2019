package org.AHJ.controllers.Handlers.filteralgoritmer.FilterForsikring;

import org.AHJ.modeller.forsikringer.Forsikring;
import org.AHJ.modeller.forsikringer.Fritidsboligforsikring;
import org.AHJ.modeller.objekter.Kunde;

import java.util.List;

public class FilterFritidsboligforsikring implements FilterChoiceBox{
    @Override
    public boolean filtrer(Kunde kunde) {
        List<Forsikring> forsikringer = kunde.getForsikringer();
        for(Forsikring forsikring : forsikringer){
            if(forsikring instanceof Fritidsboligforsikring)
                return true;
        }
        return false;
    }
}
