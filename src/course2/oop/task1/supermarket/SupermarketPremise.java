package course2.oop.task1.supermarket;

import course2.oop.task1.products.*;

import java.util.Map;

public abstract class SupermarketPremise {
    Map<ProductBase, Integer> content;

    public SupermarketPremise() {
    }

    public Map<ProductBase, Integer> getContent() {
        return this.content;
    }

    public void setContent(Map<ProductBase, Integer> content) {
        this.content = content;
    }
}
