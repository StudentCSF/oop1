package course2.oop.task1.buyer;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;
import course2.oop.task1.utils.GlobalConstants;
import course2.oop.task1.utils.Pair;
import course2.oop.task1.utils.Randomizer;

import java.util.HashMap;
import java.util.Map;

public class BuyerService {
    private static final Randomizer rdz = new Randomizer();

    public void createRandomShoppingList(Buyer b)  {
        Map<BaseProduct, Double> shopList = new HashMap<>();
        int size = rdz.random(1, 30);

        for(int i = 0; i < size; i++) {

        }

        b.setShoppingList(shopList);
    }
}
