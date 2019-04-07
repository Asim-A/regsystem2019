package org.AHJ.models.forsikringer;

import java.util.Calendar;

public abstract class Forsikring {

        private double forsikringspremie;
        private double forsikringsbeløp;
        private  Calendar calendar;

        public Forsikring(double forsikringspremie, double forsikringsbeløp) {
                this.forsikringspremie = forsikringspremie;
                this.forsikringsbeløp = forsikringsbeløp;
                calendar.getInstance();
        }

}
