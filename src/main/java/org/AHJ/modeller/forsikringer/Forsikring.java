package org.AHJ.modeller.forsikringer;

import javafx.beans.property.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;

public abstract class Forsikring implements Serializable {

        private Double forsikringspremie;
        private Double forsikringsbeløp;
        private String forsikringsbetingelser;
        private LocalDate dato;

        public Forsikring(double forsikringspremie, double forsikringsbeløp, String forsikringsbetingelser) {
                this.forsikringspremie = forsikringspremie;
                this.forsikringsbeløp = forsikringsbeløp;
                this.forsikringsbetingelser = forsikringsbetingelser;
                this.dato = LocalDate.now(ZoneId.of("GMT+1"));
        }

        public Forsikring(double forsikringspremie, double forsikringsbeløp, String forsikringsbetingelser, LocalDate dato) {
                this.forsikringspremie = forsikringspremie;
                this.forsikringsbeløp = forsikringsbeløp;
                this.forsikringsbetingelser =forsikringsbetingelser;
                this.dato = dato;
        }

        @Override
        public String toString() {
                System.out.println("Metoden toString i Forsikring kjører");
                final StringBuilder sb = new StringBuilder();
                sb.append(forsikringspremie).append(";");
                sb.append(forsikringsbeløp).append(";");
                sb.append(forsikringsbetingelser).append(";");
                sb.append(getDato()).append(";");
        //      System.out.println("sb.toString(): "+sb.toString());
                return sb.toString();
        }

        public double getForsikringspremie() {
                return forsikringspremie;
        }

        public void setForsikringspremie(double forsikringspremie) {
                this.forsikringspremie=forsikringspremie;
        }

        public double getForsikringsbeløp() {
                return forsikringsbeløp;
        }

        public void setForsikringsbeløp(double forsikringsbeløp) {
                this.forsikringsbeløp = forsikringsbeløp;
        }

        public String getForsikringsbetingelser() {
                return forsikringsbetingelser;
        }

        public void setForsikringsbetingelser(String forsikringsbetingelser) {
                this.forsikringsbetingelser = forsikringsbetingelser;
        }

        public LocalDate getDato() {
                return dato;
        }

        public void setDato(LocalDate dato) {
                this.dato=dato;
        }
}
