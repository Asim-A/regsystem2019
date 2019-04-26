package org.AHJ.models.forsikringer;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public abstract class Forsikring {

        private DoubleProperty forsikringspremie;
        private DoubleProperty forsikringsbeløp;
        private StringProperty forsikringsbetingelser;
        private ObjectProperty<LocalDate> dato;

        public Forsikring(double forsikringspremie, double forsikringsbeløp, String forsikringsbetingelser) {
                this.forsikringspremie = new SimpleDoubleProperty(forsikringspremie);
                this.forsikringsbeløp = new SimpleDoubleProperty(forsikringsbeløp);
                this.forsikringsbetingelser = new SimpleStringProperty(forsikringsbetingelser);
                this.dato = new SimpleObjectProperty<>(LocalDate.now(ZoneId.of("GMT+1")));

        }

        @Override
        public String toString() {
                final StringBuilder sb = new StringBuilder("Forsikring");
                sb.append(forsikringspremie);
                sb.append(forsikringsbeløp);
                sb.append(forsikringsbetingelser);
                sb.append(getDato());
                return sb.toString();
        }

        public double getForsikringspremie() {
                return forsikringspremie.get();
        }

        public DoubleProperty forsikringspremieProperty() {
                return forsikringspremie;
        }

        public void setForsikringspremie(double forsikringspremie) {
                this.forsikringspremie.set(forsikringspremie);
        }

        public double getForsikringsbeløp() {
                return forsikringsbeløp.get();
        }

        public DoubleProperty forsikringsbeløpProperty() {
                return forsikringsbeløp;
        }

        public void setForsikringsbeløp(double forsikringsbeløp) {
                this.forsikringsbeløp.set(forsikringsbeløp);
        }

        public String getForsikringsbetingelser() {
                return forsikringsbetingelser.get();
        }

        public StringProperty forsikringsbetingelserProperty() {
                return forsikringsbetingelser;
        }

        public void setForsikringsbetingelser(String forsikringsbetingelser) {
                this.forsikringsbetingelser.set(forsikringsbetingelser);
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
