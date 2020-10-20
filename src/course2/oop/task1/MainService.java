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
        for (int i = 0; i < 1000; i++) {
            if (i==500) {
                test(market.getHall().getProducts());
            }
            int curr = RDZ.random(0, 4);
            curr = i % 2== 0 ? 2 : 4;
            switch (curr) {
               /* case 0:
                    Buyer b = new Buyer();
                    BUY_SERV.setBuyer(b);
                    buyerArrived(b);
                    RAPPORTEUR.report("Пришел покупатель #" + buyersCounter);
                    buyersCounter++;
                    break;
                case 1:
                    if (!buyersInSupermarket.isEmpty()) {
                        buyerPurchase(market, buyersInSupermarket.get(RDZ.random(0, buyersInSupermarket.size())));
                    }
                    break;*/
                case 2:
                    productsBroughtToSupermarket(market, currDate);
                    //RAPPORTEUR.report("Привезли товары");
                    break;
               /* case 3:
                    SUP_SERV.checkProducts(market, currDate);
                    RAPPORTEUR.report("Персонал проверил товары на годность");
                    break;*/
                case 4:
                    SUP_SERV.simpleMoveFromStorageToHall(market);
                    //RAPPORTEUR.report("Товары со склада перенесли в торговый зал");
                    break;
                default:
                    continue;
            }

            if (i % 100 == 0) {
                currDate++;
            }
        }
    }

    private void test(Map<BaseProduct, Double> m) {
        System.out.println(m.size());
        for (Map.Entry<BaseProduct, Double> kv : m.entrySet()) {
            System.out.println(kv.getKey() + " " + kv.getValue());
        }
    }


    private void buyerArrived(Buyer b) {
        buyersInSupermarket.add(new Pair<Integer, Buyer>(buyersCounter, b));
    }

    private void buyerPurchase(Supermarket market, Pair<Integer, Buyer> b) {
        //double money = b.getValue().getAvailableMoney();
        Map<BaseProduct, Double> lp = b.getValue().getShoppingList();
        for (Map.Entry<BaseProduct, Double> kv : lp.entrySet()) {
            if (SUP_SERV.hasProduct(market, kv.getKey()) >= kv.getValue()) {
                if (canPurchase(b, kv.getKey())) {
                    double currCost = kv.getKey().getCost() * kv.getValue();
                    if (currCost < b.getValue().getAvailableMoney()) {
                        //double flag = BUY_SERV.take(market, kv.getKey(), kv.getValue());
                    /*if (flag < 1E-6) {
                        RAPPORTEUR.report("Покупатель #" + b.getKey() + " не нашел искомый товар");
                        continue;
                    }*/
                        market.getHall().getProducts().put(kv.getKey(), market.getHall().getProducts().get(kv.getKey()) - kv.getValue());
                        b.getValue().setAvailableMoney(b.getValue().getAvailableMoney() - currCost);
                        //money -= currCost;
                        RAPPORTEUR.report("Покупатель #" + b.getKey() + " купил " + kv.getValue() + " " + kv.getKey().getMeasureUnit() + " " + kv.getKey());
                    } else {
                        RAPPORTEUR.report("У покупателя #" + b.getKey() + " не хватает денег на данный товар");
                    }
                }
            } else {
                RAPPORTEUR.report("Покупатель #" + b.getKey() + " не нашел нужного товара в магазине");
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
            RAPPORTEUR.report("Покупатель #" + b.getKey() + " пытается купить алкоголь, но ему не продают в силу возраста");
            return false;
        }
        if (p instanceof BaseMilkProducts && l.contains(BuyerLimitations.MILK)) {
            RAPPORTEUR.report("Покупатель #" + b.getKey() + " не будет покупать молоко, т.к. у него его непереносимость");
            return false;
        }
        if (p instanceof BaseHouseholdChemicals && l.contains(BuyerLimitations.CHEM)) {
            RAPPORTEUR.report("Покупатель #" + b.getKey() + " не будет покупать химию, т.к. у него на неё аллергия");
            return false;
        }
        if (p instanceof BaseGreenGrocery && l.contains(BuyerLimitations.VaF)) {
            RAPPORTEUR.report("Покупатель #" + b.getKey() + " не будет покупать фрукты и овощи, т.к. у него непереносимость клетчатки");
            return false;
        }
        return true;
    }

    private void productsBroughtToSupermarket(Supermarket market, int date) {
        Map<BaseProduct, Double> brought = PROD_SERV.createRandomProductsSet(RDZ.random(300, 1000), date);
        SUP_SERV.addStorage(market, brought);
    }
}
