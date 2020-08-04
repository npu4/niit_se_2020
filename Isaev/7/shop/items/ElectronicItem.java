package shop.items;

import java.util.Random;

public class ElectronicItem extends ShopItem {

   private static final int[] powers = {100, 150, 200, 250, 300};
   private static final int[] prices = {10000, 15000, 20000, 25000, 30000};
   private final int powerConsumption;

   public ElectronicItem(String itemName) {
      super(itemName, prices[new Random().nextInt(prices.length - 1)]);
      this.powerConsumption = powers[new Random().nextInt(powers.length - 1)];
   }

   public int getPowerConsumption() {
      return powerConsumption;
   }

   @Override
   public String toString() {
      return this.getItemName();
   }
}
