package org.AHJ.kontroll.Handlers.Verktøy;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.time.LocalDate;

public class TableColumnVerktøy {

    public static void handleLocalDateKolonnerEdit(TableColumn<?, ?>... kolonner){
        for(TableColumn<? , ?> localDateTemp :  kolonner){
            TableColumn<?, LocalDate> localDateKolonne = (TableColumn<?, LocalDate>) localDateTemp;
            localDateKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
        }
    }

    public static void handleLocalDateKolonneEdit(TableColumn<?, ?> kolonne){
        TableColumn<?, LocalDate> localDateKolonne = (TableColumn<?, LocalDate>) kolonne;
        localDateKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
    }

    public static void handleDoubleKolonnerEdit(TableColumn<?, ?>... kolonner){
        for(TableColumn<?, ?> doubleTemp : kolonner){
            TableColumn<?, Double> doubleKolonne = (TableColumn<?, Double>) doubleTemp;
            doubleKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        }
    }

    public static void handleDoubleKolonneEdit(TableColumn<?, ?> kolonne){
        TableColumn<?, Double> doubleKolonne = (TableColumn<?, Double>) kolonne;
        doubleKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    }

    public static void handleIntegerKolonnerEdit(TableColumn<?, ?>... kolonner){
        for(TableColumn<?, ?> integerTemp : kolonner){
            TableColumn<?, Integer> integerKolonne = (TableColumn<?, Integer>) integerTemp;
            integerKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        }
    }

    public static void handleIntegerKolonneEdit(TableColumn<?, ?> kolonne){
        TableColumn<?, Integer> integerKolonne = (TableColumn<?, Integer>) kolonne;
        integerKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }

    public static void handleStringKolonnerEdit(TableColumn<?, ?>... kolonner){
        for(TableColumn<?, ?> stringTemp : kolonner){
            TableColumn<?, String> stringKolonne = (TableColumn<?, String>) stringTemp;
            stringKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        }
    }

    public static void handleStringKolonneEdit(TableColumn<?, ?> kolonne){
        TableColumn<?, String> stringKolonne = (TableColumn<?, String>) kolonne;
        stringKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
    }


}
