package be.avidoo.usecase.util;

import java.util.Random;

public class RandomNumberGenerator {

    public static String generateRandom10DigitNumber() {
        Random random = new Random();

        // Generate the 10-digit number as a string to avoid overflow
        StringBuilder number = new StringBuilder();

        // Ensure the first digit is not zero
        number.append(random.nextInt(9) + 1);

        // Generate the remaining 9 digits
        for (int i = 0; i < 9; i++) {
            number.append(random.nextInt(10));
        }

        return number.toString();
    }
}
