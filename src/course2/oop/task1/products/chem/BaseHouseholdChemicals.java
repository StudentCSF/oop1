package course2.oop.task1.products.chem;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

import java.util.Date;

public abstract class BaseHouseholdChemicals extends BaseProduct {

    public BaseHouseholdChemicals(double cost, int expDate, int productionDate, MeasureUnit mu) {
        super(cost, expDate, productionDate , mu);
    }

    public BaseHouseholdChemicals(MeasureUnit mu) {
        super(mu);
    }

    @Override
    public String toString() {
        return "Химия";
    }
}
