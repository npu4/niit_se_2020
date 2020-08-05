package shop;

import shop.fabrics.AppleGarden;
import shop.fabrics.ElectronicFabric;
import shop.fabrics.FoodFactory;
import shop.items.ElectronicItem;
import shop.items.FoodItem;
import shop.items.ShopItem;
import shop.products.Apple;
import shop.visitors.ElectronicAddictedVisitor;
import shop.visitors.IAmJustLookingVisitor;
import shop.visitors.RichVisitor;

import java.util.ArrayList;
import java.util.Collection;

public class shopMain {

    public static void main(String[] args) {
        ElectronicFabric electronicFabric = new ElectronicFabric();
        AppleGarden appleGarden = new AppleGarden();
        FoodFactory foodFactory = new FoodFactory();

        ElectronicAddictedVisitor electronicAddictedVisitor = new ElectronicAddictedVisitor();
        IAmJustLookingVisitor iAmJustLookingVisitor = new IAmJustLookingVisitor();
        RichVisitor richVisitor = new RichVisitor();

        Collection<ShopItem> itemShop = new ArrayList<>();
        Collection<ShopItem> itemShopOne = new ArrayList<>();
        Collection<ShopItem> itemShopTwo = new ArrayList<>();
        Collection<ElectronicItem> electronicShop = new ArrayList<>();
        Collection<FoodItem> foodShop = new ArrayList<>();
        Collection<FoodItem> foodShopOne = new ArrayList<>();
        Collection<Apple> appleShop = new ArrayList<>();

        electronicFabric.fillShopWithElectronicGoods(itemShop, 5);
        electronicFabric.fillShopWithElectronicGoods(electronicShop, 5);

        appleGarden.fillShowWithApples(foodShop, 5);
        appleGarden.fillShowWithApples(appleShop, 5);
        appleGarden.fillShowWithApples(itemShopOne, 5);

        foodFactory.fillShopWithFood(foodShopOne, 5);
        foodFactory.fillShopWithFood(itemShopTwo, 5);

        electronicAddictedVisitor.visitShop(itemShop);
        electronicAddictedVisitor.visitShop(electronicShop);
        iAmJustLookingVisitor.visitShop(itemShop);
        richVisitor.visitShop(electronicShop);


    }

}
