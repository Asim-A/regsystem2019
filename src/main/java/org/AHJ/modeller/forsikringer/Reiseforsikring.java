package org.AHJ.modeller.forsikringer;

import java.lang.reflect.Field;

public class Reiseforsikring extends Forsikring {



    private String forsikringsOmråde;
    private Double forsikringsSum;

    public Reiseforsikring(double forsikringspremie, double forsikringsbeløp,
                           String forsikringsbetingelser, String forsikringsOmråde,
                           Double forsikringsSum) {
        super(forsikringspremie, forsikringsbeløp, forsikringsbetingelser);
        this.forsikringsOmråde = forsikringsOmråde;
        this.forsikringsSum = forsikringsSum;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName()+";");
        sb.append(super.toString());
        Field[] fields = getClass().getDeclaredFields();
        for (Field f : fields) {
            try {
                sb.append(f.get(this)).append(";");
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        sb.append("*");
        return sb.toString();
    }

    public String getForsikringsOmråde() {
        return forsikringsOmråde;
    }

    public void setForsikringsOmråde(String forsikringsOmråde) {
        this.forsikringsOmråde = forsikringsOmråde;
    }

    public Double getForsikringsSum() {
        return forsikringsSum;
    }

    public void setForsikringsSum(Double forsikringsSum) {
        this.forsikringsSum = forsikringsSum;
    }
}
