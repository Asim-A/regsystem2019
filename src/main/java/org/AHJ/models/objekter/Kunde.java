package org.AHJ.models.objekter;

import com.opencsv.bean.CsvBindByPosition;
import javafx.beans.property.*;
import org.AHJ.models.skjermaer.Skademelding;
import org.AHJ.models.forsikringer.Forsikring;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Kunde extends Person implements Serializable {


    private LocalDate localDate;
    private ObjectProperty<LocalDate> dato;
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
        localDate = LocalDate.now(ZoneId.of("GMT+1"));
        this.dato = new SimpleObjectProperty<>(this, "dato", localDate);
        forsikringer = new ArrayList<Forsikring>();
        skademeldinger = new ArrayList<Skademelding>();
    }

    public void addForsikring(Forsikring forsikring){
        forsikringer.add(forsikring);
    }
    public void addSkademelding(Skademelding skademelding){
        skademeldinger.add(skademelding);
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

    public void printDate(){
        System.out.println(localDate);
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

    public LocalDate getDato() {
        return dato.get();
    }

    public ObjectProperty<LocalDate> datoProperty() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato.set(dato);
    }
}
