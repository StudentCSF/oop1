package course2.oop.task1.supermarket.services;

import course2.oop.task1.products.ProductBase;
import course2.oop.task1.supermarket.Supermarket;

import java.util.Map;

public class SupermarketService {

    public void moveFromStorageToTradeHall(Supermarket market, ProductBase prod, int count) {
        SupermarketPremiseService sps = new SupermarketPremiseService();
        sps.remove(market.getStorage(), prod, count);
    }
}
