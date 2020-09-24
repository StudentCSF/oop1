package course2.oop.task1.supermarket.services;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.SupermarketPremise;
import course2.oop.task1.utils.Pair;

import java.util.HashMap;
import java.util.Map;

public class SupermarketService {

    public void fillSupermarketStorage(Supermarket market, Map<BaseProduct, Pair<Double, String>> prods) {
        if (market.getStorage() == null) {
            SupermarketPremise sp = new SupermarketPremise();
            sp.setProducts(prods);
            market.setStorage(sp);
        } else if (market.getStorage().getProducts() == null) {
            market.getStorage().setProducts(prods);
        } else {
            addStorage(market, prods);
        }
    }

    public void addStorage(Supermarket market, Map<BaseProduct, Pair<Double, String>> prods) {
        if (market.getStorage() == null) {
            fillSupermarketStorage(market, prods);
        } else {
            for (Map.Entry<BaseProduct, Pair<Double, String>> pc : prods.entrySet()) {
                if (!market.getStorage().getProducts().containsKey(pc.getKey())) {
                    market.getStorage().getProducts().put(pc.getKey(), pc.getValue());
                } else {
                    market.getStorage().getProducts().put(pc.getKey(), new Pair<Double, String>(market.getStorage().getProducts().get(pc.getKey()).getKey() + pc.getValue().getKey(), pc.getValue().getValue()));
                }
            }
        }
    }

    public Map<BaseProduct, Pair<Double, String>> removeFromSupermarketStorage(Supermarket market, Map<BaseProduct, Pair<Double, String>> prods) {
        Map<BaseProduct, Pair<Double, String>> removedProducts = new HashMap<>();

        if (market.getStorage() != null) {
            for (Map.Entry<BaseProduct, Pair<Double, String>> pc : prods.entrySet()) {
                if (market.getStorage().getProducts().get(pc.getKey()).getKey() <= pc.getValue().getKey()) {
                    removedProducts.put(pc.getKey(), market.getStorage().getProducts().remove(pc.getKey()));
                } else {
                    market.getStorage().getProducts().put(pc.getKey(), new Pair<Double, String>(market.getStorage().getProducts().get(pc.getKey()).getKey() - pc.getValue().getKey(), pc.getValue().getValue()));
                    removedProducts.put(pc.getKey(), market.getStorage().getProducts().get(pc.getKey()));
                }
            }
        }
        return removedProducts;
    }

    public void MoveFromStorageToSupermarketHall(Supermarket market, Map<BaseProduct, Pair<Double, String>> prods) {
        removeFromSupermarketStorage(market, prods);

       if (market.getHall() == null) {
           SupermarketPremise sp = new SupermarketPremise();
           sp.setProducts(prods);
           market.setHall(sp);
       }
    }
}
