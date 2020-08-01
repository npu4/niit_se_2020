public class Bread extends FoodItem {

    int weight;

    public Bread(String name, int price, int calorie, int shelfLife, int weight) {
        super(name, price, calorie, shelfLife);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
