package z1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> firstPerson = new Pair<> ("Пупкин", 18);
        String lastName1 = firstPerson.getFirst();
        Integer age1 = firstPerson.getSecond();
        firstPerson.println();

        Pair<String, List<String>> secondPerson = new Pair<>("Пупкин", Arrays.asList("+7 831 2112233", "+7 920 000 22 22"));
        String lastName2 = secondPerson.getFirst();
        List<String> phoneNumbers2 = secondPerson.getSecond();
        secondPerson.println();

        Triple<String, Integer, List<String>> thirdPerson = new Triple<> ("Пупкин", 22, Arrays.asList("+7 831 2112233", "+7 920 000 22 22"));
        String lastName3 = thirdPerson.getFirst();
        Integer age3 = thirdPerson.getSecond();
        List<String> phoneNumbers3 = thirdPerson.getThird();
        thirdPerson.println();
    }
}
