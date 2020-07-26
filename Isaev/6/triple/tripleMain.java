package triple;

import java.util.Arrays;
import java.util.List;

public class tripleMain {

    public static void main(String[] args) throws Exception {
        Triple<String, List> tripleValue = new Triple<String, List>("Vasya", Arrays.asList(25,7));
        System.out.println(tripleValue.getFirst());
        System.out.println(tripleValue.getSecond());
        System.out.println(tripleValue.getThird());
    }

}
