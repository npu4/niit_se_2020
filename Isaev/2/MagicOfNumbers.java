import java.lang.reflect.Array;
import java.util.Random;
import java.util.stream.IntStream;

public class MagicOfNumbers {

    public static void main(String[] args) {

        Random myRandom = new Random();
        int[] randomNumbers = myRandom.ints(-100, 100).limit(100).toArray();
        for (int i : randomNumbers) {
            if (isMagicNumber(i)) {
                System.out.println("Число '" + i + "' - магическое!");
            }
        }
    }

    static boolean isMagicNumber(int number) {
        int absoluteNumber = Math.abs(number);
        return (absoluteNumber / 10 == absoluteNumber % 10);
    }
}



