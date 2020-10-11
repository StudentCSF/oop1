package course2.oop.task1.supermarket;

import course2.oop.task1.supermarket.premise.Storage;
import course2.oop.task1.supermarket.premise.TradeHall;

public class Supermarket {
    private TradeHall hall = null;
    private Storage storage = null;

    public TradeHall getHall() {
        return hall;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setHall(TradeHall hall) {
        this.hall = hall;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
