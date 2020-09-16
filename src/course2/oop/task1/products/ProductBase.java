package course2.oop.task1.products;

import java.util.Date;

public abstract class ProductBase {
    private double cost;
    private int expDate;
    private Date productionDate;

    public ProductBase(double cost, int expDate, Date productionDate) {
        this.cost = cost;
        this.expDate = expDate;
        this.productionDate = productionDate;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double newCost) {
        this.cost = newCost;
    }

    public Date getProductionDate() {
        return this.productionDate;
    }

    public int getExpDate() {
        return this.expDate;
    }
}
