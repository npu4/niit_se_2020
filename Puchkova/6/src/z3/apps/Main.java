package z3.apps;

import z1.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Triple<String,Double,Double>> listOfApps = new ArrayList<>();

        listOfApps.add(new Triple<>("ZOOM Cloud Meetings", 52396d, 4.5));
        listOfApps.add(new Triple<>("Номерограм - проверка авто", 30626d, 4.8));
        listOfApps.add(new Triple<>("Tik Tok - Trends Start Here", 591517d, 4.6));
        listOfApps.add(new Triple<>("Telegram Messenger", 77985d, 4.3));
        listOfApps.add(new Triple<>("WhatsApp Messenger", 1878771d, 4.5));

        System.out.println("Приложения, отсортированные по количеству оценок:");
        printSortedListBySecond(listOfApps);

        appBestRating(listOfApps);

        appWorstRating(listOfApps);
    }

    static List<Triple<String,Double,Double>> sortBySecond(List<Triple<String,Double,Double>> list){
        list.sort(Comparator.comparingDouble(Triple::getSecond));
        return list;
    }

    static void printSortedListBySecond(List<Triple<String,Double,Double>> list){
        List<Triple<String,Double,Double>> sortedList = sortBySecond(list);
        for (Triple<String, Double, Double> stringDoubleDoubleTriple : sortedList) {
            System.out.println(stringDoubleDoubleTriple.getFirst() + " --- " + stringDoubleDoubleTriple.getSecond() + " --- " + stringDoubleDoubleTriple.getThird());
        }
        System.out.println();
    }

    static void appBestRating(List<Triple<String,Double,Double>> list){
        String app = " ";
        Double bestRating = 0.;
        for (Triple<String, Double, Double> stringDoubleDoubleTriple : list) {
            if (stringDoubleDoubleTriple.getThird() > bestRating) {
                bestRating = stringDoubleDoubleTriple.getThird();
                app = stringDoubleDoubleTriple.getFirst();
            }
        }
        System.out.println("Приложение с лучшим рейтингом: " + app);
    }

    static void appWorstRating(List<Triple<String,Double,Double>> list){
        String app = " ";
        Double bestRating = Double.MAX_VALUE;
        for (Triple<String, Double, Double> stringDoubleDoubleTriple : list) {
            if (stringDoubleDoubleTriple.getThird() < bestRating) {
                bestRating = stringDoubleDoubleTriple.getThird();
                app = stringDoubleDoubleTriple.getFirst();
            }
        }
        System.out.println("Приложение с худшим рейтингом: " + app);
    }
}
