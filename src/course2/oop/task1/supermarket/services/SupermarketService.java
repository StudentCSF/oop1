package course2.oop.task1.supermarket.services;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.SupermarketPremise;
import course2.oop.task1.utils.Pair;

import java.util.Map;

public class SupermarketService {

    public void fillSupermarketStorage(Supermarket m, Map<BaseProduct, Pair<Double, String>> prod) {
        if (m.getStorage() == null) {
            SupermarketPremise sp = new SupermarketPremise();
            sp.setProducts(prod);
            m.setStorage(sp);
        } else if (m.getStorage().getProducts() == null) {
            m.getStorage().setProducts(prod);
        } else {
            addToStorage(m, prod);
        }
    }

    public void addToStorage(Supermarket m, Map<BaseProduct, Pair<Double, String>> prod) {

    }
}
