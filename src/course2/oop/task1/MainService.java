package course2.oop.task1;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.supermarket.Supermarket;
import course2.oop.task1.utils.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class MainService {
    private static final Randomizer RDZ = new Randomizer();

    private List<Buyer> buyersInSupermarket = null;

    public void simulate(Supermarket market) {

    }

    private void buyerArrived(Buyer b) {
        if (buyersInSupermarket == null) {
            buyersInSupermarket = new ArrayList<>();
        }
        buyersInSupermarket.add(b);
    }

    private void buy(Supermarket market, Buyer b) {

    }
}
