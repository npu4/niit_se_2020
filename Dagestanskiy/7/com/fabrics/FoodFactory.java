package fabrics;

import products.Bread;
import products.FoodItem;

import java.util.ArrayList;

public class FoodFactory {
    ArrayList<? super FoodItem> fooditems;
    String name;

    public FoodFactory(ArrayList<? super FoodItem> fooditems, String name) {
        this.fooditems = fooditems;
        this.name = name;
    }

    public ArrayList<? super FoodItem> fillShopWithFood() {
        AppleGarden appleGardenForMinimarket = new AppleGarden(fooditems,name);
        appleGardenForMinimarket.fillShopWithApple();

        ArrayList<Bread>addbreads = new ArrayList<>();
        addbreads.add( new Bread("Хлеб Бородинский", 40d,1000 ,10,600 ));
        addbreads.add( new Bread("Хлеб Карельский", 38d,1200 ,6,400 ));
        addbreads.add( new Bread("Хлеб Совитал", 30d,1000 ,8,500 ));
        fooditems.addAll(addbreads);
        System.out.println("В "+name+" добавлен хлеб :");
        int totalWeight =0;
        for (Bread addbread : addbreads) {
            System.out.println(addbread.getWeight());
            totalWeight += addbread.getWeight();
        }
        System.out.println("Общим весом :"+totalWeight);
        return fooditems;
    }

}
