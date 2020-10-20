package course2.oop.task1.products.meat;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

public abstract class BaseMeat extends BaseProduct {
    protected static final MeasureUnit mu = MeasureUnit.kg;

    public BaseMeat(double cost, int expDate, int productionDate) {
        super(cost, expDate, productionDate, mu);
    }

    public BaseMeat() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Мясо";
    }
}
