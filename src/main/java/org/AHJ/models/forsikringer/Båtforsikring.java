package org.AHJ.models.forsikringer;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class Båtforsikring extends Forsikring{

    private StringProperty eier;
    private StringProperty registreringsnummer;
    private StringProperty båttypeogModell;
    private StringProperty lengde_i_fot;
    private StringProperty årsmodell;
    private StringProperty motortype_og_motorstyrke;


    //TODO Oppdater denne modellen
    public Båtforsikring(double forsikringspremie,
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
        this.eier = new SimpleStringProperty(eier);
        this.registreringsnummer = new SimpleStringProperty(registreringsnummer);
        this.båttypeogModell = new SimpleStringProperty(båttypeogModell);
        this.lengde_i_fot = new SimpleStringProperty(lengde_i_fot);
        this.årsmodell = new SimpleStringProperty(årsmodell);
        this. motortype_og_motorstyrke = new SimpleStringProperty(motortype_og_motorstyrke);
    }

    public Båtforsikring(double forsikringspremie,
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
        this.eier = new SimpleStringProperty(eier);
        this.registreringsnummer = new SimpleStringProperty(registreringsnummer);
        this.båttypeogModell = new SimpleStringProperty(båttypeogModell);
        this.lengde_i_fot = new SimpleStringProperty(lengde_i_fot);
        this.årsmodell = new SimpleStringProperty(årsmodell);
        this. motortype_og_motorstyrke = new SimpleStringProperty(motortype_og_motorstyrke);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName()+";");
        sb.append(super.toString());
        sb.append(eier.get()).append(";");
        sb.append(registreringsnummer.get()).append(";");
        sb.append(båttypeogModell.get()).append(";");
        sb.append(lengde_i_fot.get()).append(";");
        sb.append(årsmodell.get()).append(";");
        sb.append(motortype_og_motorstyrke.get()).append("*");
        return sb.toString();
    }

    public String getEier() {
        return eier.get();
    }

    public StringProperty eierProperty() {
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
