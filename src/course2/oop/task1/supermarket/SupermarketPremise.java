package course2.oop.task1.supermarket;

import course2.oop.task1.products.*;
import course2.oop.task1.utils.Pair;

import java.util.Map;

public class SupermarketPremise {
    private Map<BaseProduct, Pair<Double, MeasureUnit>> products = null;

    public Map<BaseProduct, Pair<Double, MeasureUnit>> getProducts() {
        return products;
    }

    public void setProducts(Map<BaseProduct, Pair<Double, MeasureUnit>> products) {
        this.products = products;
    }
}
