package course2.oop.task1.products.milk;

import course2.oop.task1.products.MeasureUnit;

public class Butter extends BaseMilkProducts {
    protected static final MeasureUnit mu = MeasureUnit.kg;

    public Butter() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Сливочное масло";
    }
}
