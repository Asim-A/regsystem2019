package org.AHJ.models.forsikringer;

public class Hus_og_Innboforsikring extends Boligforsikring {

    public Hus_og_Innboforsikring(
            double forsikringspremie,
            double forsikringsbeløp,
            String addresse,
            int bygge_år,
            String boligtype,
            String byggemateriale,
            String standard,
            double kvadratmeter,
            double forsikringsbeløp_for_bygning,
            double forsikringsbeløp_for_innbo)
    {
        super(forsikringspremie,
                forsikringsbeløp,
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
