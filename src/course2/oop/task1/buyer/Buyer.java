package course2.oop.task1.buyer;

import course2.oop.task1.products.ProductBase;
import course2.oop.task1.utils.Pair;

import java.util.Map;
import java.util.Set;


public class Buyer {
    private int age;
    private double availableMoney;
    private Map<ProductBase, Pair<Integer, String>> shoppingList;
    private Set<BuyerLimitations> limits;

    public Buyer(int age, double availableMoney, Map<ProductBase, Pair<Integer, String>> shoppingList) {
        this.age = age;
        this.availableMoney = availableMoney;
        this.shoppingList = shoppingList;
        this.limits = null;
    }

    public Buyer(int age, double availableMoney, Map<ProductBase, Pair<Integer, String>> shoppingList, Set<BuyerLimitations> limits) {
        this.age = age;
        this.availableMoney = availableMoney;
        this.shoppingList = shoppingList;
        this.limits = limits;
    }

    public Map<ProductBase, Pair<Integer, String>> getShoppingList() {
        return this.shoppingList;
    }

    public double getAvailableMoney() {
        return this.availableMoney;
    }

    public int getAge() {
        return this.age;
    }
}
