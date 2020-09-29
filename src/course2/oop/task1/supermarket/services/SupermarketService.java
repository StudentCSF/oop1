package course2.oop.task1.supermarket.services;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.SupermarketPremise;
import course2.oop.task1.utils.Pair;

import java.util.HashMap;
import java.util.Map;

public class SupermarketService {

    public void fillStorage(Supermarket market, Map<BaseProduct, Pair<Double, MeasureUnit>> prods) {
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

    public void addStorage(Supermarket market, Map<BaseProduct, Pair<Double, MeasureUnit>> prods) {
        if (market.getStorage() == null) {
            fillStorage(market, prods);
        } else {
            for (Map.Entry<BaseProduct, Pair<Double, MeasureUnit>> pc : prods.entrySet()) {
                if (!market.getStorage().getProducts().containsKey(pc.getKey())) {
                    market.getStorage().getProducts().put(pc.getKey(), pc.getValue());
                } else {
                    market.getStorage().getProducts().put(pc.getKey(), new Pair<Double, MeasureUnit>(market.getStorage().getProducts().get(pc.getKey()).getKey() + pc.getValue().getKey(), pc.getValue().getValue()));
                }
            }
        }
    }

    public Map<BaseProduct, Pair<Double, MeasureUnit>> removeFromSupermarketPremise(SupermarketPremise sp, Map<BaseProduct, Pair<Double, MeasureUnit>> prods) throws Exception {
        Map<BaseProduct, Pair<Double, MeasureUnit>> removedProducts = new HashMap<>();
        if (sp == null) {
            throw new Exception("Error. The supermarket premise is not exist.");
        } else {
            for (Map.Entry<BaseProduct, Pair<Double, MeasureUnit>> pc : prods.entrySet()) {
                if (sp.getProducts().get(pc.getKey()).getKey() <= pc.getValue().getKey()) {
                    removedProducts.put(pc.getKey(), sp.getProducts().remove(pc.getKey()));
                } else {
                    sp.getProducts().put(pc.getKey(), new Pair<Double, MeasureUnit>(sp.getProducts().get(pc.getKey()).getKey() - pc.getValue().getKey(), pc.getValue().getValue()));
                    removedProducts.put(pc.getKey(), sp.getProducts().get(pc.getKey()));
                }
            }
        }
        return removedProducts;
    }

    public void MoveFromStorageToHall(Supermarket market, Map<BaseProduct, Pair<Double, MeasureUnit>> prods) throws Exception {
        Map<BaseProduct, Pair<Double, MeasureUnit>> movingProds = removeFromSupermarketPremise(market.getStorage(), prods);

        if (market.getHall() == null) {
            SupermarketPremise sp = new SupermarketPremise();
            sp.setProducts(movingProds);
            market.setHall(sp);
        }

    }

    public void MoveFromHallToStorage(Supermarket market, Map<BaseProduct, Pair<Double, MeasureUnit>> prods) throws Exception {
        if (market.getHall() == null) {
            throw new Exception("Error. Supermarket hall is not exist.");
        } else {
            Map<BaseProduct, Pair<Double, MeasureUnit>> movingProds = removeFromSupermarketPremise(market.getHall(), prods);
            addStorage(market, movingProds);
        }
    }
}
