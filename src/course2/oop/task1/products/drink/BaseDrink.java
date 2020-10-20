package course2.oop.task1.products.drink;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

public abstract class BaseDrink extends BaseProduct {
    protected static final MeasureUnit mu = MeasureUnit.liters;

    public BaseDrink(double cost, int expDate, int productionDate) {
        super(cost, expDate, productionDate, mu);
    }

    public BaseDrink() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Алкоголь";
    }
}
