package fabrics;
import products.ElectronicItem;
import products.Refrigerator;
import products.TV;

import java.util.ArrayList;
import java.util.Collection;

public class ElectronicFabric {
    ArrayList<? super ElectronicItem> electronicItems;
    String name;

    public ElectronicFabric(ArrayList<? super ElectronicItem> electronicItems, String name) {
        this.electronicItems = electronicItems;
        this.name = name;
    }

    public ArrayList<? super ElectronicItem> getElectronicItems() {
        return electronicItems;
    }
    public ArrayList<?super ElectronicItem> fillShopWithElectronicGoods(){
        ArrayList<ElectronicItem> addElectronics = new ArrayList<>();
        addElectronics.add( new TV("Телевизор Хитачи", 40000d, 20d,100));
        addElectronics.add( new TV("Телевизор Филипс", 45000d, 30d,110));
        addElectronics.add( new TV("Телевизор Сименс", 42000d, 25d,105));
        addElectronics.add( new Refrigerator("Холодильник Либхер", 70000d, 500d,300));
        addElectronics.add( new Refrigerator("Холодильник Норд", 30000d, 300d,200));
        addElectronics.add( new Refrigerator("Холодильник Саратов", 28000d, 300d,180));
        electronicItems.addAll(addElectronics);
        System.out.println("B "+name+" добавлена электроника: ");
        for (ElectronicItem addElectronic : addElectronics) {
            System.out.println(addElectronic.getProductName());
        }
        return electronicItems;
    }
}
