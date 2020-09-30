package course2.oop.task1.utils;

import java.util.List;
import java.util.Random;

public class Randomizer {
    private static final Random rnd = new Random();

    public <T> T random(List<T> list) {
        return list.get(rnd.nextInt(list.size() - 1));
    }

    public int random(int from, int to) {
        return rnd.nextInt(to - from) + from;
    }

    public double random() {
        String str = String.valueOf(rnd.nextDouble() * 1000);
        return Double.parseDouble(str.substring(0, str.indexOf(".") + 3));
    }
}
