package course2.oop.task1;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

public class MainServiceRapporteur {

    public void cannotBuyAlcohol() {
        System.out.println("Покупатель пытается купить алкоголь, но ему не продают в силу возраста");
    }

    public void cannotBuyMilk() {
        System.out.println("Покупатель не будет покупать молоко, т.к. у него его непереносимость");
    }

    public void cannotBuyChem() {
        System.out.println("Покупатель не будет покупать химию, т.к. у него на неё аллергия");
    }

    public void cannotBuyVegetablesAndFruits() {
        System.out.println("Покупатель не будет покупать фрукты и овощи, т.к. у него непереносимость клетчатки");
    }

    public void broughtProducts() {
        System.out.println("Привезли товары");
    }

    public void buyerArrived(int num) {
        System.out.println("Пришел покупатель #" + num);
    }

    public void purchase(double count, MeasureUnit mu, BaseProduct prod) {
        System.out.println("Покупатель купил " + count + " " + mu.name() + " " + prod);

    }
}
