package course2.oop.task1;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.buyer.BuyerLimitations;
import course2.oop.task1.buyer.service.BuyerService;
import course2.oop.task1.products.*;
import course2.oop.task1.products.service.ProductService;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.service.SupermarketService;
import course2.oop.task1.utils.Randomizer;

import java.util.*;

public class MainService {
    private static final Randomizer RDZ = new Randomizer();
    private static final SupermarketService SUP_SERV = new SupermarketService();
    private static final BuyerService BUY_SERV = new BuyerService();
    private static final ProductService PROD_SERV = new ProductService();
    private static final MainServiceRapporteur RAPPORTEUR = new MainServiceRapporteur();

    private int buyersCounter = 1;

    private List<Buyer> buyersInSupermarket = new ArrayList<>();

    public MainService() {
    }

    public void simulate(Supermarket market) throws NoSuchMethodException {
        for (int i = 0; i < 100; i++) {
            int curr = RDZ.random(0, 3);
            switch (curr) {
                case 0:
                    Buyer b = new Buyer();
                    BUY_SERV.setBuyer(b);
                    buyerArrived(b);
                break;
                case 1:
                    purchase(market, buyersInSupermarket.get(RDZ.random(0, buyersInSupermarket.size())));
                break;
                case 2: productsBroughtToSupermarket(market, null);
                break;
                default:
            }
        }
    }


    private void buyerArrived(Buyer b) {
        buyersInSupermarket.add(b);
        RAPPORTEUR.buyerArrived(buyersCounter);
        buyersCounter++;
    }

    private void purchase(Supermarket market, Buyer b) {
        double money = b.getAvailableMoney();
        Map<BaseProduct, Double> lp = b.getShoppingList();
        for (Map.Entry<BaseProduct, Double> kv : lp.entrySet()) {
            if (canPurchase(b, kv.getKey())) {
                double currCost = kv.getKey().getCost() * kv.getValue();
                if (currCost < money) {
                    BUY_SERV.removeFromHall(market, kv.getKey(), kv.getValue());
                    money -= currCost;
                    RAPPORTEUR.purchase(kv.getValue(), kv.getKey().getMeasureUnit(), kv.getKey());
                }
            }
        }
    }

    private boolean canPurchase(Buyer b, BaseProduct p) {
        if (p instanceof Alcohol && b.getAge() < 18) {
            return false;
        }
        Set<BuyerLimitations> l = b.getLimitations();
        if (p instanceof Meat && l.contains(BuyerLimitations.MEAT)) {
            RAPPORTEUR.cannotBuyAlcohol();
            return false;
        }
        if (p instanceof MilkProducts && l.contains(BuyerLimitations.MILK)) {
            RAPPORTEUR.cannotBuyMilk();
            return false;
        }
        if (p instanceof HouseholdChemicals && l.contains(BuyerLimitations.CHEM)) {
            RAPPORTEUR.cannotBuyChem();
            return false;
        }
        if (p instanceof GreenGrocery && l.contains(BuyerLimitations.VaF)) {
            RAPPORTEUR.cannotBuyVegetablesAndFruits();
            return false;
        }
        return true;
    }

    private void productsBroughtToSupermarket(Supermarket market, Map<BaseProduct, Double> brought) {
        SUP_SERV.addStorage(market, brought);
        RAPPORTEUR.broughtProducts();
    }

    private Map<BaseProduct, Double> createRandomProductsSet() {
        Map<BaseProduct, Double> prods = new HashMap<>();
        return null;
    }
}
