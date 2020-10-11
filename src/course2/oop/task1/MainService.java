package course2.oop.task1;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.buyer.service.BuyerService;
import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.service.ProductService;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.service.SupermarketService;
import course2.oop.task1.utils.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainService {
    private static final Randomizer RDZ = new Randomizer();
    private static final SupermarketService SUP_SERV = new SupermarketService();
    private static final BuyerService BUY_SERV = new BuyerService();
    private static final ProductService PROD_SERV = new ProductService();

    private List<Buyer> buyersInSupermarket = null;

    public void simulate(Supermarket market) {

    }

    private void buyerArrived(Buyer b) {
        if (buyersInSupermarket == null) {
            buyersInSupermarket = new ArrayList<>();
        }
        buyersInSupermarket.add(b);
    }

    private void buy(Supermarket market, Buyer b) {

    }

    private void productsBroughtToSupermarket(Supermarket market, Map<Class<? extends BaseProduct>, Double> brought) {
        SUP_SERV.addStorage(market, brought);
    }


}
