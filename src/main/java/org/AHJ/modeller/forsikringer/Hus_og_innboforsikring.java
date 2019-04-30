package org.AHJ.modeller.forsikringer;

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
}
