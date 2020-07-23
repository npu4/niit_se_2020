import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ListIteratorExample {

    public static void main(String[] args) {


        ArrayList<Double> numbers = new ArrayList<>();


        numbers.addAll(Arrays.asList(1d, 2d, 3d, 4d, 5d, 7d, 8d));


        final ListIterator<Double> integerListIterator = numbers.listIterator(numbers.size());

        while (integerListIterator.hasPrevious()) {
            final Double previous = integerListIterator.previous();
            System.out.println(previous);
            if (previous == 4){
                integerListIterator.set(42d);
            }
        }

        System.out.println(numbers);
    }
}
