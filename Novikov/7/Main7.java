import java.util.ArrayList;
import java.util.Collection;

public class Main7 {

    static Collection<ShopItem> allShop = new ArrayList<>();
    static Collection<ElectronicItem> electronicShop = new ArrayList<>();
    static Collection<FoodItem> foodShop = new ArrayList<>();
    static Collection<Apple> appleShop = new ArrayList<>();

    public static void main(String[] args) {

        initializeShops();
        System.out.println("\nImJustLookingVisitor:");

        ImJustLookingVisitor looker = new ImJustLookingVisitor();
        looker.visitShop(allShop);
        looker.visitShop(electronicShop);
        looker.visitShop(foodShop);
        looker.visitShop(appleShop);

        System.out.println("\nElectronicAddictedVisitor:");

        ElectronicAddictedVisitor addictedVisitor = new ElectronicAddictedVisitor();
        addictedVisitor.visitShop(allShop);
        addictedVisitor.visitShop(electronicShop);
        addictedVisitor.visitShop(foodShop);
        addictedVisitor.visitShop(appleShop);

        System.out.println("\nRichVisitor:");

        RichVisitor richVisitor = new RichVisitor();
        System.out.println("\nГипермаркет:");
        richVisitor.visitShop(allShop);
        System.out.println("\nМагазин электроники:");
        richVisitor.visitShop(electronicShop);
        System.out.println("\nМагазин пропитания:");
        richVisitor.visitShop(foodShop);
        System.out.println("\nМагазин с яблоками:");
        richVisitor.visitShop(appleShop);
    }

    public static void initializeShops() {
        ElectronicFabric.fillShopWithElectronicGoods(electronicShop);
        ElectronicFabric.fillShopWithElectronicGoods(allShop);

        AppleGarden.fillShopWithApples(appleShop);

        FoodFactory.fillShopWithFood(allShop);
        FoodFactory.fillShopWithFood(foodShop);
    }








}

