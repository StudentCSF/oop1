package course2.oop.task1.supermarket;

import course2.oop.task1.products.*;

import java.util.Map;

public abstract class SupermarketPremise {
    private Map<ProductBase, Integer> content = null;
    private int capacity;

    public SupermarketPremise(int capacity) {
        this.capacity = capacity;
    }

    public Map<ProductBase, Integer> getContent() {
        return this.content;
    }

    public void setContent(Map<ProductBase, Integer> content) {
        this.content = content;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getOccupancy() {
        int occ = 0;

        for (Map.Entry<ProductBase, Integer> kv : this.content.entrySet()) {
            occ += kv.getValue();
        }
        return occ;
    }
}
