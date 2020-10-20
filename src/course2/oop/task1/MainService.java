package course2.oop.task1;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.buyer.BuyerLimitations;
import course2.oop.task1.buyer.service.BuyerService;
import course2.oop.task1.products.*;
import course2.oop.task1.products.drink.BaseDrink;
import course2.oop.task1.products.chem.BaseHouseholdChemicals;
import course2.oop.task1.products.green_grocery.BaseGreenGrocery;
import course2.oop.task1.products.meat.BaseMeat;
import course2.oop.task1.products.milk.BaseMilkProducts;
import course2.oop.task1.products.service.ProductService;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.service.SupermarketService;
import course2.oop.task1.utils.Pair;
import course2.oop.task1.utils.Randomizer;

import java.util.*;

public class MainService {
    private Randomizer RDZ;
    private SupermarketService SUP_SERV;
    private BuyerService BUY_SERV;
    private ProductService PROD_SERV;
    private MainServiceRapporteur RAPPORTEUR;

    private int buyersCounter = 1;

    private List<Pair<Integer, Buyer>> buyersInSupermarket = new ArrayList<>();

    public MainService() {
        RDZ = new Randomizer();
        SUP_SERV = new SupermarketService();
        BUY_SERV = new BuyerService();
        PROD_SERV = new ProductService();
        RAPPORTEUR = new MainServiceRapporteur();
    }

    public void simulate(Supermarket market) throws Exception {
        int currDate = 0;
        for (int i = 0; i < 10000; i++) {
            int curr = RDZ.random(0, 4);
            switch (curr) {
                case 0:
                    Buyer b = new Buyer();
                    BUY_SERV.setBuyer(b);
                    buyerArrived(b);
                break;
                case 1:
                    if (!buyersInSupermarket.isEmpty()) {
                        buyerPurchase(market, buyersInSupermarket.get(RDZ.random(0, buyersInSupermarket.size())));
                    }
                break;
                case 2: productsBroughtToSupermarket(market, currDate);
                break;
                case 3: SUP_SERV.checkProducts(market, currDate);
                RAPPORTEUR.productsWasChecked();
                default:
            }
            if (i % 100 == 0) {
                currDate++;
            }
        }
    }


    private void buyerArrived(Buyer b) {
        buyersInSupermarket.add(new Pair<Integer, Buyer>(buyersCounter, b));
        RAPPORTEUR.buyerArrived(buyersCounter);
        buyersCounter++;
    }

    private void buyerPurchase(Supermarket market, Pair<Integer, Buyer> b) {
        double money = b.getValue().getAvailableMoney();
        Map<BaseProduct, Double> lp = b.getValue().getShoppingList();
        for (Map.Entry<BaseProduct, Double> kv : lp.entrySet()) {
            if (canPurchase(b, kv.getKey())) {
                double currCost = kv.getKey().getCost() * kv.getValue();
                if (currCost < money) {
                    BUY_SERV.removeFromHall(market, kv.getKey(), kv.getValue());
                    money -= currCost;
                    RAPPORTEUR.purchase(kv.getKey(), kv.getKey().getMeasureUnit(), b.getKey(), kv.getValue());
                }
            }
        }
        buyersInSupermarket.remove(b);
    }

    private boolean canPurchase(Pair<Integer, Buyer> b, BaseProduct p) {
        if (p instanceof BaseDrink && b.getValue().getAge() < 18) {
            return false;
        }
        Set<BuyerLimitations> l = b.getValue().getLimitations();
        if (p instanceof BaseMeat && l.contains(BuyerLimitations.MEAT)) {
            RAPPORTEUR.cannotBuyAlcohol(b.getKey());
            return false;
        }
        if (p instanceof BaseMilkProducts && l.contains(BuyerLimitations.MILK)) {
            RAPPORTEUR.cannotBuyMilk(b.getKey());
            return false;
        }
        if (p instanceof BaseHouseholdChemicals && l.contains(BuyerLimitations.CHEM)) {
            RAPPORTEUR.cannotBuyChem(b.getKey());
            return false;
        }
        if (p instanceof BaseGreenGrocery && l.contains(BuyerLimitations.VaF)) {
            RAPPORTEUR.cannotBuyVegetablesAndFruits(b.getKey());
            return false;
        }
        return true;
    }

    private void productsBroughtToSupermarket(Supermarket market, int date) {
        Map<BaseProduct, Double> brought = PROD_SERV.createRandomProductsSet(RDZ.random(20, 50), date);
        SUP_SERV.addStorage(market, brought);
        RAPPORTEUR.broughtProducts();
    }
}
