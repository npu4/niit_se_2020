import java.util.Comparator;

public class AppAmountOfRatingComparator implements Comparator<Triple<String, Integer, Integer>> {
    @Override
    public int compare(Triple<String, Integer, Integer> o1, Triple<String, Integer, Integer> o2) {
        return o1.getSecond().compareTo(o2.getSecond());
    }
}
