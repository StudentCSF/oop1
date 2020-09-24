package course2.oop.task1.products;

import java.util.Date;

public abstract class BaseProduct {
    private double cost;
    private int expDate;
    private Date productionDate;
    private String measureUnit = null;

    public BaseProduct(double cost, int expDate, Date productionDate, String measureUnit) {
        this.cost = cost;
        this.expDate = expDate;
        this.productionDate = productionDate;
        this.measureUnit = measureUnit;
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

    public String getMeasureUnit() {
        return measureUnit;
    }
}
