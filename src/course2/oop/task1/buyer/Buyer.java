package course2.oop.task1.buyer;

import course2.oop.task1.products.ProductBase;

import java.util.Map;

public class Buyer {
    private int age;
    private double availableMoney;
    private Map<ProductBase, Integer> shoppingList;

    public Buyer(int age, double availableMoney, Map<ProductBase, Integer> shoppingList) {
        this.age = age;
        this.availableMoney = availableMoney;
        this.shoppingList = shoppingList;
    }

    public Map<ProductBase, Integer> getShoppingList() {
        return this.shoppingList;
    }

    public double getAvailableMoney() {
        return this.availableMoney;
    }

    public int getAge() {
        return this.age;
    }
}
