package course2.oop.task1.products;

import java.util.Date;

public class Grocery extends BaseProduct {

    public Grocery(double cost, int expDate, Date productionDate) {
        super(cost, expDate, productionDate, "kg");
    }
}
