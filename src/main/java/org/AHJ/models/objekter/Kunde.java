package org.AHJ.models.objekter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.AHJ.models.skjermaer.Skademelding;
import org.AHJ.models.forsikringer.Forsikring;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Kunde extends Person implements Serializable {

    private Calendar calendar;
    private StringProperty fakturaadresse;
    private IntegerProperty forsikringsnummer;
    private IntegerProperty ubetalte_erstatninger; //TODO usikker på type, må granskes.
    List<Forsikring> forsikringer;
    List<Skademelding> skademeldinger;

    public Kunde(String fornavn,
                 String etternavn,
                 String fakturaadresse,
                 Integer forsikringsnummer,
                 Integer ubetalte_erstatninger) {
        super(fornavn, etternavn);
        this.fakturaadresse = new SimpleStringProperty(fakturaadresse);
        this.forsikringsnummer = new SimpleIntegerProperty(forsikringsnummer);
        this.ubetalte_erstatninger = new SimpleIntegerProperty(ubetalte_erstatninger);
        forsikringer = new ArrayList<Forsikring>();
        skademeldinger = new ArrayList<Skademelding>();
        calendar = Calendar.getInstance();
    }

    public void addForsikring(Forsikring forsikring){
        forsikringer.add(forsikring);
    }
    public void addSkademelding(Skademelding skademelding){
        skademeldinger.add(skademelding);
    }

    public Calendar getCalendar() {
        return calendar;
    }
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(fakturaadresse).append(";");
        sb.append(forsikringsnummer).append(";");
        sb.append(ubetalte_erstatninger).append(";");
        for (Forsikring f : forsikringer) sb.append(f.toString());
        for (Skademelding s : skademeldinger) sb.append(s.toString());
        return sb.toString();
    }

    public String getFakturaadresse() {
        return fakturaadresse.get();
    }

    public StringProperty fakturaadresseProperty() {
        return fakturaadresse;
    }

    public void setFakturaadresse(String fakturaadresse) {
        this.fakturaadresse.set(fakturaadresse);
    }

    public int getForsikringsnummer() {
        return forsikringsnummer.get();
    }

    public IntegerProperty forsikringsnummerProperty() {
        return forsikringsnummer;
    }

    public void setForsikringsnummer(int forsikringsnummer) {
        this.forsikringsnummer.set(forsikringsnummer);
    }

    public int getUbetalte_erstatninger() {
        return ubetalte_erstatninger.get();
    }

    public IntegerProperty ubetalte_erstatningerProperty() {
        return ubetalte_erstatninger;
    }

    public void setUbetalte_erstatninger(int ubetalte_erstatninger) {
        this.ubetalte_erstatninger.set(ubetalte_erstatninger);
    }
}
