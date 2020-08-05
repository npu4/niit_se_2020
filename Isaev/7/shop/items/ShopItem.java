package shop.items;

public abstract class ShopItem {

   private final String itemName;
   private final int salePrice;

   public ShopItem(String itemName, int salePrice) {
      this.itemName = itemName;
      this.salePrice = salePrice;
   }

   public String getItemName() {
      return itemName;
   }

   public int getSalePrice() {
      return salePrice;
   }

   @Override
   public String toString() {
      return "ShopItem{" +
              "itemName='" + itemName + '\'' +
              ", salePrice=" + salePrice +
              '}';
   }
}
