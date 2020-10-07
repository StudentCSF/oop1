package course2.oop.task1.buyer;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;
import course2.oop.task1.utils.GlobalConstants;
import course2.oop.task1.utils.Pair;
import course2.oop.task1.utils.Randomizer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BuyerService {
    private static final Randomizer rdz = new Randomizer();

    public void setBuyer(Buyer b) {
        b.setAge(rdz.random(5, 90));
        createRandomShoppingList(b);
        b.setAvailableMoney(rdz.random());
        createRadomLims(b);
    }

    private void createRandomShoppingList(Buyer b)  {
        Map<Class<? extends BaseProduct>, Double> shopList = new HashMap<>();

        int bound = rdz.random(1, 30);
        for (int i = 0; i < bound; i++) {
            Class<? extends BaseProduct> prod  = rdz.random(GlobalConstants.PRODUCTS);
            shopList.put(prod, rdz.random() / 10);
        }
        b.setShoppingList(shopList);
    }

    private void createRadomLims(Buyer b) {
        Set<BuyerLimitations> lims = new HashSet<>();

        int bound = rdz.random(0, GlobalConstants.BUYER_LIMITATIONS.size());
        for (int i = 0; i < bound; i++) {
            lims.add(rdz.random(GlobalConstants.BUYER_LIMITATIONS));
        }
    }
}
