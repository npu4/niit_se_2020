import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();

        List<Pair<Animal, String>> animals = new ArrayList<>();
        animals.add(new Pair<>(new Animal("Tom", "Cat"), "Fish"));
        animals.add(new Pair<>(new Animal("Spike", "Dog"), "Bone"));
        animals.add(new Pair<>(new Animal("Jerry", "Mouse"), "Cheese"));

        util.feedAnimals(animals);
        System.out.println();

        List<Triple<String, GasType, Double>> gasStations = new ArrayList<>();
        gasStations.add(new Triple<>("Pushkin st.", GasType.DT, 32d));
        gasStations.add(new Triple<>("Lermontov st.", GasType.DT, 30d));
        gasStations.add(new Triple<>("Esenin st.", GasType.AI_95, 50d));

        util.findBestPrice(gasStations, GasType.DT);
        System.out.println();

        List<Triple<String, Integer, Integer>> apps = new ArrayList<>();
        apps.add(new Triple<>("Messenger", 1200, 5));
        apps.add(new Triple<>("Game", 2000, 4));
        apps.add(new Triple<>("Maps", 1000, 3));

        util.sortByAmountOfRating(apps);
        util.findBestApp(apps);
        util.findWorstApp(apps);
    }
}
