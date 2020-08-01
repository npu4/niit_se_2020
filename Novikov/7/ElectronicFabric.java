import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;


public class ElectronicFabric {

   static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> shop){
        String[] names = new String[5];
            names[0]="TV1";
            names[1]="TV2";
            names[2]="TV3";
            names[3]="R1";
            names[4]="R2";
            shop.add(new TV(names[0],500, 20,30));
            shop.add(new TV(names[1],300, 40,15));
            shop.add(new TV(names[2],1000, 10,70));
            shop.add(new Refrigerator(names[3],400,20, 800));
            shop.add(new Refrigerator(names[4],1200,40, 1800));
            System.out.println("В магазин  электроники добавлена электроника: ");
            for(int i=0; i<names.length;i++){
                System.out.println(names[i]);
            }
        }


}
