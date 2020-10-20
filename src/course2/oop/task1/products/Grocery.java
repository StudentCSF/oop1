package course2.oop.task1.products;

import java.util.Date;

public class Grocery extends BaseProduct {

    public Grocery(double cost, int expDate, int productionDate, MeasureUnit mu) {
        super(cost, expDate, productionDate, mu);
    }

    public Grocery() {
        super();
    }

    @Override
    public String toString() {
        return "Бакалейные товары";
    }
}
