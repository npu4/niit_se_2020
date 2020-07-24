import java.util.List;
import java.util.Random;

public class Util {
    public void feedAnimals(List<Pair<Animal, String>> list) {
        for (Pair<Animal, String> target : list) {
            System.out.printf("Животное %s с радостью съедает %s\n", target.getFirst().getName(), target.getSecond());
        }

        int random = new Random().nextInt(list.size());
        System.out.printf("Счастливое животное %s получает двойную порцию %s\n",
                list.get(random).getFirst().getName(), list.get(random).getSecond());
    }

    public void findBestPrice(List<Triple<String, GasType, Double>> list, GasType type) {
        double min = Double.MAX_VALUE;
        String address = "";
        for (Triple<String, GasType, Double> gasStation : list) {
            if (gasStation.getSecond() == type && gasStation.getThird() < min) {
                min = gasStation.getThird();
                address = gasStation.getFirst();
            }
        }

        System.out.printf("Заправка на %s имеет самую низкую цену на %s в размере %f\n", address, type.name(), min);
    }

    public void sortByAmountOfRating(List<Triple<String, Integer, Integer>> apps) {
        apps.sort(new AppAmountOfRatingComparator());
        System.out.println("Приложения отсортированные по количеству оценок:");
        System.out.println(apps);
    }

    public void findBestApp(List<Triple<String, Integer, Integer>> apps) {
        int max = 0;
        String bestApp = "";
        for (Triple<String, Integer, Integer> app : apps) {
            if (app.getThird() > max) {
                max = app.getThird();
                bestApp = app.getFirst();
            }
        }
        System.out.printf("%s имеет самую высокую оценку %d\n", bestApp, max);
    }

    public void findWorstApp(List<Triple<String, Integer, Integer>> apps) {
        int min = Integer.MAX_VALUE;
        String worstApp = "";
        for (Triple<String, Integer, Integer> app : apps) {
            if (app.getThird() < min) {
                min = app.getThird();
                worstApp = app.getFirst();
            }
        }
        System.out.printf("%s имеет самую низкую оценку %d\n", worstApp, min);
    }
}
