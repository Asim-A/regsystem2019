package org.AHJ.controllers.Handlers.TableViewVerktøy;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.AHJ.modeller.objekter.tableviewmodeller.LocalDateStringConverter;

import java.time.LocalDate;

public class TableColumnVerktøy {

    public static void handleLocalDateColumnEdit(TableColumn<?, ?>... kolonner){
        for(TableColumn<? , ?> localDateTemp :  kolonner){
            TableColumn<?, LocalDate> localDateKolonne = (TableColumn<?, LocalDate>) localDateTemp;
            localDateKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
        }
    }

    public static void handleDoubleColumnEdit(TableColumn<?, ?>... kolonner){
        for(TableColumn<?, ?> doubleTemp : kolonner){
            TableColumn<?, Double> doubleKolonne = (TableColumn<?, Double>) doubleTemp;
            doubleKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        }
    }

    public static void handleIntegerColumnEdit(TableColumn<?, ?>... kolonner){
        for(TableColumn<?, ?> integerTemp : kolonner){
            TableColumn<?, Integer> integerKolonne = (TableColumn<?, Integer>) integerTemp;
            integerKolonne.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        }
    }

    public static void handleStringColumnEdit(TableColumn<?, ?>... kolonner){
        for(TableColumn<?, ?> stringTemp : kolonner){
            TableColumn<?, String> stringKolonne = (TableColumn<?, String>) stringTemp;
            stringKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        }
    }


}
