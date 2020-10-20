package course2.oop.task1.products.milk;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

import java.util.Date;

public abstract class BaseMilkProducts extends BaseProduct {

    public BaseMilkProducts(double cost, int expDate, int productionDate, MeasureUnit mu) {
        super(cost, expDate, productionDate, mu);
    }

    public BaseMilkProducts() {
        super();
    }

    public BaseMilkProducts(MeasureUnit mu) {
        super(mu);
    }

    @Override
    public String toString() {
        return "Молочные продукты";
    }
}
