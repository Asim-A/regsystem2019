package org.AHJ.models.objekter;

import org.AHJ.models.skjermaer.Skademelding;
import org.AHJ.models.forsikringer.Forsikring;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Kunde extends Person implements Serializable {

    private Calendar calendar;
    private String fakturaadresse;
    private int forsikringsnummer;
    private int ubetalte_erstatninger; //TODO usikker på type, må granskes.
    List<Forsikring> forsikringer;
    List<Skademelding> skademeldinger;

    public Kunde(String fornavn,
                 String etternavn,
                 String fakturaadresse,
                 int forsikringsnummer,
                 int ubetalte_erstatninger) {
        super(fornavn, etternavn);
        this.fakturaadresse = fakturaadresse;
        this.forsikringsnummer = forsikringsnummer;
        this.ubetalte_erstatninger = ubetalte_erstatninger;
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

    public String getFormatedDate(){
        Date date = calendar.getTime();
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
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
        sb.append(fakturaadresse);
        sb.append(forsikringsnummer);
        sb.append(ubetalte_erstatninger);
        sb.append(getFormatedDate());
        for (Forsikring f : forsikringer) sb.append(f.toString());
        for (Skademelding s : skademeldinger) sb.append(s.toString());
        return sb.toString();
    }
}
