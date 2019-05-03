package org.AHJ.modell.skjema;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.ZoneId;

public class Skademelding implements Serializable {

    private LocalDate dato;
    private String skadenummer;
    private String type_skade;
    private String beskrivelse_av_skade;
    private String kontaktinfo_vitner;
    private Double takseringsbelop_av_skade;
    private Double utbetalt_erstatningsbelop;

    public Skademelding(LocalDate dato,
                        String skadenummer,
                        String type_skade,
                        String beskrivelse_av_skade,
                        String kontaktinfo_vitner,
                        Double takseringsbelop_av_skade,
                        Double utbetalt_erstatningsbelop
    ) {
        this.dato = dato;
        this.skadenummer = skadenummer;
        this.type_skade = type_skade;
        this.beskrivelse_av_skade = beskrivelse_av_skade;
        this.kontaktinfo_vitner=kontaktinfo_vitner;
        this.takseringsbelop_av_skade = takseringsbelop_av_skade;
        this.utbetalt_erstatningsbelop = utbetalt_erstatningsbelop;
    }

    public Skademelding(String skadenummer,
                        String type_skade,
                        String beskrivelse_av_skade,
                        String kontaktinfo_vitner,
                        Double takseringsbelop_av_skade,
                        Double utbetalt_erstatningsbelop
    ) {
        this.dato =  LocalDate.now(ZoneId.of("GMT+1"));;
        this.skadenummer = skadenummer;
        this.type_skade = type_skade;
        this.beskrivelse_av_skade = beskrivelse_av_skade;
        this.kontaktinfo_vitner = kontaktinfo_vitner;
        this.takseringsbelop_av_skade = takseringsbelop_av_skade;
        this.utbetalt_erstatningsbelop = utbetalt_erstatningsbelop;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName()+";");
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

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getSkadenummer() {
        return skadenummer;
    }

    public void setSkadenummer(String skadenummer) {
        this.skadenummer = skadenummer;
    }

    public String getType_skade() {
        return type_skade;
    }

    public void setType_skade(String type_skade) {
        this.type_skade = type_skade;
    }

    public String getBeskrivelse_av_skade() {
        return beskrivelse_av_skade;
    }

    public void setBeskrivelse_av_skade(String beskrivelse_av_skade) {
        this.beskrivelse_av_skade = beskrivelse_av_skade;
    }
    
    public double getTakseringsbelop_av_skade() {
        return takseringsbelop_av_skade;
    }

    public void setTakseringsbelop_av_skade(double takseringsbelop_av_skade) {
        this.takseringsbelop_av_skade = takseringsbelop_av_skade;
    }

    public double getUtbetalt_erstatningsbelop() {
        return utbetalt_erstatningsbelop;
    }

    public void setUtbetalt_erstatningsbelop(double utbetalt_erstatningsbelop) {
        this.utbetalt_erstatningsbelop = utbetalt_erstatningsbelop;
    }

    public String getKontaktinfo_vitner() {
        return kontaktinfo_vitner;
    }

    public void setKontaktinfo_vitner(String kontaktinfo_vitner) {
        this.kontaktinfo_vitner = kontaktinfo_vitner;
    }
}
