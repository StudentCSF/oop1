package course2.oop.task1.products;

import java.util.Date;

public class MilkProducts extends BaseProduct {

    public MilkProducts(double cost, int expDate, int productionDate, MeasureUnit mu) {
        super(cost, expDate, productionDate, mu);
    }

    public MilkProducts() {
        super();
    }

    @Override
    public String toString() {
        return "Молочные продукты";
    }
}
