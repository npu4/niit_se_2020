import java.util.Arrays;
import java.util.Random;

public class OppositeSignsNumbers {

    public static void main(String[] args) {

        Random myRandom = new Random();
        int[] randomNumbers = myRandom.ints(-2147483648, 2147483647).limit(10).toArray();
        System.out.println("Массив " + Arrays.toString(randomNumbers));

        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i] > 0 && randomNumbers[i + 1] < 0 || randomNumbers[i] < 0 && randomNumbers[i + 1] > 0) {
                System.out.println("Числа с противоположными знаками обнаружены: " + randomNumbers[i] + " " + randomNumbers[i + 1]);
            }
            if (i == 8) break;
        }
    }
}
