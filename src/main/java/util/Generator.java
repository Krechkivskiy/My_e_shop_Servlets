package util;

import java.util.Random;

public class Generator {

    public static int getVerificationCode() {
        Random random = new Random();
        int randomValue = random.nextInt(9999) + 1000;
        if (randomValue > 9999) {
            randomValue = randomValue / 10;
        }
        return randomValue;
    }
}
