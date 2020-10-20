package course2.oop.task1.products.chem;

import course2.oop.task1.products.MeasureUnit;

public class Powder extends BaseHouseholdChemicals {
    protected static final MeasureUnit mu = MeasureUnit.kg;

    public Powder(double cost, int expDate, int productionDate) {
        super(cost, expDate, productionDate, mu);
    }

    public Powder() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Порошок";
    }
}
