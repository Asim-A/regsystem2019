package org.AHJ.modell.filteralgoritmer.FilterKunde;

import org.AHJ.modell.objekter.Kunde;

public class FilterGenerell implements FilterTekstFelt {
    @Override
    public boolean filtrer(Kunde kunde, String lowerCaseFilter) {
        FilterDato datoFilter = new FilterDato();
        FilterNavn navnFilter = new FilterNavn();
        FilterAdresse adresseFilter = new FilterAdresse();
        FilterForsikringsnummer forsikringsnummerFilter = new FilterForsikringsnummer();

        return       (datoFilter.filtrer(kunde, lowerCaseFilter)
                   || navnFilter.filtrer(kunde, lowerCaseFilter)
                   || adresseFilter.filtrer(kunde, lowerCaseFilter)
                   || forsikringsnummerFilter.filtrer(kunde, lowerCaseFilter));
    }
}
