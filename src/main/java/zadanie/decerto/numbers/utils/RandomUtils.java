package zadanie.decerto.numbers.utils;

import java.util.Random;

public class RandomUtils {

    private RandomUtils(){}

    public static int randomIntInRange(Random random, int from, int to) {
        return random.nextInt(to - from) + from;
    }

}
