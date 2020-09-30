package course2.oop.task1.buyer;

import course2.oop.task1.products.BaseProduct;

import java.util.Map;
import java.util.Set;


public class Buyer {
    private int age;
    private double availableMoney;
    private Map<BaseProduct, Double> shoppingList;
    private Set<BuyerLimitations> limitations;

    public Buyer(int age, double availableMoney, Map<BaseProduct, Double> shoppingList, Set<BuyerLimitations> limits) {
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

    public Map<BaseProduct, Double> getShoppingList() {
        return shoppingList;
    }

    public Set<BuyerLimitations> getLimitations() {
        return limitations;
    }

    public void setAvailableMoney(double availableMoney) {
        this.availableMoney = availableMoney;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setShoppingList(Map<BaseProduct, Double> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public void setLimitations(Set<BuyerLimitations> limitations) {
        this.limitations = limitations;
    }
}
