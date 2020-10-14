package course2.oop.task1;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.buyer.BuyerLimitations;
import course2.oop.task1.buyer.service.BuyerService;
import course2.oop.task1.products.*;
import course2.oop.task1.products.service.ProductService;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.supermarket.service.SupermarketService;
import course2.oop.task1.utils.Randomizer;

import java.lang.reflect.Method;
import java.util.*;

public class MainService {
    private static final Randomizer RDZ = new Randomizer();
    private static final SupermarketService SUP_SERV = new SupermarketService();
    private static final BuyerService BUY_SERV = new BuyerService();
    private static final ProductService PROD_SERV = new ProductService();

    private static final int COUNTER = 0;

    private List<Buyer> buyersInSupermarket = null;

    public MainService() throws NoSuchMethodException {
    }

    public void simulate(Supermarket market) throws NoSuchMethodException {
        Method m1 = this.getClass().getMethod("buyerArrived", Buyer.class);
    }
        MethodsArray ma = new MethodsArray(new Method[]{this.getClass().getMethod("buyerArrived", Buyer.class)});

    private void buyerArrived(Buyer b) {
        if (buyersInSupermarket == null) {
            buyersInSupermarket = new ArrayList<>();
        }
        buyersInSupermarket.add(b);
        System.out.println("Пришел покупатель #" + buyersInSupermarket.size());
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
                    System.out.println("Покупатель купил " + kv.getValue() + " " + kv.getKey().getMeasureUnit() + " " + kv.getKey());
                }
            }
        }
    }

    private boolean canPurchase(Buyer b, BaseProduct p) {
        if (p instanceof Alcohol && b.getAge() < 18) {
            System.out.println("Покупатель пытается купить алкоголь, но ему не продают в силу возраста");
            return false;
        }
        Set<BuyerLimitations> l = b.getLimitations();
        if (p instanceof Meat && l.contains(BuyerLimitations.MEAT)) {
            System.out.println("Покупатель не будет покупать мясо, т.к. он вегетарианец");
            return false;
        }
        if (p instanceof MilkProducts && l.contains(BuyerLimitations.MILK)) {
            System.out.println("Покупатель не будет покупать молоко, т.к. у него его непереносимость");
            return false;
        }
        if (p instanceof HouseholdChemicals && l.contains(BuyerLimitations.CHEM)) {
            System.out.println("Покупатель не будет покупать химию, т.к. у него на неё аллергия");
            return false;
        }
        if (p instanceof GreenGrocery && l.contains(BuyerLimitations.VaF)) {
            System.out.println("Покупатель не будет покупать фрукты и овощи, т.к. у него непереносимость клетчатки");
            return false;
        }
        return true;
    }

    private void productsBroughtToSupermarket(Supermarket market, Map<BaseProduct, Double> brought) {
        SUP_SERV.addStorage(market, brought);
        System.out.println("Привезли товары");
    }

    private Map<Class<? extends BaseProduct>, Double> createRandomProductsSet() {
        Map<Class<? extends BaseProduct>, Double> prods = new HashMap<>();
        return null;
    }
}
