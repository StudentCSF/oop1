package course2.oop.task1.products;

import java.util.Date;

public class Meat extends BaseProduct {

    public Meat(double cost, int expDate, int productionDate) {
        super(cost, expDate, productionDate, MeasureUnit.KG);
    }

    public Meat() {
        super();
    }

    @Override
    public String toString() {
        return "Мясо";
    }
}
