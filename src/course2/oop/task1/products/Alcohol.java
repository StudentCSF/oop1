package course2.oop.task1.products;

import java.util.Date;

public class Alcohol extends BaseProduct {

    public Alcohol(double cost, int expDate, int productionDate, MeasureUnit mu) {
        super(cost, expDate, productionDate, mu);
    }

    public Alcohol() {
        super();
    }

    @Override
    public String toString() {
        return "Алкоголь";
    }
}
