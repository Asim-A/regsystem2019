package org.AHJ.modeller.objekter.tableviewmodeller;

import javafx.util.StringConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateStringConverter extends StringConverter<LocalDate> {

    @Override
    public String toString(LocalDate localDate) {
        return localDate.toString();
    }

    @Override
    public LocalDate fromString(String date) {
        return fromLocalDateToString(date);
    }

    public static LocalDate fromLocalDateToString(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  LocalDate.ofInstant(date1.toInstant(), ZoneId.systemDefault());
    }
}
