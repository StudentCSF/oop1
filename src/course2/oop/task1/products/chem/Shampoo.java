package course2.oop.task1.products.chem;

import course2.oop.task1.products.MeasureUnit;

public class Shampoo extends BaseHouseholdChemicals {
    protected static final MeasureUnit mu = MeasureUnit.pcs;

    public Shampoo(double cost, int expDate, int productionDate) {
        super(cost, expDate, productionDate, mu);
    }

    public Shampoo() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Шампунь";
    }
}
