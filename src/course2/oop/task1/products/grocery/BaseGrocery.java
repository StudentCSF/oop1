package course2.oop.task1.products.grocery;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

import java.util.Date;

public abstract class BaseGrocery extends BaseProduct {
    protected static final MeasureUnit mu = MeasureUnit.kg;

    public BaseGrocery(double cost, int expDate, int productionDate) {
        super(cost, expDate, productionDate, mu);
    }

    public BaseGrocery() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Бакалейные товары";
    }
}
