package org.AHJ.models.objekter;

import org.AHJ.models.skjermaer.Skademelding;
import org.AHJ.models.forsikringer.Forsikring;

import java.util.Calendar;
import java.util.List;

public class Kunde {

    private Calendar calendar;
    private String navn;
    private String fakturaadresse;
    private String forsikringsnummer;
    private List<Forsikring> forsikringer;
    private List<Skademelding> meldinger;
    private String ubetalte_erstatninger; //TODO usikker på type, må granskes.

    public Kunde(){
        calendar = Calendar.getInstance();
    }


    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
