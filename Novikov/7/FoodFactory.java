
import java.util.Collection;
public class FoodFactory {

    public static void fillShopWithFood(Collection<? super FoodItem> shop) {
        String[] colour = new String[2];
        colour[0]="Зеленые";
        colour[1]="Красные";
        int [] weight=new int[3];
        int allWeight=0;
        weight[0]=300;
        weight[1]=600;
        weight[2]=900;
        for(int i=0; i<weight.length;i++){
            allWeight=allWeight+weight[i];
        }


        shop.add(new Apple("Антоновка", 10, 300, 20, colour[0]));
        shop.add(new Apple("Айдаред", 20, 500, 30, colour[1]));
        shop.add(new Apple("Дичок", 8, 40, 20, colour[0]));
        shop.add(new Bread("Буханка", 8, 40, 20, weight[0]));
        shop.add(new Bread("Ржаной", 12, 400, 20, weight[1]));
        shop.add(new Bread("Каравай", 40, 500, 20, weight[2]));
        System.out.println("В магазин продовольствия добавлены яблоки следующих цветов: ");
        for(int i=0; i<colour.length;i++){
            System.out.println(colour[i]+"\n");
        }
        System.out.println("И хлеб общим весом: " + allWeight+ " грамм.");

    }
}
