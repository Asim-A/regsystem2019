package org.AHJ.modeller.objekter.tableviewmodeller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TableViewKolonneModeller {

    public final static Map<Integer, String> defaultForsikringKolonner;
    static{
        Map<Integer, String> tempMap = new HashMap<>();
        tempMap.put(0, "dato");
        tempMap.put(1, "forsikringspremie");
        tempMap.put(2, "forsikringsbeløp");
        tempMap.put(3, "forsikringsbetingelser");
        defaultForsikringKolonner = Collections.unmodifiableMap(tempMap);
    }

    public final static Map<Integer, String> båtKolonner;
    static {
        Map<Integer, String> tempMap = new HashMap<>();
        tempMap.put(4, "eier");
        tempMap.put(5, "registreringsnummer");
        tempMap.put(6, "båttypeogModell");
        tempMap.put(7, "lengde_i_fot");
        tempMap.put(8, "årsmodell");
        tempMap.put(9, "motortype_og_motorstyrke");
        båtKolonner = Collections.unmodifiableMap(tempMap);
    }

}
