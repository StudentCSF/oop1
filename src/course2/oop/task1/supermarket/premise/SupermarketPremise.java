package course2.oop.task1.supermarket.premise;

import course2.oop.task1.products.*;
import course2.oop.task1.utils.Pair;

import java.util.Map;

public abstract class SupermarketPremise {
    private Map<Class<? extends BaseProduct>, Double> products = null;

    public Map<Class<? extends BaseProduct>, Double> getProducts() {
        return products;
    }

    public void setProducts(Map<Class<? extends BaseProduct>, Double> products) {
        this.products = products;
    }
}
