package org.AHJ.models.forsikringer;

import java.util.Calendar;

public abstract class Forsikring {

        private double forsikringspremie;
        private double forsikringsbeløp;
        private String forsikringsbetingelser;
        private  Calendar calendar;

        public Forsikring(double forsikringspremie, double forsikringsbeløp, String forsikringsbetingelser) {
                this.forsikringspremie = forsikringspremie;
                this.forsikringsbeløp = forsikringsbeløp;
                this.forsikringsbetingelser = forsikringsbetingelser;
                calendar = Calendar.getInstance();
        }

        @Override
        public String toString() {
                final StringBuilder sb = new StringBuilder("Forsikring");
                sb.append(";").append(forsikringspremie);
                sb.append(";").append(forsikringsbeløp);
                sb.append(";").append(forsikringsbetingelser);
                sb.append(";").append(calendar.toString());
                sb.append(";");
                return sb.toString();
        }
}
