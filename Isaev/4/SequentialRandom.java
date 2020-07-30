import java.util.Random;

public class SequentialRandom {
    Random random = new Random();
    private int immutableRandomNumber = random.nextInt();
    int counter = 0;
    int countedNumber;

    public int getImmutableRandomNumber() {
        if (counter == 0) {
            counter++;
            countedNumber = immutableRandomNumber;
            return countedNumber;
        } else {
            return countedNumber += 1;
        }
    }

    private void resetRandom() {
        immutableRandomNumber = random.nextInt();
        counter = 0;
    }


    public static void main(String[] args) {
        SequentialRandom seq = new SequentialRandom();
        System.out.println(seq.getImmutableRandomNumber());
        System.out.println(seq.getImmutableRandomNumber());
        System.out.println(seq.getImmutableRandomNumber());
        seq.resetRandom();
        System.out.println(seq.getImmutableRandomNumber());
        System.out.println(seq.getImmutableRandomNumber());
        System.out.println(seq.getImmutableRandomNumber());

    }
}
