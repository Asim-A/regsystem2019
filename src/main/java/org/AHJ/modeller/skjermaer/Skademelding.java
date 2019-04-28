package org.AHJ.modeller.skjermaer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.time.LocalDate;

public class Skademelding implements Serializable {

    private ObjectProperty<LocalDate> dato;
    private StringProperty skadenummer;
    private StringProperty type_skade;
    private StringProperty beskrivelse_av_skade;
    private DoubleProperty takseringsbeløp_av_skade;
    private DoubleProperty utbetalt_erstatningsbeløp;

    public Skademelding(ObjectProperty<LocalDate> dato,
                        StringProperty skadenummer,
                        StringProperty type_skade,
                        StringProperty beskrivelse_av_skade,
                        DoubleProperty takseringsbeløp_av_skade,
                        DoubleProperty utbetalt_erstatningsbeløp
    ) {
        this.dato = dato;
        this.skadenummer = skadenummer;
        this.type_skade = type_skade;
        this.beskrivelse_av_skade = beskrivelse_av_skade;
        this.takseringsbeløp_av_skade = takseringsbeløp_av_skade;
        this.utbetalt_erstatningsbeløp = utbetalt_erstatningsbeløp;
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

    public String getSkadenummer() {
        return skadenummer.get();
    }

    public StringProperty skadenummerProperty() {
        return skadenummer;
    }

    public void setSkadenummer(String skadenummer) {
        this.skadenummer.set(skadenummer);
    }

    public String getType_skade() {
        return type_skade.get();
    }

    public StringProperty type_skadeProperty() {
        return type_skade;
    }

    public void setType_skade(String type_skade) {
        this.type_skade.set(type_skade);
    }

    public String getBeskrivelse_av_skade() {
        return beskrivelse_av_skade.get();
    }

    public StringProperty beskrivelse_av_skadeProperty() {
        return beskrivelse_av_skade;
    }

    public void setBeskrivelse_av_skade(String beskrivelse_av_skade) {
        this.beskrivelse_av_skade.set(beskrivelse_av_skade);
    }

    public double getTakseringsbeløp_av_skade() {
        return takseringsbeløp_av_skade.get();
    }

    public DoubleProperty takseringsbeløp_av_skadeProperty() {
        return takseringsbeløp_av_skade;
    }

    public void setTakseringsbeløp_av_skade(double takseringsbeløp_av_skade) {
        this.takseringsbeløp_av_skade.set(takseringsbeløp_av_skade);
    }

    public double getUtbetalt_erstatningsbeløp() {
        return utbetalt_erstatningsbeløp.get();
    }

    public DoubleProperty utbetalt_erstatningsbeløpProperty() {
        return utbetalt_erstatningsbeløp;
    }

    public void setUtbetalt_erstatningsbeløp(double utbetalt_erstatningsbeløp) {
        this.utbetalt_erstatningsbeløp.set(utbetalt_erstatningsbeløp);
    }
}
