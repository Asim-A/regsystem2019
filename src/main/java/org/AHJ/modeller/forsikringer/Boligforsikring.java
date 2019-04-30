package org.AHJ.modeller.forsikringer;

import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class Boligforsikring extends Forsikring implements Serializable {

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName()+";");
        sb.append(super.toString());
        sb.append(addresse).append(";");
        sb.append(bygge_år).append(";");
        sb.append(byggemateriale).append(";");
        sb.append(standard).append(";");
        sb.append(kvadratmeter).append(";");
        sb.append(forsikringsbeløp_for_bygning).append("*");
        return sb.toString();
    }

}
