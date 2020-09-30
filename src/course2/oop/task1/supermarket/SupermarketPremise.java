package course2.oop.task1.supermarket;

import course2.oop.task1.products.*;
import course2.oop.task1.utils.Pair;

import java.util.Map;

public abstract class SupermarketPremise {
    private Map<BaseProduct, Double> products = null;

    public Map<BaseProduct, Double> getProducts() {
        return products;
    }

    public void setProducts(Map<BaseProduct, Double> products) {
        this.products = products;
    }
}
