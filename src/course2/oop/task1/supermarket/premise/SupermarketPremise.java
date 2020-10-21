package course2.oop.task1.supermarket.premise;

import course2.oop.task1.products.*;
import course2.oop.task1.utils.Pair;

import java.util.HashMap;
import java.util.Map;

public abstract class SupermarketPremise {
    private Map<BaseProduct, Double> products;

    public SupermarketPremise() {
        products = new HashMap<>();
    }

    public Map<BaseProduct, Double> getProducts() {
        return products;
    }

    public void setProducts(Map<BaseProduct, Double> products) {
        this.products = products;
    }
}
