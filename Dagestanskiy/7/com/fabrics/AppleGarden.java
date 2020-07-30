package fabrics;

import products.Apple;

import java.util.ArrayList;

public class AppleGarden {
    ArrayList<? super Apple> apples;
    String name;

    public AppleGarden(ArrayList<? super Apple> apples, String name) {
        this.apples = apples;
        this.name = name;
    }

    public ArrayList<? super Apple> fillShopWithApple(){
        ArrayList<Apple> addApples = new ArrayList<>();
        addApples.add( new Apple("Яблоко Антоновка", 50d, 100, 60, "зелёный"));
        addApples.add( new Apple("Яблоко Грушовка", 50d,100 ,60,"розовый" ));
        addApples.add( new Apple("Яблоко Звездочка", 40d,90 ,60,"красный" ));
        addApples.add( new Apple("Яблоко Китайка", 20d ,30 ,60 , "жёлтый"));
        addApples.add( new Apple("Яблоко Лобо", 20d ,30 ,60 , "пурпурное"));
        apples.addAll(addApples);
        System.out.println("В "+name+" добавлены яблоки :");
        for(Apple addApple : addApples) {
            System.out.println(addApple.getColour());
        }

        return apples;
    }

}
