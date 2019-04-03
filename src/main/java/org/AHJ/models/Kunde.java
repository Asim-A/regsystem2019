package org.AHJ.models;

import org.AHJ.models.forsikringer.Forsikring;

import java.util.Calendar;
import java.util.List;

public class Kunde {

    private String navn;
    private Calendar calendar;
    private List<Skademelding> meldinger;
    private List<Forsikring> forsikringer;


}
