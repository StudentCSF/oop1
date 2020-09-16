package course2.oop.task1.supermarket.services;

import course2.oop.task1.products.ProductBase;
import course2.oop.task1.supermarket.SupermarketPremise;

import java.util.HashMap;
import java.util.Map;

public class SupermarketPremiseService {

    public SupermarketPremiseService() {
    }

    public void addTradeHall(ProductBase prod, Integer count) {
        if (this.tradeHall == null) {
            this.tradeHall = new HashMap<ProductBase, String>();
        }
        this.tradeHall.put(prod, count);
    }
}
