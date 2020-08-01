
import java.util.Collection;
public class AppleGarden {

    public static void fillShopWithApples(Collection<? super Apple> shop) {
        String[] names = new String[3];
        names[0]="Зеленые";
        names[1]="Красные";
        names[2]="Желтые";
        shop.add(new Apple("Антоновка", 10, 300, 20, names[0]));
        shop.add(new Apple("Айдаред", 20, 500, 30, names[1]));
        shop.add(new Apple("Грушевка", 5, 150, 3, names[2]));
        shop.add(new Apple("Садовые", 3, 356, 7, names[2]));
        shop.add(new Apple("Дичок", 8, 40, 20, names[0]));
        System.out.println("В магазин добавлены яблоки следующих цветов: ");
        for(int i=0; i<names.length;i++){
            System.out.println(names[i]);
        }


    }

}
