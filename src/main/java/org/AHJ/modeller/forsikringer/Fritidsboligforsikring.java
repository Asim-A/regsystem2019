package org.AHJ.modeller.forsikringer;

import java.time.LocalDate;

public class Fritidsboligforsikring extends Boligforsikring {


    public Fritidsboligforsikring(
        Double forsikringspremie,
        Double forsikringsbeløp,
        String forsikringsbetingelser,
        LocalDate dato,
        String addresse, Integer bygge_år,
        String boligtype, String byggemateriale,
        String standard, Double kvadratmeter,
        Double forsikringsbeløp_for_bygning,
        Double forsikringsbeløp_for_innbo)
    {
        super(
        forsikringspremie,
        forsikringsbeløp,
        forsikringsbetingelser,
        dato,
        addresse,
        bygge_år,
        boligtype,
        byggemateriale,
        standard,
        kvadratmeter,
        forsikringsbeløp_for_bygning,
        forsikringsbeløp_for_innbo);
    }

    public Fritidsboligforsikring(
            Double forsikringspremie,
            Double forsikringsbeløp,
            String forsikringsbetingelser,
            String addresse, Integer bygge_år,
            String boligtype, String byggemateriale,
            String standard, Double kvadratmeter,
            Double forsikringsbeløp_for_bygning,
            Double forsikringsbeløp_for_innbo)
    {
        super(
                forsikringspremie,
                forsikringsbeløp,
                forsikringsbetingelser,
                addresse,
                bygge_år,
                boligtype,
                byggemateriale,
                standard,
                kvadratmeter,
                forsikringsbeløp_for_bygning,
                forsikringsbeløp_for_innbo);
    }
}
