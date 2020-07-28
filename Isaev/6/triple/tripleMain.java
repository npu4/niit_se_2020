package triple;

import java.util.Arrays;
import java.util.List;

public class tripleMain {

    public static void main(String[] args) throws Exception {
        Triple<String, Integer,Integer> tripleValue = new Triple<>("Vasya",25,7);
        System.out.println(tripleValue.getFirst());
        System.out.println(tripleValue.getSecond());
        System.out.println(tripleValue.getThird());
    }

}
