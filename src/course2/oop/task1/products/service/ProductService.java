package course2.oop.task1.products.service;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.utils.GlobalConstants;
import course2.oop.task1.utils.Randomizer;

import java.util.Date;

public class ProductService {

    private static final Randomizer RDZ = new Randomizer();

    public void createRandomProduct(BaseProduct prod) {
        prod.setCost(RDZ.random());
        prod.setExpDate(RDZ.random(3, 100));
        prod.setProductionDate(new Date());
        prod.setMu(RDZ.random(GlobalConstants.MEASURE_UNITS));
    }
}
