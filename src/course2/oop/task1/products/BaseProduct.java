package course2.oop.task1.products;

import java.util.Date;

public abstract class BaseProduct {
    protected double cost;
    protected int expDate;
    protected Date productionDate = null;
    protected MeasureUnit mu = null;

    public BaseProduct() {
    }

    public BaseProduct(double cost, int expDate, Date productionDate, MeasureUnit mu) {
        this.cost = cost;
        this.expDate = expDate;
        this.productionDate = productionDate;
        this.mu = mu;
    }

    public BaseProduct(Date productionDate) {
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

    public MeasureUnit getMeasureUnit() {
        return this.mu;
    }

    public void setExpDate(int expDate) {
        this.expDate = expDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public void setMu(MeasureUnit mu) {
        this.mu = mu;
    }

   /* @Override
    public String toString() {
        if (this instanceof Alcohol) {

        } else if (this instanceof Bread) {

        } else if (this instanceof GreenGrocery) {

        } else if (this instanceof HouseholdChemicals) {

        } else if (this instanceof MeasureUnit)
    }
*/}

