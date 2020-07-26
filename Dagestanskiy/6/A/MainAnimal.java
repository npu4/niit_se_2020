import java.util.ArrayList;
import java.util.List;

public class MainAnimal {
    public static void main(String[] args) {

        List<Pair<Animal,String>> listAnimals = new ArrayList<>();
        listAnimals.add(new Pair<>(new Animal("Кот","Пушок"), "Лосось"));
        listAnimals.add(new Pair<>(new Animal("Пес","Шарик"), "Мясо"));
        listAnimals.add(new Pair<>(new Animal("Попугай","Кеша"), "Просо"));
        listAnimals.add(new Pair<>(new Animal("Корова", "Маша"), "Сено"));

        feedAnimals(listAnimals);

    }

    public static void feedAnimals (List<Pair<Animal, String>> array) {

        int luckyNumber = rnd(0, array.size()-1);
        System.out.println("Животных в списке: "+array.size()+". Счасливый номер - "+luckyNumber+".\n");
        for (int i = 0; i <array.size() ; i++) {
            Animal animal = array.get(i).getFirst();
            String strPrint = i==luckyNumber ? "Счастливое животное: "+animal.getTypeAnimal() +" "+
                    animal.getName()+" получает двойную порцию - " + array.get(i).getSecond()+"." :
                    "Животное: "+animal.getTypeAnimal() +" "+
                            animal.getName()+" с радостью съедает - " + array.get(i).getSecond()+"." ;
            System.out.println(strPrint);
        }

    }
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
