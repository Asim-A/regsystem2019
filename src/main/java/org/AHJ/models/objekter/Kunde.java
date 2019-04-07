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
    private String forsikringsnummer;
    protected List<Forsikring> forsikringer;
    protected List<Skademelding> skademeldinger;
    private String ubetalte_erstatninger; //TODO usikker på type, må granskes.

    public Kunde(String fornavn, String etternavn, String fakturaadresse, String forsikringsnummer) {
        super(fornavn, etternavn);
        this.fakturaadresse = fakturaadresse;
        this.forsikringsnummer = forsikringsnummer;
        calendar = Calendar.getInstance();
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
