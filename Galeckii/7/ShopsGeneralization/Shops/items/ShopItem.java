package Shops.items;

public abstract class ShopItem {
    String name;
    int price;

    public ShopItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
