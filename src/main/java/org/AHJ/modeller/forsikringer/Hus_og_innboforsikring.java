package org.AHJ.modeller.forsikringer;

import java.time.LocalDate;

public class Hus_og_innboforsikring extends Boligforsikring {

    public Hus_og_innboforsikring(
            double forsikringspremie,
            double forsikringsbeløp,
            String forsikringsbetingelser,
            String addresse, int bygge_år,
            String boligtype, String byggemateriale,
            String standard, double kvadratmeter,
            double forsikringsbeløp_for_bygning,
            double forsikringsbeløp_for_innbo)
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

    public Hus_og_innboforsikring(
        double forsikringspremie,
        double forsikringsbeløp,
        String forsikringsbetingelser,
        LocalDate dato,
        String addresse, int bygge_år,
        String boligtype, String byggemateriale,
        String standard, double kvadratmeter,
        double forsikringsbeløp_for_bygning,
        double forsikringsbeløp_for_innbo)
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
}
