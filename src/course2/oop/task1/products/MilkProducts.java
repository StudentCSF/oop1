package course2.oop.task1.products;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

import java.util.Date;

public class MilkProducts extends BaseProduct {

    public MilkProducts(double cost, int expDate, Date productionDate, MeasureUnit mu) {
        super(cost, expDate, productionDate, mu);
    }
}
