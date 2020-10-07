package course2.oop.task1.buyer;

;

import course2.oop.task1.products.BaseProduct;

import java.util.Map;
import java.util.Set;


public class Buyer {
    private int age;
    private double availableMoney;
    private Map<Class<? extends BaseProduct>, Double> shoppingList;
    private Set<BuyerLimitations> limitations;

    public Buyer() {
    }

    public Buyer(int age, double availableMoney, Map<Class<? extends BaseProduct>, Double> shoppingList, Set<BuyerLimitations> limits) {
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

    public Map<Class<? extends BaseProduct>, Double> getShoppingList() {
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

    public void setShoppingList(Map<Class<? extends BaseProduct>, Double> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public void setLimitations(Set<BuyerLimitations> limitations) {
        this.limitations = limitations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Age - " + this.age + "\n");
        sb.append("Available Money - " + this.availableMoney + "\n");
        for (Map.Entry<Class<? extends BaseProduct>, Double> kv : this.shoppingList.entrySet()) {
            sb.append("Prod - " + kv.getKey().toString() + "\n");
            sb.append("Count - " + kv.getValue() + "\n");
        }
        if (this.limitations != null) {
            for (BuyerLimitations lim : this.limitations) {
                sb.append(lim.toString() + "\n");
            }
        }
        return sb.toString();
    }
}
