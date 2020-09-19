package course2.oop.task1.supermarket.services;

import course2.oop.task1.products.ProductBase;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.SupermarketPremise;

import java.util.HashMap;

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
            prem.setContent(new HashMap<ProductBase, Integer>());
        }
        prem.getContent().put(prod, count);
    }

    public void remove(SupermarketPremise prem, ProductBase prod, int count) {
        if (prem.getContent() != null && prem.getContent().containsKey(prod)) {
            int currCount = prem.getContent().get(prod);
            if (currCount <= count) {
                prem.getContent().remove(prod);
            } else {
                prem.getContent().put(prod, count - currCount);
            }
        }
    }
}
