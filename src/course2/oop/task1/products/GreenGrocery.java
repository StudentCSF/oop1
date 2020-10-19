package course2.oop.task1.products;

import java.util.Date;

public class GreenGrocery extends BaseProduct {

    public GreenGrocery(double cost, int expDate, Date productionDate) {
        super(cost, expDate, productionDate, MeasureUnit.KG);
    }

    public GreenGrocery() {
        super();
    }

    @Override
    public String toString() {
        return "Овощи/Фрукты";
    }
}
