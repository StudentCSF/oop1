package course2.oop.task1.supermarket;

import course2.oop.task1.products.*;
import course2.oop.task1.utils.Pair;

import java.util.HashMap;
import java.util.Map;

public class SupermarketPremise {
    private Map<BaseProduct, Pair<Double, String>> products = null;

    public Map<BaseProduct, Pair<Double, String>> getProducts() {
        return products;
    }

    public void setProducts(Map<BaseProduct, Pair<Double, String>> products) {
        this.products = products;
    }
}
