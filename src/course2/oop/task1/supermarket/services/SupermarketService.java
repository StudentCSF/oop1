package course2.oop.task1.supermarket.services;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.products.ProductBase;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.SupermarketPremise;
import course2.oop.task1.utils.Pair;

import java.util.HashMap;
import java.util.Map;

public class SupermarketService {

    public void moveFromStorageToTradeHall(Supermarket market, ProductBase prod, int count) {
        remove(market.getStorage(), prod, count);
        add(market.getHall(), prod, count);
    }

    public void moveFromTradeHallToStorage(Supermarket market, ProductBase prod, int count) {
        remove(market.getHall(), prod, count);
        add(market.getStorage(), prod, count);
    }

    public void add(SupermarketPremise prem, ProductBase prod, int count) {
        if (prem.getContent() == null) {
            prem.setContent(new HashMap<ProductBase, Pair<Integer, String>>());
        }
        prem.getContent().put(prod, new Pair<Integer, String>(count, null));
    }

    public void remove(SupermarketPremise prem, ProductBase prod, int count) {
        if (prem.getContent() != null && prem.getContent().containsKey(prod)) {
            int currCount = prem.getContent().get(prod).getKey();
            if (currCount <= count) {
                prem.getContent().remove(prod);
            } else {
                prem.getContent().put(prod, new Pair<Integer, String>(currCount - count, null));
            }
        }
    }

    public void buying(Supermarket market, Buyer b) {
        for (Map.Entry<ProductBase, Pair<Integer, String>> kv : b.getShoppingList().entrySet()) {

        }
    }
}
