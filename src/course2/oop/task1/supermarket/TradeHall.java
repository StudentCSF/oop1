package course2.oop.task1.supermarket;

import course2.oop.task1.products.ProductBase;

import java.util.Map;

public class TradeHall extends SupermarketPremise {

    public TradeHall(Map<ProductBase, Integer> content) {
        super(content);
    }
}
