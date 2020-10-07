package course2.oop.task1;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.buyer.BuyerService;

public class Main {

    public static void test0() {
        Buyer b  = new Buyer();
        BuyerService bs = new BuyerService();
        bs.setBuyer(b);
        System.out.println(b);
    }

    public static void main(String[] args) {

    }
}
