package course2.oop.task1;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

public class MainServiceRapporteur {

    public void cannotBuyAlcohol(int num) {
        System.out.println("Покупатель #" + num + " пытается купить алкоголь, но ему не продают в силу возраста");
    }

    public void cannotBuyMilk(int num) {
        System.out.println("Покупатель #" + num + " не будет покупать молоко, т.к. у него его непереносимость");
    }

    public void cannotBuyChem(int num) {
        System.out.println("Покупатель #" + num + " не будет покупать химию, т.к. у него на неё аллергия");
    }

    public void cannotBuyVegetablesAndFruits(int num) {
        System.out.println("Покупатель #" + num + " не будет покупать фрукты и овощи, т.к. у него непереносимость клетчатки");
    }

    public void broughtProducts() {
        System.out.println("Привезли товары");
    }

    public void buyerArrived(int num) {
        System.out.println("Пришел покупатель #" + num);
    }

    public void purchase(BaseProduct prod, MeasureUnit mu, int num, double count) {
        System.out.println("Покупатель #" + num + " купил " + count + " " + mu + " " + prod);
    }

    public void productsWasChecked() {
        System.out.println("Персонал проверил товары на годность");
    }
}
