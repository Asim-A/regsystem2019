package org.AHJ.models.forsikringer;

public abstract class Boligforsikring extends Forsikring {

    String addresse; //forskjellig fra fakturaadresse
    int bygge_år;
    String boligtype;
    String byggemateriale;
    String standard; //TODO Hva er standard???
    double kvadratmeter;
    double forsikringsbeløp_for_bygning;
    double forsikringsbeløp_for_innbo;

    public Boligforsikring(
            double forsikringspremie,
            double forsikringsbeløp,
            String forsikringsbetingelser,
            String addresse,
            int bygge_år,
            String boligtype,
            String byggemateriale,
            String standard,
            double kvadratmeter,
            double forsikringsbeløp_for_bygning,
            double forsikringsbeløp_for_innbo)
    {
        super(forsikringspremie, forsikringsbeløp, forsikringsbetingelser);
        this.addresse = addresse;
        this.bygge_år = bygge_år;
        this.boligtype = boligtype;
        this.byggemateriale = byggemateriale;
        this.standard = standard;
        this.kvadratmeter = kvadratmeter;
        this.forsikringsbeløp_for_bygning = forsikringsbeløp_for_bygning;
        this.forsikringsbeløp_for_innbo = forsikringsbeløp_for_innbo;
    }
}
