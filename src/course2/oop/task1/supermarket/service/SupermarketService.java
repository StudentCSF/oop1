package course2.oop.task1.supermarket.service;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.supermarket.premise.Storage;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.premise.SupermarketPremise;
import course2.oop.task1.supermarket.premise.TradeHall;

import java.util.HashMap;
import java.util.Map;

public class SupermarketService {

    public void addStorage(Supermarket market, Map<Class<? extends BaseProduct>, Double> prods) {
        if (market.getStorage() == null) {
            Storage sp = new Storage();
            sp.setProducts(prods);
            market.setStorage(sp);
        } else if (market.getStorage().getProducts() == null) {
            market.getStorage().setProducts(prods);
        }  else {
            for (Map.Entry<Class<? extends BaseProduct>, Double> pc : prods.entrySet()) {
                if (!market.getStorage().getProducts().containsKey(pc.getKey())) {
                    market.getStorage().getProducts().put(pc.getKey(), pc.getValue());
                } else {
                    market.getStorage().getProducts().put(pc.getKey(), market.getStorage().getProducts().get(pc.getKey()) + pc.getValue());
                }
            }
        }
    }

    public Map<Class<? extends BaseProduct>, Double> removeFromSupermarketPremise(SupermarketPremise sp, Map<Class<? extends BaseProduct>, Double> prods) throws Exception {
        Map<Class<? extends BaseProduct>, Double> removedProducts = new HashMap<>();
        if (sp == null) {
            throw new Exception("Error. The supermarket premise is not exist.");
        } else {
            for (Map.Entry<Class<? extends BaseProduct>, Double> pc : prods.entrySet()) {
                if (sp.getProducts().get(pc.getKey()) <= pc.getValue()) {
                    removedProducts.put(pc.getKey(), sp.getProducts().remove(pc.getKey()));
                } else {
                    sp.getProducts().put(pc.getKey(), sp.getProducts().get(pc.getKey()) - pc.getValue());
                    removedProducts.put(pc.getKey(), sp.getProducts().get(pc.getKey()));
                }
            }
        }
        return removedProducts;
    }

    public void MoveFromStorageToHall(Supermarket market, Map<Class<? extends BaseProduct>, Double> prods) throws Exception {
        Map<Class<? extends BaseProduct>, Double> movingProds = removeFromSupermarketPremise(market.getStorage(), prods);

        if (market.getHall() == null) {
            TradeHall sp = new TradeHall();
            sp.setProducts(movingProds);
            market.setHall(sp);
        }

    }

    public void MoveFromHallToStorage(Supermarket market, Map<Class<? extends BaseProduct>, Double> prods) throws Exception {
        if (market.getHall() == null) {
            throw new Exception("Error. Supermarket hall is not exist.");
        } else {
            Map<Class<? extends BaseProduct>, Double> movingProds = removeFromSupermarketPremise(market.getHall(), prods);
            addStorage(market, movingProds);
        }
    }
}
