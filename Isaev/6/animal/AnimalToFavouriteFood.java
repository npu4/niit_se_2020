package animal;

public class AnimalToFavouriteFood<Animal,String>{

    Animal animal;
    String favouriteFood;

    public AnimalToFavouriteFood(Animal animal, String favouriteFood) {
        this.animal = animal;
        this.favouriteFood = favouriteFood;
    }

    /*
        public AnimalToFavouriteFood(String name, String type, String favouriteFood) {
        this.animal = new Animal(name,type);
        this.favouriteFood = favouriteFood;
    }
    */

    @Override
    public java.lang.String toString() {
        return "AnimalToFavouriteFood{" +
                "animal=" + animal +
                ", favouriteFood=" + favouriteFood +
                '}';
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }


}
