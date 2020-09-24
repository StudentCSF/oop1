package course2.oop.task1.buyer;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.utils.Pair;

import java.util.Map;


public class Buyer {
    private int age;
    private double availableMoney;
    private Map<BaseProduct, Pair<Double, String>> shoppingList;
    private String[] limitations;

    public Buyer(int age, double availableMoney, Map<BaseProduct, Pair<Double, String>> shoppingList, String[] limits) {
        this.age = age;
        this.availableMoney = availableMoney;
        this.shoppingList = shoppingList;
        this.limitations = limits;
    }

    public int getAge() {
        return age;
    }

    public double getAvailableMoney() {
        return availableMoney;
    }

    public Map<BaseProduct, Pair<Double, String>> getShoppingList() {
        return shoppingList;
    }

    public String[] getLimitations() {
        return limitations;
    }

    public void setAvailableMoney(double availableMoney) {
        this.availableMoney = availableMoney;
    }
}
