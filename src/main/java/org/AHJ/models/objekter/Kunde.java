package org.AHJ.models.objekter;

<<<<<<< HEAD
import com.opencsv.bean.CsvBindByPosition;
=======
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
>>>>>>> cc1ce9b... Fikset tableview, tablecolumn og property, lagt til observablelist og laget handler for tableview
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
<<<<<<< HEAD
    public String fakturaadresse;
    private int forsikringsnummer;
    private int ubetalte_erstatninger; //TODO usikker på type, må granskes.
=======
    private StringProperty fakturaadresse;
    private IntegerProperty forsikringsnummer;
    private IntegerProperty ubetalte_erstatninger; //TODO usikker på type, må granskes.
>>>>>>> cc1ce9b... Fikset tableview, tablecolumn og property, lagt til observablelist og laget handler for tableview
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
