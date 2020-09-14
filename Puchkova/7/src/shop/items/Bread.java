package shop.items;

public class Bread extends FoodItem{
    private Integer weight;
    private static int counter;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Bread(Integer price, Integer weight){
        this.setName("Хлеб № " + ++counter);
        this.setPrice(price);
        this.weight = weight;
    }
}
