package org.AHJ.modeller.forsikringer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Baatforsikring extends Forsikring{

    private String eier;
    private String registreringsnummer;
    private String båttypeogModell;
    private String lengde_i_fot;
    private String årsmodell;
    private String motortype_og_motorstyrke;

    //TODO Oppdater denne modellen
    public Baatforsikring(double forsikringspremie,
                          double forsikringsbeløp,
                          String forsikringsbetingelser,
                          String eier,
                          String registreringsnummer,
                          String båttypeogModell,
                          String lengde_i_fot,
                          String årsmodell,
                          String motortype_og_motorstyrke
    ) {
        super(forsikringspremie, forsikringsbeløp, forsikringsbetingelser);
        this.eier =eier;
        this.registreringsnummer = registreringsnummer;
        this.båttypeogModell = båttypeogModell;
        this.lengde_i_fot = lengde_i_fot;
        this.årsmodell = årsmodell;
        this. motortype_og_motorstyrke = motortype_og_motorstyrke;
    }

    public Baatforsikring(double forsikringspremie,
                          double forsikringsbeløp,
                          String forsikringsbetingelser,
                          LocalDate dato,
                          String eier,
                          String registreringsnummer,
                          String båttypeogModell,
                          String lengde_i_fot,
                          String årsmodell,
                          String motortype_og_motorstyrke
    ) {
        super(forsikringspremie, forsikringsbeløp, forsikringsbetingelser, dato);
        this.eier = eier;
        this.registreringsnummer = registreringsnummer;
        this.båttypeogModell = båttypeogModell;
        this.lengde_i_fot = lengde_i_fot;
        this.årsmodell = årsmodell;
        this. motortype_og_motorstyrke = motortype_og_motorstyrke;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName()+";");
        sb.append(super.toString());
        sb.append(eier).append(";");
        sb.append(registreringsnummer).append(";");
        sb.append(båttypeogModell).append(";");
        sb.append(lengde_i_fot).append(";");
        sb.append(årsmodell).append(";");
        sb.append(motortype_og_motorstyrke).append("*");
        return sb.toString();
    }

    public String getEier() {
        return eier;
    }

    public void setEier(String eier) {
        this.eier.set(eier);
    }

    public String getRegistreringsnummer() {
        return registreringsnummer.get();
    }

    public StringProperty registreringsnummerProperty() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer.set(registreringsnummer);
    }
}
