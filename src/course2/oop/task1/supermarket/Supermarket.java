package course2.oop.task1.supermarket;

public class Supermarket {
    private TradeHall hall = new TradeHall();
    private Storage storage = new Storage();

    public Storage getStorage() {
        return this.storage;
    }

    public TradeHall getHall() {
        return this.hall;
    }
}
