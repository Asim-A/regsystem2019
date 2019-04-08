package org.AHJ.models.objekter;

import org.AHJ.models.skjermaer.Skademelding;
import org.AHJ.models.forsikringer.Forsikring;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Kunde extends Person implements Serializable {

    private Calendar calendar;
    private String fakturaadresse;
    private int forsikringsnummer;
    private List<Forsikring> forsikringer;
    private List<Skademelding> skademeldinger;
    private int ubetalte_erstatninger; //TODO usikker på type, må granskes.
    private String forsikringsnummer;
    protected List<Forsikring> forsikringer;
    protected List<Skademelding> skademeldinger;
    private String ubetalte_erstatninger; //TODO usikker på type, må granskes.

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

    public Calendar getCalendar() {
        return calendar;
    }
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String toString(){
       return fornavn+";"+etternavn+";"+fakturaadresse+";"+forsikringsnummer+";"+ubetalte_erstatninger+";";

    }
}
