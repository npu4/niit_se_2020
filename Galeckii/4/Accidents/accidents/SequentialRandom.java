package accidents;

import java.util.Random;

public class SequentialRandom {
    private static int number;
    private static boolean isNumberSet = false;

    public SequentialRandom() {
        if (isNumberSet) {
            number++;
        }
        if (!isNumberSet) {
            number = new Random().nextInt();
            isNumberSet = true;
        }
        System.out.println(number);
    }

    public static void resetRandom() {
        isNumberSet = false;
    }

    public int getNumber() {
        return number;
    }
}
