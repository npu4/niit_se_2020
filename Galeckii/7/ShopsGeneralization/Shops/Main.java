package Shops;

import Shops.factories.AppleGarden;
import Shops.factories.ElectronicFabric;
import Shops.factories.FoodFactory;
import Shops.items.Apple;
import Shops.items.ElectronicItem;
import Shops.items.FoodItem;
import Shops.items.ShopItem;
import Shops.visitors.ElectronicAddictedVisitor;
import Shops.visitors.ImJustLookingVisitor;
import Shops.visitors.RichVisitor;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    static Collection<ShopItem> hypermarket = new ArrayList<>();
    static Collection<ElectronicItem> electronicStore = new ArrayList<>();
    static Collection<FoodItem> groceryStore = new ArrayList<>();
    static Collection<Apple> appleShop = new ArrayList<>();

    public static void main(String[] args) {
        initializeShops();
        System.out.println("\nImJustLookingVisitor:");

        ImJustLookingVisitor looker = new ImJustLookingVisitor();
        looker.visitShop(hypermarket);
        looker.visitShop(electronicStore);
        looker.visitShop(groceryStore);
        looker.visitShop(appleShop);

        System.out.println("\nElectronicAddictedVisitor:");

        ElectronicAddictedVisitor addictedVisitor = new ElectronicAddictedVisitor();
        addictedVisitor.visitShop(hypermarket);
        addictedVisitor.visitShop(electronicStore);
        addictedVisitor.visitShop(groceryStore);
        addictedVisitor.visitShop(appleShop);

        System.out.println("\nRichVisitor:");

        RichVisitor richVisitor = new RichVisitor();
        richVisitor.visitShop(hypermarket);
        richVisitor.visitShop(electronicStore);
        richVisitor.visitShop(groceryStore);
        richVisitor.visitShop(appleShop);
    }

    public static void initializeShops() {
        ElectronicFabric.fillShopWithElectronicGoods(electronicStore);
        ElectronicFabric.fillShopWithElectronicGoods(hypermarket);

        AppleGarden.fillShopWithApples(hypermarket);
        AppleGarden.fillShopWithApples(groceryStore);
        AppleGarden.fillShopWithApples(appleShop);

        FoodFactory.fillShopWithFood(hypermarket);
        FoodFactory.fillShopWithFood(groceryStore);
    }
}
