package org.AHJ.modeller.forsikringer;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Boligforsikring extends Forsikring implements Serializable {


    private String addresse; //forskjellig fra fakturaadresse
    private Integer byggeÅr;
    private String boligtype;
    private String byggemateriale;
    private String standard;
    private Double kvadratmeter;
    private Double forsikringsbeløp_for_bygning;
    private Double forsikringsbeløp_for_innbo;

    public Boligforsikring(
        Double forsikringspremie,
        Double forsikringsbeløp,
        String forsikringsbetingelser,
        LocalDate dato,
        String addresse,
        Integer bygge_år,
        String boligtype,
        String byggemateriale,
        String standard,
        Double kvadratmeter,
        Double forsikringsbeløp_for_bygning,
        Double forsikringsbeløp_for_innbo)
    {
        super(forsikringspremie, forsikringsbeløp, forsikringsbetingelser, dato);
        this.addresse = addresse;
        this.byggeÅr = bygge_år;
        this.boligtype = boligtype;
        this.byggemateriale = byggemateriale;
        this.standard = standard;
        this.kvadratmeter = kvadratmeter;
        this.forsikringsbeløp_for_bygning = forsikringsbeløp_for_bygning;
        this.forsikringsbeløp_for_innbo = forsikringsbeløp_for_innbo;
    }

    public Boligforsikring(
            Double forsikringspremie,
            Double forsikringsbeløp,
            String forsikringsbetingelser,
            String addresse,
            Integer bygge_år,
            String boligtype,
            String byggemateriale,
            String standard,
            Double kvadratmeter,
            Double forsikringsbeløp_for_bygning,
            Double forsikringsbeløp_for_innbo)
    {
        super(forsikringspremie, forsikringsbeløp, forsikringsbetingelser);
        this.addresse = addresse;
        this.byggeÅr = bygge_år;
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
        sb.append(byggeÅr).append(";");
        sb.append(boligtype).append(";");
        sb.append(byggemateriale).append(";");
        sb.append(standard).append(";");
        sb.append(kvadratmeter).append(";");
        sb.append(forsikringsbeløp_for_bygning).append(";");
        sb.append(forsikringsbeløp_for_innbo).append(";").append("*");
        return sb.toString();
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public Integer getByggeÅr() {
        return byggeÅr;
    }

    public void setByggeÅr(Integer byggeÅr) {
        this.byggeÅr = byggeÅr;
    }

    public String getBoligtype() {
        return boligtype;
    }

    public void setBoligtype(String boligtype) {
        this.boligtype = boligtype;
    }

    public String getByggemateriale() {
        return byggemateriale;
    }

    public void setByggemateriale(String byggemateriale) {
        this.byggemateriale = byggemateriale;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Double getKvadratmeter() {
        return kvadratmeter;
    }

    public void setKvadratmeter(Double kvadratmeter) {
        this.kvadratmeter = kvadratmeter;
    }

    public Double getForsikringsbeløp_for_bygning() {
        return forsikringsbeløp_for_bygning;
    }

    public void setForsikringsbeløp_for_bygning(Double forsikringsbeløp_for_bygning) {
        this.forsikringsbeløp_for_bygning = forsikringsbeløp_for_bygning;
    }

    public Double getForsikringsbeløp_for_innbo() {
        return forsikringsbeløp_for_innbo;
    }

    public void setForsikringsbeløp_for_innbo(Double forsikringsbeløp_for_innbo) {
        this.forsikringsbeløp_for_innbo = forsikringsbeløp_for_innbo;
    }

}
