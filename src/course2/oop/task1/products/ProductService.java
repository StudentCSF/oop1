package course2.oop.task1.products;

import course2.oop.task1.utils.GlobalConstants;
import course2.oop.task1.utils.Randomizer;

public class ProductService {

    public void randomProduct(BaseProduct prod) {
        createRandomMeasureUnit(prod);
        createRandomExpDate(prod);
        createRandomProductionDate(prod);
        createRandomCost(prod);
    }

    private void createRandomCost(BaseProduct prod) {

    }

    private void createRandomExpDate(BaseProduct prod) {

    }

    private void createRandomProductionDate(BaseProduct prod) {
        if (prod.getProductionDate() == null) {

        }
    }

    private void createRandomMeasureUnit(BaseProduct prod) {
        if (prod.getMeasureUnit() == null) {
            Randomizer rdz = new Randomizer();
            prod.setMu(rdz.random(GlobalConstants.MEASURE_UNITS));
        }
    }
}
