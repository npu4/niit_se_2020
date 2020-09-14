package shop.items;

public class FoodItem extends ShopItem {
    private Double calorie;
    private Integer shelfLife;

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }
}
