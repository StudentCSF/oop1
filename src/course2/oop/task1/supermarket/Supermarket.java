package course2.oop.task1.supermarket;

public class Supermarket {
    private SupermarketPremise hall = null;
    private SupermarketPremise storage = null;

    public SupermarketPremise getHall() {
        return hall;
    }

    public SupermarketPremise getStorage() {
        return storage;
    }

    public void setHall(SupermarketPremise hall) {
        this.hall = hall;
    }

    public void setStorage(SupermarketPremise storage) {
        this.storage = storage;
    }
}
