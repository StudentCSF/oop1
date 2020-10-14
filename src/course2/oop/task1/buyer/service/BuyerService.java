package course2.oop.task1.buyer.service;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.buyer.BuyerLimitations;
import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.service.ProductService;
import course2.oop.task1.supermarket.Supermarket;
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
        Map<BaseProduct, Double> shopList = new HashMap<>();

        int bound = RDZ.random(1, 30);
        for (int i = 0; i < bound; i++) {
            BaseProduct prod  = new ProductService().randomProduct(RDZ.random(0, GlobalConstants.PRODUCTS.size()));
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

    public double removeFromHall(Supermarket market, BaseProduct prod, Double count) {
        if (market.getHall() != null && market.getHall().getProducts().containsKey(prod)) {
            if (count > market.getHall().getProducts().get(prod)) {
                double res = market.getHall().getProducts().get(prod);
                market.getHall().getProducts().remove(prod);
                return res;
            } else {
                market.getHall().getProducts().put(prod, market.getHall().getProducts().get(prod) - count);
            }
        }
        return 0;
    }
}
