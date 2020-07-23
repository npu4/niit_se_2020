import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ItarableTest {



    static class MyIterable implements Iterable<String>{

        @Override
        public Iterator<String> iterator() {
            return null;
        }
    }

    public static void main(String[] args) {


        List<Integer> intList =new ArrayList<>();


        intList.addAll(Arrays.asList(3, 4, 5, 7, 8));


        final Iterator<Integer> iterator = intList.iterator();

        System.out.println(intList);

        while (iterator.hasNext()) {
            final Integer next = iterator.next();

            if (next %2 == 0) {
                iterator.remove();
            }
        }


        for (String  in : new MyIterable()) {

        }

        System.out.println(intList);
    }
}
