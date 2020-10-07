package course2.oop.task1.products;

import course2.oop.task1.utils.GlobalConstants;
import course2.oop.task1.utils.Randomizer;

import java.util.Date;

public class ProductService {

    private static final Randomizer rdz = new Randomizer();

    public void createRandomProduct(BaseProduct prod) {
        prod.setCost(rdz.random());
        prod.setExpDate(rdz.random(3, 100));
        prod.setProductionDate(new Date());
        prod.setMu(rdz.random(GlobalConstants.MEASURE_UNITS));
    }
}
