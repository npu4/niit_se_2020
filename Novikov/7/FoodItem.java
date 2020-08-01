public class FoodItem extends  ShopItem {

    int calorie;
    int shelfLife;

    public FoodItem(String name, int price, int calorie, int shelfLife) {
        super(name, price);
        this.calorie = calorie;
        this.shelfLife = shelfLife;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }
}
