package course2.oop.task1.products;

import java.util.Date;

public class Bread extends BaseProduct {

    public Bread(double cost, int expDate, int productionDate) {
        super(cost, expDate, productionDate, MeasureUnit.PCS);
    }

    public Bread() {
        super();
    }

    @Override
    public String toString() {
        return "Хлеб";
    }
}
