package course2.oop.task1.products.service;

import course2.oop.task1.products.*;
import course2.oop.task1.utils.GlobalConstants;
import course2.oop.task1.utils.Randomizer;

public class ProductService {

    private static final Randomizer RDZ = new Randomizer();

    public void createRandomProduct(BaseProduct prod) {
        prod.setCost(RDZ.random());
        prod.setExpDate(RDZ.random(3, 100));
        //prod.setProductionDate(date);
        prod.setMu(RDZ.random(GlobalConstants.MEASURE_UNITS));
    }

    public BaseProduct randomProduct(int n) {
        switch (n) {
            case 0 : return new Alcohol();
            case 1 : return new Bread();
            case 2 : return new GreenGrocery();
            case 3 : return new Grocery();
            case 4 : return new HouseholdChemicals();
            case 5 : return new Meat();
            case 6 : return new MilkProducts();
            default : return null;
        }
    }
}
