import fabrics.AppleGarden;
import fabrics.ElectronicFabric;
import fabrics.FoodFactory;
import products.*;
import visitors.ElectronicAddictedVisitor;
import visitors.ImJustLookingVisitor;
import visitors.RichVisitor;

import java.util.*;

public class MainCollection {
    public static void main(String[] args) {
        ArrayList <ShopItem> giperMarket = new ArrayList<>();
        ArrayList<ElectronicItem> electronicShop = new ArrayList<>();
        ArrayList <FoodItem> foodShop = new ArrayList<>();
        ArrayList <Apple> miniMarket = new ArrayList<>();

        ElectronicFabric electronicFabricForElectronicShop = new ElectronicFabric(electronicShop,"магазин электроники");
        electronicFabricForElectronicShop.fillShopWithElectronicGoods();
        ElectronicFabric electronicFabricForGiperMarket = new ElectronicFabric(giperMarket,"гипермаркет");
        electronicFabricForGiperMarket.fillShopWithElectronicGoods();

        AppleGarden appleGardenForGiperMarket = new AppleGarden(giperMarket,"гипермаркет");
        appleGardenForGiperMarket.fillShopWithApple();
        AppleGarden appleGardenForFoodShop = new AppleGarden(foodShop,"продуктовый магазин");
        appleGardenForFoodShop.fillShopWithApple();
        AppleGarden appleGardenForMinimarket = new AppleGarden(miniMarket,"ларек с яблоками у дома ");
        appleGardenForMinimarket.fillShopWithApple();

        FoodFactory foodFactoryForGiperMarket = new FoodFactory(giperMarket,"гипермаркет");
        foodFactoryForGiperMarket.fillShopWithFood();
        FoodFactory foodFactoryForFoodShop = new FoodFactory(foodShop,"продуктовый магазин");
        foodFactoryForFoodShop.fillShopWithFood();

        ElectronicAddictedVisitor electronicShopVisitVasyua = new ElectronicAddictedVisitor
                (electronicShop,"Вася"," магазин электроники");
        electronicShopVisitVasyua.visitShop();
        ImJustLookingVisitor electronicShopVisitMaxim = new ImJustLookingVisitor(electronicShop, "Максим"," магазин электроники ");
        electronicShopVisitMaxim.visitShop();

        ImJustLookingVisitor giperMarketVisitMaxim1 = new ImJustLookingVisitor(giperMarket, "Максим"," гипермаркет ");
        giperMarketVisitMaxim1.visitShop();
        RichVisitor giperMarketVisirRichGriha = new RichVisitor(giperMarket, "Богатый Гриша"," гипермаркет ");
        giperMarketVisirRichGriha.visitShop();
        ImJustLookingVisitor giperMarketVisitPetr1 = new ImJustLookingVisitor(giperMarket, "Петя"," гипермаркет ");
        giperMarketVisitPetr1.visitShop();

        ImJustLookingVisitor foodShopVisitMaxim = new ImJustLookingVisitor(foodShop, "Максим"," продуктовый магазин ");
        foodShopVisitMaxim.visitShop();
        RichVisitor foodShopVisitRichGriha = new RichVisitor(foodShop, "Богатый Гриша"," продуктовый магазин ");
        foodShopVisitRichGriha.visitShop();
        ImJustLookingVisitor foodShopVisitMaxim1 = new ImJustLookingVisitor(foodShop, "Максим"," продуктовый магазин ");
        foodShopVisitMaxim1.visitShop();

        ImJustLookingVisitor minimMarketVisitMaxim = new ImJustLookingVisitor(miniMarket, "Максим"," ларек с яблоками у дома ");
        minimMarketVisitMaxim.visitShop();
        RichVisitor minimMarketVisitRichGriha = new RichVisitor(miniMarket, "Богатый Гриша"," ларек с яблоками у дома ");
        minimMarketVisitRichGriha.visitShop();
        ImJustLookingVisitor minimMarketVisitMaxim1 = new ImJustLookingVisitor(miniMarket, "Максим"," ларек с яблоками у дома ");
        minimMarketVisitMaxim1.visitShop();

    }
}

