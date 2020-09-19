package course2.oop.task1.supermarket;

import course2.oop.task1.products.*;
import course2.oop.task1.utils.Pair;

import java.util.HashMap;
import java.util.Map;

public abstract class SupermarketPremise {
    private Map<ProductBase, Pair<Integer, String>> content = null;

    public Map<ProductBase, Pair<Integer, String>> getContent() {
        return this.content;
    }

    public void setContent(HashMap<ProductBase, course2.oop.task1.utils.Pair<Integer, String>> content) {
        this.content = content;
    }
}
