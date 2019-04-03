package org.AHJ.models.forsikringer;

import java.util.Calendar;

public abstract class Forsikring {

        private double forsikringspremie;
        private Calendar calendar;


        public Forsikring(){

                calendar = Calendar.getInstance();

        }


}
