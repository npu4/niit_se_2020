import java.util.ArrayList;
import java.util.List;

public class Main6 {



        public static void main(String[] args) {

            List<Pair<Animal, String>> animals = new ArrayList<>();
            animals.add(new Pair<>(new Animal("Барсик", "Кот"), "Рыба"));
            animals.add(new Pair<>(new Animal("Муса", "Собака"), "Мясо"));
            animals.add(new Pair<>(new Animal("Окей", "Крыса"), "Сыр"));
            Metods.feedAnimals(animals);


            List<Triple<String,Petrol,Double>> gasStation = new ArrayList<>();
            gasStation.add(new Triple<>("Адрес1", Petrol.AI_92, 70.0) );
            gasStation.add(new Triple<>("Адрес2", Petrol.AI_92, 78.0) );
            gasStation.add(new Triple<>("Адрес3", Petrol.AI_92, 60.0) );
            Metods.findBestPrice(gasStation,Petrol.AI_92 );

            List<Triple<String,Double,Double>> applications = new ArrayList<>();
            applications.add(new Triple<>("A1", 30.0, 5.0) );
            applications.add(new Triple<>("А2", 20.0, 1.0) );
            applications.add(new Triple<>("А3", 44.0, 3.0) );
            Metods.rating(applications);
            Metods.badRating(applications);
            Metods.bestRating(applications);

        }
    }


