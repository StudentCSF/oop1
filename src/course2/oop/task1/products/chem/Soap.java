package course2.oop.task1.products.chem;

import course2.oop.task1.products.MeasureUnit;

public class Soap extends BaseHouseholdChemicals {
    protected static final MeasureUnit mu = MeasureUnit.pcs;

    public Soap(double cost, int expDate, int productionDate) {
        super(cost, expDate, productionDate, mu);
    }

    public Soap() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Мыло";
    }
}
