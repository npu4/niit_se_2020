package shop;

import shop.items.Apple;
import shop.items.ElectronicItem;
import shop.items.FoodItem;
import shop.items.ShopItem;
import shop.visitors.ElectronicAddictedVisitor;
import shop.visitors.ImJustLookingVisitor;
import shop.visitors.RichVisitor;

import java.util.ArrayList;
import java.util.Collection;

import static shop.factories.AppleGarden.fillShopWithApples;
import static shop.factories.ElectronicFabric.fillShopWithElectronicGoods;
import static shop.factories.FoodFactory.fillShopWithFood;

public class Main {
    public static void main(String[] args) {
        Collection<ShopItem> hypermarket = new ArrayList<>();
        Collection<ElectronicItem> electronicProductsStore = new ArrayList<>();
        Collection<FoodItem> groceryStore = new ArrayList<>();
        Collection<Apple> appleStall = new ArrayList<>();

        fillShopWithElectronicGoods(hypermarket);
        fillShopWithElectronicGoods(electronicProductsStore);

        fillShopWithApples(hypermarket);
        fillShopWithApples(groceryStore);
        fillShopWithApples(appleStall);

        fillShopWithFood(hypermarket);
        fillShopWithFood(groceryStore);

        ImJustLookingVisitor imJustLookingVisitor = new ImJustLookingVisitor();
        imJustLookingVisitor.visitShop(hypermarket);
        imJustLookingVisitor.visitShop(electronicProductsStore);
        imJustLookingVisitor.visitShop(groceryStore);
        imJustLookingVisitor.visitShop(appleStall);

        ElectronicAddictedVisitor electronicAddictedVisitor = new ElectronicAddictedVisitor();
        electronicAddictedVisitor.visitShop(hypermarket);
        electronicAddictedVisitor.visitShop(electronicProductsStore);
        electronicAddictedVisitor.visitShop(groceryStore);
        electronicAddictedVisitor.visitShop(appleStall);

        RichVisitor richVisitor = new RichVisitor();
        richVisitor.visitShop(hypermarket);
        richVisitor.visitShop(electronicProductsStore);
        richVisitor.visitShop(groceryStore);
        richVisitor.visitShop(appleStall);
    }
}
