import java.util.Random;

public final class SequentialRandom {
    private int i = 0;
    private static int j = 0;
    private static int counter = 0;
    private static Random random = new Random();

    public SequentialRandom() {
        if ( counter == 0 ){
            j = random.nextInt();
            i = j;
        } else {
            j++;
            i = j;
        }
        counter++;
    }

    public int getI() {
        return i;
    }
    public void resetRandom() {
        counter = 0;
    }

    @Override
    public String toString() {
        return "SequentialRandom{" +
                "i=" + i +
                '}';
    }
}
