package course2.oop.task1.supermarket.services;

import course2.oop.task1.products.ProductBase;
import course2.oop.task1.supermarket.SupermarketPremise;

import java.util.HashMap;
import java.util.Map;

public class SupermarketPremiseService {

    public void add(SupermarketPremise prem, ProductBase prod, int count) {
        if (prem.getContent() == null) {
            prem.setContent(new HashMap<ProductBase, Integer>());
        }
        prem.getContent().put(prod, count);
    }

    public void remove(SupermarketPremise prem, ProductBase prod, int count) {

    }
}
