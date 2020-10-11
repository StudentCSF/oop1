package course2.oop.task1.buyer.service;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.buyer.BuyerLimitations;
import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.utils.GlobalConstants;
import course2.oop.task1.utils.Randomizer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BuyerService {
    private static final Randomizer RDZ = new Randomizer();

    public void setBuyer(Buyer b) {
        b.setAge(RDZ.random(5, 90));
        createRandomShoppingList(b);
        b.setAvailableMoney(RDZ.random());
        createRandomLims(b);
    }

    private void createRandomShoppingList(Buyer b)  {
        Map<Class<? extends BaseProduct>, Double> shopList = new HashMap<>();

        int bound = RDZ.random(1, 30);
        for (int i = 0; i < bound; i++) {
            Class<? extends BaseProduct> prod  = RDZ.random(GlobalConstants.PRODUCTS);
            shopList.put(prod, RDZ.random() / 10);
        }
        b.setShoppingList(shopList);
    }

    private void createRandomLims(Buyer b) {
        Set<BuyerLimitations> lims = new HashSet<>();

        int bound = RDZ.random(0, GlobalConstants.BUYER_LIMITATIONS.size());
        for (int i = 0; i < bound; i++) {
            lims.add(RDZ.random(GlobalConstants.BUYER_LIMITATIONS));
        }
        b.setLimitations(lims);
    }
}
