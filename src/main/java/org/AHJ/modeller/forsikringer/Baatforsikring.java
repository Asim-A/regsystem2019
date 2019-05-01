package org.AHJ.modeller.forsikringer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.lang.reflect.Field;
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
        this.motortype_og_motorstyrke = motortype_og_motorstyrke;
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
        Field[] fields = getClass().getDeclaredFields();
        for (Field f : fields) {
            try {
                sb.append(f.get(this)).append(";");
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        sb.append("*");
        return sb.toString();
    }
    public String getEier() {
        return eier;
    }

    public void setEier(String eier) {
        this.eier = eier;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public String getBåttypeogModell() {
        return båttypeogModell;
    }

    public void setBåttypeogModell(String båttypeogModell) {
        this.båttypeogModell = båttypeogModell;
    }

    public String getLengde_i_fot() {
        return lengde_i_fot;
    }

    public void setLengde_i_fot(String lengde_i_fot) {
        this.lengde_i_fot = lengde_i_fot;
    }

    public String getÅrsmodell() {
        return årsmodell;
    }

    public void setÅrsmodell(String årsmodell) {
        this.årsmodell = årsmodell;
    }

    public String getMotortype_og_motorstyrke() {
        return motortype_og_motorstyrke;
    }

    public void setMotortype_og_motorstyrke(String motortype_og_motorstyrke) {
        this.motortype_og_motorstyrke = motortype_og_motorstyrke;
    }
}
